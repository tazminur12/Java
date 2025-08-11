

package com.mycompany.practiceproblem3;


public class PracticeProblem3 {

 public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("S-1001", 5000, 3.5);
        CheckingAccount checking = new CheckingAccount("C-2001", 2000, 1000);
        CreditAccount credit = new CreditAccount("CR-3001", 0, 5000);

        // Savings Account Operations
        savings.displayDetails();
        savings.deposit(1000);
        savings.withdraw(2000);
        System.out.println("Interest: $" + savings.calculateInterest());

        System.out.println();

        // Checking Account Operations
        checking.displayDetails();
        checking.withdraw(2500); // uses overdraft
        checking.deposit(1500);

        System.out.println();

        // Credit Account Operations
        credit.displayDetails();
        credit.withdraw(2000); // using credit
        credit.deposit(500);   // payment
    }
}
