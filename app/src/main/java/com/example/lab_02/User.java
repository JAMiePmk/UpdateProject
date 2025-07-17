package com.example.lab_02;

public class User {
    String userName;
    String password;
    String gmail;
    void setUserName(String newuserName){
        this.userName = newuserName;
        System.out.println(userName);
    }

    void setPassword(String newpassword){
        this.password = newpassword;
        System.out.println(password);
    }

    void setEmail(String newemail){
        this.gmail = newemail;
        System.out.println(gmail);
    }

}
