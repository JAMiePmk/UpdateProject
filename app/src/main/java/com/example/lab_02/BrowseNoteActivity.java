package com.example.lab_02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BrowseNoteActivity extends AppCompatActivity {
    Button Backbutton,Searchbutton;
    ProgressBar progressBar;
    TextView display,showNote,showNoteForAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browse_note);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       Backbutton = findViewById(R.id.button5);
       Backbutton.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View view) {
               Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
               startActivity(MainActivity);
           }
       });

       showNote = findViewById(R.id.textView5);
       showNoteForAPI = findViewById(R.id.textView6);

       Executors.newSingleThreadExecutor().execute(() -> {
                   List<NoteEntity> entities = AppDatabase.getInstance(this).noteDao().getAll();
                   List<Note> notes = new ArrayList<>();
                   for (NoteEntity e : entities) {
                       notes.add(NoteMapper.fromEntity(e));
                   }

                   runOnUiThread(() -> {
                       StringBuilder sb = new StringBuilder();
                       for (Note n : notes) {
                           sb.append(n.getSummary()).append("\n");
                       }
                       showNote.setText(sb.toString());
                   });
               });

       Retrofit retrofit = new Retrofit.Builder()
               .baseUrl("https://jsonplaceholder.typicode.com/")
               .addConverterFactory(GsonConverterFactory.create())
               .build();
       ApiService apiService = retrofit.create(ApiService.class);
       Call<List<TextNote>> call = apiService.getTextNote();

       call.enqueue(new Callback<List<TextNote>>() {
                   @Override
                   public void onResponse(Call<List<TextNote>> call, Response<List<TextNote>> response) {
                       if (!response.isSuccessful()) {
                          showNoteForAPI.setText("Error Code: " + response.code());
                          return;

                       }
                   List<TextNote> notes = response.body();
                       StringBuilder builder = new StringBuilder();
                       for (TextNote n : notes) {
                           builder.append("Title: ").append(n.getTitle()).append("\n")
                                   .append("body: ").append(n.getTextContent()).append("\n\n");
                       }
                       showNoteForAPI.setText(builder.toString());
                   }
                   @Override
                   public void onFailure(Call<List<TextNote>> call, Throwable t) {
                       showNoteForAPI.setText("Error: " + t.getMessage());
                   }
       });


       Searchbutton = findViewById(R.id.button6);
       progressBar = findViewById(R.id.progressBar2);
       progressBar.setVisibility(View.GONE);
       display = findViewById(R.id.textView4);
       Searchbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               //show progress bar
               progressBar.setVisibility(View.VISIBLE);

               //create new thread
               new Thread(() -> {
                   //delay 2 sec
                   try {
                       Thread.sleep(2000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   //load data from database

                   runOnUiThread(() -> {
                       progressBar.setVisibility(View.GONE);

                       display.setText ("Not Found");

                   });

               }).start();
           }
       });
    }
}