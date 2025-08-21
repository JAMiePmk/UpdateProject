package com.example.lab_02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class AddNoteActivity extends AppCompatActivity {

    Button BackButton,AddButton;
    EditText title,content;

    TextView display;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        BackButton = findViewById(R.id.button2);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Click ");
                Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(MainActivity);
            }

        });


        AddButton = findViewById(R.id.button3);
        title = findViewById(R.id.editTextText);
        content = findViewById(R.id.editTextText2);
        display = findViewById(R.id.textView3);

        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Added");
                //get data from suer (EditText)
                String strOfTitle = title.getText().toString();
                String strOfContent = content.getText().toString();
                String strOfdate = new Date().toString();

                //set data to textnote

                TextNote note1 = new TextNote();
               note1.title = strOfTitle;

               note1.setTextContent(strOfContent);

               note1.createdDate = strOfdate;

               //show note on display
               display.setText(note1.getSummary());


            }

        });
    }
}