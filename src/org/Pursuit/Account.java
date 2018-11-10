package org.Pursuit;

public class Account {

    String type;
    int accNumber;
   double balance;

    Account(){}

    public Account(String type, double balance, int accNumber) {
        this.balance = balance;
        this.type = type;
        this.accNumber = accNumber;

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public  void deposit(int add) {
       this.balance  = balance + add;
    }
    public void withdraw(double subtract){
        this.balance = balance - subtract;
    }
}

