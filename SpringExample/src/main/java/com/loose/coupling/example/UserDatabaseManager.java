package com.loose.coupling.example;

public class UserDatabaseManager {

    private DatabaseInterface databaseInterface;

    public UserDatabaseManager(DatabaseInterface databaseInterface) {
        this.databaseInterface = databaseInterface;
    }

    public String getUserManager(){
        return databaseInterface.getUserDetails();
    }
}
