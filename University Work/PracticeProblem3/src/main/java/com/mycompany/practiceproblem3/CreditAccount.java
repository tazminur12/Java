
package com.mycompany.practiceproblem3;

public class CreditAccount extends BankAccount implements Transaction, CreditLimit {

    private double creditLimit;

    public CreditAccount(String accountNumber, double balance, double creditLimit) {
        super(accountNumber, balance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Payment Received: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= creditLimit - balance) {
            balance += amount; // balance represents used credit
            System.out.println("Credit Used: $" + amount);
        } else {
            System.out.println("Credit limit exceeded!");
        }
    }

    @Override
    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void displayDetails() {
        System.out.println("Credit Account: " + accountNumber +
                " | Used Credit: $" + balance +
                " | Credit Limit: $" + creditLimit);
    }
}

