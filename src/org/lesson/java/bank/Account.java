package org.lesson.java.bank;

import java.util.Random;

public class Account {
    //Props
    private int accountNumber;
    private String accountHolder;
    private double accountBalance;

    //Constructor
    public Account(String accountHolder) {
        this.accountHolder = accountHolder;
        Random rnd = new Random();
        accountNumber = rnd.nextInt(1, 100000);
        accountBalance = 0.0;
    }
    //Getters and Setters
    public int getAccountNumber(){
        return accountNumber;
    }

    public double getAccountBalance(){
        return accountBalance;
    }

    public String getAccountHolder(){
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    @Override
    public String toString(){
        return "Hi, " + accountHolder + "." + "Your account number is " + accountNumber + " and your current balance " +
                "is " + accountBalance;
    }



    //Custom Methods

    public boolean depositFunds(double amount){
        if(amount >= 1){
            accountBalance+= amount;
            return true;
        }else {
            return false;
        }
    }

    public boolean withdrawFunds(int amount){
        if(amount < accountBalance){
            accountBalance-= amount;
            return true;
        }else {
            return false;
        }
    }


}
