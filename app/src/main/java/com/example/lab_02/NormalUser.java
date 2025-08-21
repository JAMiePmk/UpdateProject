package com.example.lab_02;

import static com.example.lab_02.UserType.NORMSL_USER;

import android.content.Intent;

import java.io.Serializable;

public class NormalUser extends User implements Serializable {

    public NormalUser( String userName, String password, String gmail){
        super(userName, password, gmail, UserType.NORMSL_USER);

    }

    @Override
    public String getRole() {
        return "NormalUser";
    }
    public void normalUser() {
        System.out.println(getUserName() + "Your Normal User");
    }





}
