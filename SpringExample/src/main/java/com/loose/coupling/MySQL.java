package com.loose.coupling;

public class MySQL implements InterfaceA {

    @Override
    public String database() {
        return "MySQL database Connection";
    }
}
