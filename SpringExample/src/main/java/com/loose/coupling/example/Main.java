package com.loose.coupling.example;

import com.tight.coupling.DatabaseManager;

public class Main {
    public static void main(String[] args) {
        DatabaseInterface databaseInterface =new UserDatabase();
        UserDatabaseManager databaseManager = new UserDatabaseManager(databaseInterface);
        System.out.println(databaseManager.getUserManager());
    }

}
