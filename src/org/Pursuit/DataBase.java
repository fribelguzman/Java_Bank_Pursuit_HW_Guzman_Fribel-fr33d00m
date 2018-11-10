package org.Pursuit;

import java.util.HashMap;

class DataBase {


    public static HashMap<String, String> teller = new HashMap<>();


    public static void addlogins() {
        teller.put("DOLLAR", "DOLLAR");
        teller.put("Bills","Yall");

    }

    public HashMap<String, String> getTeller() {
        return teller;
    }
}



