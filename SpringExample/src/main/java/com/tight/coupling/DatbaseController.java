package com.tight.coupling;

public class DatbaseController {

    public static void main(String[] args) {
        DatabaseManager databaseManager = new DatabaseManager();
        System.out.println(databaseManager.manageDatabase());

    }

}
