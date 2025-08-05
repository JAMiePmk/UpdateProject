package com.example.lab_02;


public class Note {
    String title;
    String context;
    String createdDate;

    void getSummary() {
        System.out.println(title);
        System.out.println(context);
        System.out.println(createdDate);
    }

    public abstract static class note {
        public String title;
        String createdDate;

        abstract public String getSummary();
    }
}