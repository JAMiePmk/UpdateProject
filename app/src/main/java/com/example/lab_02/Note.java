package com.example.lab_02;

import java.util.Date;

public class Note {
    String title;
    String context;
    String createdDate;

    void getSummary(){
        System.out.println(title);
        System.out.println(context);
        System.out.println(createdDate);
    }

}
