package com.loose.coupling.example;

public class UserDatabase implements DatabaseInterface{

    public String getUserDetails(){
        return "User Details Provider";
    }
}
