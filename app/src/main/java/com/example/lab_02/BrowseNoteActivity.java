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

public class BrowseNoteActivity extends AppCompatActivity {
    Button Backbutton,Searchbutton;
    ProgressBar progressBar;
    TextView display;

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