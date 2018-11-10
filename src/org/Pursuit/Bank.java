package org.Pursuit;

import java.util.ArrayList;
import java.util.HashMap;

public class Bank {
    static HashMap<Integer,Customer> customers = new HashMap<>();


    public static void addfirstcustomers() {
        Account first = new Account("Checking", 111111.00, 1111);
        Customer rza = new Customer("RZA", first, null);
        customers.put(111100,rza);
        customers.put(333300,new Customer("Old Dirty Bastard", new Account("Checking", 333333.00, 3333), null));
        customers.put(444400,new Customer("Method man", new Account("Checking", 444444.00, 4444), null));
        customers.put(555500,new Customer("Gza", new Account("Checking", 555555.00, 5555), null));
        customers.put(666600,new Customer("Ghost Face Killah", new Account("Checking", 666666.00, 6666), null));
    }

    public static void addnewcustomer(int Id,Customer newcustomer) {
        customers.put(Id,newcustomer);
    }

    public static void listallcustomers() {
        for (Integer customer : customers.keySet()) {
            System.out.println("NAME : "+ customers.get(customer).getName()+"  | " + " ID# : " + customer + "\n");
        }
    }

    public static void deleteAccount(int accnum) {
        customers.get(accnum).setAccount(null);
    }

    public static void deletecustomer(int accnum) {
       customers.remove(accnum);
    }

    public static void addAccToCustomer(int accnum, double balance , String type, int newacc) {
        customers.get(accnum).setExtraAccount(new Account(type,balance,newacc));
    }
        public static void getCustomeracc(int id){
            customers.get(id).getAccount();
    }

    public static Customer getcustomer(int id ){
        return customers.get(id);
    }



    public static void setExtraAcc(int id,String type , double balance, int accNumber) {
        customers.get(id).setExtraAccount(new Account(type,balance,accNumber));
    }

public static void getallacc(int id){
    System.out.println("1. ACCOUNT # = " + customers.get(id).getAccount().getAccNumber() +" "+  " BALANCE  = $ " + customers.get(id).getAccount().getBalance());
    if (customers.get(id).getExtraAccount() == null) {
        System.out.println("");

    } else {
        System.out.println("2. " + customers.get(id).getExtraAccount().getAccNumber() + " " + customers.get(id).getExtraAccount().getBalance());
    }
}
}

