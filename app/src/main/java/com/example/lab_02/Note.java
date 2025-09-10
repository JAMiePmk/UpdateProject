package com.example.lab_02;


import java.util.Date;

public class Note {
    String title;
    String content;
    Date createdDate;
    public String getTitle() {
        return title;
    }

    CharSequence getSummary() {
        System.out.println(title);
        System.out.println(content);
        System.out.println(createdDate);
        return null;
    }

    public abstract static class note {
        public String title;
        String createdDate;

        abstract public String getSummary();
    }
}