package com.loose.coupling;

public class MainClass {

    public static void main(String[] args) {

        InterfaceA mysql=new MySQL();
        DatabaseManager databaseManager =new DatabaseManager(mysql);
        System.out.println(databaseManager.manageSQLConnection());

    }
}
