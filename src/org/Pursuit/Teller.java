package org.Pursuit;

import java.util.Scanner;

public class Teller {

     String username;
    static Scanner scanner = new Scanner(System.in);


     void intro() {
      
        System.out.println(
                "       ██████╗       ██████╗            ███████╗            █████╗            ███╗   ███╗\n" +
                        "      ██╔════╝       ██╔══██╗           ██╔════╝           ██╔══██╗           ████╗ ████║\n" +
                        "      ██║            ██████╔╝           █████╗             ███████║           ██╔████╔██║\n" +
                        "      ██║            ██╔══██╗           ██╔══╝             ██╔══██║           ██║╚██╔╝██║\n" +
                        "      ╚██████╗██╗    ██║  ██║    ██╗    ███████╗    ██╗    ██║  ██║    ██╗    ██║ ╚═╝ ██║\n" +
                        "       ╚═════╝ ╚═╝    ╚═╝  ╚═╝    ╚═╝    ╚══════╝    ╚═╝    ╚═╝  ╚═╝    ╚═╝    ╚═╝     ╚═╝\n" +
                        "       CASH          RULES              EVERYTHING          AROUND             ME \n" +

                        " \n \n                              WELCOME TO CREAM BANK");

        System.out.println("\n \n \n PLEASE ENTER YOUR USERNAME\n");
        login(scanner.nextLine());


    }

    public void login(String username) {

        if (DataBase.teller.containsKey(username)) {
            System.out.println("\n \n \n PLEASE ENTER YOUR PASSWORD\n");
            this.username = username;
            passWord(scanner.nextLine());


        } else {
            System.out.println("\n INVALID USERNAME, TRY AGAIN.");
            login(scanner.nextLine());


        }
    }

    public  void passWord(String password) {

        if (DataBase.teller.get(username).equals(password)) {
            mainmenu();

        } else {
            System.out.println("\n INVALID PASSWORD, TRY AGAIN.");
            passWord(scanner.nextLine());

        }
    }


    public  void viewnupdate(int id) {
        boolean viewnupdate = true;
        while (viewnupdate) {
            System.out.println("" +
                    " --------------------------------------------------\n" +
                    "|              MENU\n" +
                    "|\n" +
                    "|'1' - View customers balances \n" +
                    "|'2' - Deposit\n" +
                    "|'3' - Withdraw \n" +
                    "|'4' - Main menu\n" +
                    "|\n" +
                    " --------------------------------------------------\n");
            String newcusname = "";
            int choice = (scanner.nextInt());
            switch (choice) {
                case 1:
                    Bank.getallacc(id);

                    break;
                case 2:
                    System.out.println(" Which account would you like to deposit to :" );
                    Bank.getallacc(id);
                    int accposition = scanner.nextInt();
                    System.out.println("\n How much would you like to deposit ?\n");
                    double deposit = (scanner.nextDouble());
                    if(accposition == 1){
                        Bank.getcustomer(id).getAccount().setBalance(Bank.getcustomer(id).getAccount().getBalance() + deposit);
                        System.out.println("Your new balance is $" + Bank.getcustomer(id).getAccount().getBalance());
                    }else if(accposition == 2){
                        if (Bank.getcustomer(id).getExtraAccount() == null) {
                            System.out.println(" Invalid account");
                        } else {
                            Bank.getcustomer(id).getExtraAccount().setBalance(Bank.getcustomer(id).getExtraAccount().getBalance() +  deposit);
                            System.out.println("Your new balance is $" + Bank.getcustomer(id).getExtraAccount().getBalance());
                        }
                    }else {
                        System.out.println("Invalid input");
                    }

                    break;
                case 3:
                    System.out.println(" Which account would you like to withdraw from :");
                    Bank.getallacc(id);
                    int accposition2 = scanner.nextInt();
                    System.out.println("\n How much would you like to withdraw ?\n");
                    double withdraw = (scanner.nextDouble());
                    if(accposition2 == 1){
                        Bank.getcustomer(id).getAccount().setBalance(Bank.getcustomer(id).getAccount().getBalance() -  withdraw);
                        System.out.println("Your new balance is $" + Bank.getcustomer(id).getAccount().getBalance());
                    } else if(accposition2 == 2){
                        if (Bank.getcustomer(id).getExtraAccount() == null) {
                            System.out.println(" Invalid account");
                        } else {
                            Bank.getcustomer(id).getExtraAccount().setBalance(Bank.getcustomer(id).getExtraAccount().getBalance() -  withdraw);
                            System.out.println("Your new balance is $" + Bank.getcustomer(id).getExtraAccount().getBalance());
                        }
                    }else {
                        System.out.println("Invalid input");
                    }

                    break;
                case 4:
                    viewnupdate = false;
                    break;
                default:
                    System.out.println("\n INVALID INPUT, TRY AGAIN.\n");
                    break;

            }
        }
    }

