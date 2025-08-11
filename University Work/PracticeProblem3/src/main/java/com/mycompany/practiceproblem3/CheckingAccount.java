
package com.mycompany.practiceproblem3;

public class CheckingAccount extends BankAccount implements Transaction, OverdraftProtection {

    private double overdraftLimit;

    public CheckingAccount(String accountNumber, double balance, double overdraftLimit) {
        super(accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }

    @Override
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void displayDetails() {
        System.out.println("Checking Account: " + accountNumber +
                " | Balance: $" + balance +
                " | Overdraft Limit: $" + overdraftLimit);
    }
}
