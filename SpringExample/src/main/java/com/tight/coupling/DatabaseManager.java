package com.tight.coupling;

public class DatabaseManager {

    private DatabaseConnection databaseConnection = new DatabaseConnection();

    public String manageDatabase(){
        return databaseConnection.getDatabaseConnection();
    }
}
