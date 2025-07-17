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
        //สร้าง NormalUser
        NormalUser normalUser = new NormalUser("Gummi", "10111101", "1234@gmail.com");
        //สร้าง Admon
        Admin admin = new Admin("Jamie", "1305", "Jamie@gmail.com");
        TextNote textNote1 = new TextNote();

        textNote1.title ="OOP homework";
        textNote1.setTextContent ("Do Lab and sent in the google classroom");
        textNote1.createdDate = ("31 July 2025");
        textNote1.getSummary();

        System.out.println("User: " + normalUser.getUserName());
        System.out.println("User Type: " + normalUser.getUserType());
        System.out.println("Role: " + normalUser.getRole());
        System.out.println("--------------------");

        System.out.println("User: " + Admin.getUserName());
        System.out.println("User Type: " + admin.getUserType());
        System.out.println("Role: " + admin.getRole());
        admin.manageUser();
        System.out.println("--------------------");



    }
}