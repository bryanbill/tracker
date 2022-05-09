package com.minty.models;

public class User {
    private int id;
    private String username;
    private String fullName;
    private String company;
    private String password;

    private static User currentUser;

    public User(String username, String fullName, String company, String password) {
        this.username = username;
        this.fullName = fullName;
        this.company = company;
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getCompany() {
        return company;
    }

    public String getPassword() {
        return password;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User cs) {
        currentUser = cs;
    }
}
