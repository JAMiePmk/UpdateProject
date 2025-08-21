package com.example.lab_02;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button addButton,BrowseButton;
    ProgressBar progressBar;

    @SuppressLint("MissingInflatedId")
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

        addButton = findViewById(R.id.button);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                System.out.println("Click ");
                Intent addNoteActivity = new Intent(getApplicationContext(),AddNoteActivity.class);
                startActivity(addNoteActivity);
            }

        });
        addButton = findViewById(R.id.button4);

        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        addButton.setOnClickListener(new View.OnClickListener() {
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

                        //back to main thread
                        runOnUiThread(() -> {
                            progressBar.setVisibility(View.GONE);
                            //goto browse note activity
                            Intent BrowseNoteActivity = new Intent(getApplicationContext(), BrowseNoteActivity.class);
                            startActivity(BrowseNoteActivity);
                        });




                }).start();

            }
        });

    }

//    public static void main(String[] args) {
//        //สร้าง NormalUser
//        NormalUser normalUser = new NormalUser("Gummi", "10111101", "1234@gmail.com");
//        //สร้าง Admin
//        Admin admin = new Admin("Jamie", "1305", "Jamie@gmail.com");
//        TextNote textNote1 = new TextNote();
//
//        textNote1.title ="OOP homework";
//        textNote1.setTextContent ("Do Lab and sent in the google classroom");
//        textNote1.createdDate = ("31 July 2025");
//        textNote1.getSummary();
//
//        System.out.println("User: " + normalUser.getUserName());
//        System.out.println("User Type: " + normalUser.getUserType());
//        System.out.println("Role: " + normalUser.getRole());
//        System.out.println("--------------------");
//
//        System.out.println("User: " + Admin.getUserName());
//        System.out.println("User Type: " + admin.getUserType());
//        System.out.println("Role: " + admin.getRole());
//        admin.manageUser();
//        System.out.println("--------------------");



//    }
}