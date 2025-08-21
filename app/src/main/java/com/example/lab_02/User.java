package com.example.lab_02;

import android.content.Intent;

import java.io.Serializable;

public abstract class User implements Serializable {
    private  String userName;
    private String password;
    private String gmail;
    private UserType userType;
    public User(String userName, String password, String gmail) {
        this.userName = userName;
        this.password = password;
        this.gmail = gmail;
        this.userType = userType;
    }

    public User(String userName, String password, String gmail, UserType userType) {
    }

    public UserType getUserType() {
        return userType;
    }

    public  String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public String getGmail(){
        return gmail;
    }
    public void setUserName(String newusername) {
        this.userName = newusername ;
    }
    public void setPassword(String newpassword){
        this.password = newpassword;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public abstract String getRole();

    NormalUser user1 = new NormalUser("Gummi", "6712247049", "1234@gmail.com");

    public String getuserName() {
        return String.format("%s", userName);
    }


}
