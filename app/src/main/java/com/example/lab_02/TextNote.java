package com.example.lab_02;

public class TextNote extends Note{
    private String textContent;
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
