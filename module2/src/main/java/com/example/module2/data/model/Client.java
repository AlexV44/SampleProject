package com.example.module2.data.model;

public class Client {
    private String firstName;
    private String password;

    public Client() {
        firstName = "";
        password = "";
    }

    public Client(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
