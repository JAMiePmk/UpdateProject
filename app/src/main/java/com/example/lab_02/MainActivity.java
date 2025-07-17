package com.example.lab_02;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public static void main(String[] args) {
        Note note1 = new Note();
        Note note2 = new Note();
        Note note3 = new Note();

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();

        note1.title = "lab 01 ";
        note1.context = "info lab 01";
        note1.createdDate = "2025.1.17";

        note2.title = "lab 02";
        note2.context = "info lab 02";
        note2.createdDate = "2025.2.15";

        note3.title = "lab 03";
        note3.context = "info lab 03";
        note3.createdDate = "2024.12.9";

        user1.userName = "Gummi";
        user1.password = "11234GGs";
        user1.gmail = "1234@email.com";

        user2.userName =  " Jamie";
        user2.password = "2134hgf";
        user2.gmail = "Jamie13@gmail.com";

        user3.userName = "Gummie";
        user3.password = "545467gif";
        user3.gmail = "arainear@email.com";

    }
}