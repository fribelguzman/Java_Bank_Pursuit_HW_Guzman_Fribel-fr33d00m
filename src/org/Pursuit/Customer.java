package org.Pursuit;

import java.util.ArrayList;

public class Customer {

    String name;
    Account account;
    Account extraAccount;

    static ArrayList<Account> listOfAccount = new ArrayList<>();

    {

    }
        public Customer(){
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, Account account) {
        this.name = name;
        this.account = account;
    }

    public Customer(String name, Account account, Account extraAccount) {
        this.name = name;
        this.account = account;
        this.extraAccount = extraAccount;
    }

    public static double totalBalance() {
        double total = 0;
        for (Account account : listOfAccount) {
            total = total + account.getBalance();
        }
        return total;
    }

    public static void addAccount(Account account) {
        listOfAccount.add(account);
    }

    public String getName() {
        return name;
    }

    public static ArrayList<Account> getListOfAccount() {
        return listOfAccount;
    }

    public Account getAccount() {
        return account;
    }

    public Account getExtraAccount() {
        return extraAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setExtraAccount(Account extraAccount) {
        this.extraAccount = extraAccount;
    }

    public static void setListOfAccount(ArrayList<Account> listOfAccount) {
        Customer.listOfAccount = listOfAccount;
    }
}