        public  void mainmenu () {
            Bank.addfirstcustomers();
         boolean mainmenuactive = true;
            while (mainmenuactive) {
                System.out.println("" +
                        " --------------------------------------------------\n" +
                        "|              MAIN MENU\n" +
                        "|\n" +
                        "|'1' - List all customers and accounts\n" +
                        "|'2' - Delete a account\n" +
                        "|'3' - Delete a customer\n" +
                        "|'4' - Add new account\n" +
                        "|'5' - Add new customer\n" +
                        "|'6' - View and update an account\n" +
                        "|'7' - Sign out" +
                        "|\n" +
                        " --------------------------------------------------\n");
                int choice = (scanner.nextInt());
                switch (choice) {
                    case 1:
                        System.out.println(" --------------------------------------------------\n");

                        Bank.listallcustomers();
                        break;
                    case 2:
                        System.out.println("\n Which account number would you like to delete?\n");
                        int acc = scanner.nextInt();
                        Bank.deleteAccount(acc);
                        System.out.println("\n Account  " + acc + "  was successfully deleted. \n");
                        break;
                    case 3:
                        System.out.println("\n Please enter the customer id # of the customer you would like to delete?\n");
                        int clientid = scanner.nextInt();
                        Bank.deletecustomer(clientid);
                        System.out.println("\n Customer  " + clientid +"  was successfully deleted. \n");

                        break;
                    case 4:
                        System.out.println("\n In order to add a new account please enter the customers id# :  \n");
                        int customerid = scanner.nextInt();
                        Customer currentcustomer = Bank.getcustomer(customerid);
                        System.out.println("\n Please provide an account number for this new account " + currentcustomer.getName() + ": \n");
                        int accnew = scanner.nextInt();

                        System.out.println("\n Please provide a deposit amount for " + currentcustomer.getName() + ": \n");
                        double newdeposit = scanner.nextDouble();
                        System.out.println("\n What is the account type for this new account: \n");
                        String acctype = scanner.nextLine();
                        Bank.setExtraAcc(customerid, acctype,newdeposit,accnew);
                        System.out.println("\n Thank you , Account # " + accnew + " was successfully added to " + currentcustomer.getName() + " : \n");
                        break;
                    case 5:

                        System.out.println("\n In order to add a new customer Please provide customer name : \n ");
                        String emptystring = scanner.nextLine();
                        String newcusname = scanner.nextLine();
                        System.out.println("what account type please? Checking or Savings? \n");
                        String type = scanner.nextLine();
                        System.out.println("\n Please provide an account number for this new account " + newcusname + ": \n");
                        int accnum = scanner.nextInt();
                        System.out.println("\n Please provide a deposit amount for " + newcusname + ": \n");
                        double depo= scanner.nextDouble();
                        Bank.customers.put(accnum,new Customer(newcusname,new Account(type,depo,accnum)));
                        System.out.println("\n Thank you , customer " + newcusname + " was successfully added : \n");
                        break;
                    case 6:
                        System.out.println(" Please enter the customers id # : \n");
                        Bank.listallcustomers();
                        System.out.println("\n");
                        int idnum = scanner.nextInt();
                        System.out.println("\n \n");
                        viewnupdate(idnum);
                        break;
                    case 7:
                        System.out.println("\n Goodbye, You are now successfully signed off.\n");
                        mainmenuactive = false;
                        break;
                    default:
                        System.out.println("INVALID INPUT, TRY AGAIN");
                }
            }
        }

    }




