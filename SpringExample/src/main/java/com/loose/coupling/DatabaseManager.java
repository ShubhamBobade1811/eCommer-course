package com.loose.coupling;

public class DatabaseManager {

    private InterfaceA interfaceA;

    public DatabaseManager(InterfaceA interfaceA){
        this.interfaceA = interfaceA;
    }

    public String manageSQLConnection(){
        return interfaceA.database();
    }
}
