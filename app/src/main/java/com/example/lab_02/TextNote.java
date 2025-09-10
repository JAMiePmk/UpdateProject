package com.example.lab_02;

import java.util.Date;

public class TextNote extends Note{
    private String textContent;

    public TextNote(String title, Date createdDate, String content) {
        super();
    }

    public String getTextContent(){
        return textContent;
    }
    public void setTextContent(String newcontent){
        this.textContent = newcontent;

    }

    public String getSummary() {
        //System.out.println(title+":"textContennt+"("+createdDate+")";

        return String.format("%s: %s (%s)", title, textContent, createdDate);
    }
}
