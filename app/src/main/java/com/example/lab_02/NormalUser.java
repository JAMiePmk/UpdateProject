package com.example.lab_02;

import static com.example.lab_02.UserType.NORMSL_USER;

public class NormalUser extends User{

    public NormalUser( String userName, String password, String gmail){
        super(userName, password, gmail,NORMSL_USER);

    }

    @Override
    public String getRole() {
        return "NormalUser";
    }
    public void normalUser() {
        System.out.println(getUserName() + "You'r Normal User");
    }
}
