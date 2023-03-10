package org.lesson.java.bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Good evening, to open an account under your name, please enter your full name. ");
        String name = scan.nextLine();
        Account account = new Account(name);
        int decision;

        do{
            System.out.println("Fantastic, please enter 1 for Deposits, 2 for Withdrawals or 3 to Exit");
             decision = Integer.parseInt(scan.nextLine());

            while(decision != 1 && decision != 2 && decision != 3){
                System.out.println("Command not found");
                System.out.println("Please enter 1 for Deposits, 2 for Withdrawals or 3 to Exit");
                decision = Integer.parseInt(scan.nextLine());
            }

            switch (decision) {
                case 1 -> {
                    System.out.println("How much would you like to deposit?");
                    double amount = Integer.parseInt(scan.nextLine());
                    while (amount < 1) {
                        System.out.println("Amount cannot be negative");
                        System.out.println("Please enter a positive number for your deposit");
                        amount = Integer.parseInt(scan.nextLine());
                    }
                    String message = account.depositFunds(amount) ?
                            "Your deposit was successful, your updated balance is " + account.getAccountBalance() :
                            "Your deposit was declined";
                    System.out.println(message);
                }
                case 2 -> {
                    if(account.getAccountBalance() < 1){
                        System.out.println("I'm sorry, you can't withdraw from your account as your balance is " + account.getAccountBalance());
                        System.out.println("If you'd like to make a deposit enter 1, otherwise enter 3 to exit");
                        decision = Integer.parseInt(scan.nextLine());
                    }else {
                        System.out.println("How much would you like to withdraw?");
                        int amountToWithdraw = Integer.parseInt(scan.nextLine());
                        while (amountToWithdraw < 1 || amountToWithdraw > account.getAccountBalance()) {
                            System.out.println("The input amount is either invalid, or your account doesn't have enough " +
                                    "funds.");
                            System.out.println("Please enter a positive number that is less than your account balance for" +
                                    " your withdrawal.");
                            amountToWithdraw = Integer.parseInt(scan.nextLine());
                        }
                        String message = account.withdrawFunds(amountToWithdraw) ?
                                "Withdrawal successful. Your updated balance is " + account.getAccountBalance() :
                                "Your withdrawal was declined";
                        System.out.println(message);
                    }
                }
            }
        }
        while (decision != 3);
        System.out.println("Goodbye! " + account.getAccountHolder());
    }
}
