
package com.mycompany.practiceproblem3;

public class SavingsAccount extends BankAccount implements Transaction, InterestBearing {

    private double interestRate; // yearly interest rate %

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    @Override
    public void displayDetails() {
        System.out.println("Savings Account: " + accountNumber +
                " | Balance: $" + balance +
                " | Interest Rate: " + interestRate + "%");
    }
}

