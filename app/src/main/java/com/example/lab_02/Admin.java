package com.example.lab_02;

public class Admin extends User {

    public Admin(String userName, String password, String gmail) {
        super(userName, password, gmail, UserType.ADMIN);
    }

    @Override
    public String getRole() {
        return "Admin";
    }
    public void manageUser() {
        System.out.println(getUserName() + (" (Admin) ManagingUser."));
    }

    public void deleteContent() {
        System.out.println(getUserName() + ( "(Admin) Is Deleting Content" ));
    }

}
