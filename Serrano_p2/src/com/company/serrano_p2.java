package com.company;

public class SavingsAccount {
    public static double annualInterestRate = 0.0;
    private double savingsBalance;

    public SavingsAccount(double amount){
        this.savingsBalance = amount;
    }

    public void calculateMonthlyInterest(){
        double interest;
        interest = (this.savingsBalance * (annualInterestRate/100))/12;
        this.savingsBalance += interest;
    }

    public void showBalance(){
        System.out.printf("$%.2f", this.savingsBalance);
    }


    public static void modifyInterestRate(double newRate){
        annualInterestRate = newRate;
    }



    public static void main(String[] args) {
        SavingsAccount savings1 = new SavingsAccount(2000.0);
        SavingsAccount savings2 = new SavingsAccount(3000.0);
        SavingsAccount.modifyInterestRate(4.0);
        System.out.println("Month \n\n Savings1 \n Savings2");


        for(int i=1; i<=12; ++i){
            savings1.calculateMonthlyInterest();
            savings2.calculateMonthlyInterest();
            System.out.print("Month " + i + ": \n");
            savings1.showBalance();
            System.out.print("\n");
            savings2.showBalance();
            System.out.println();
        }

        System.out.println();

        System.out.println("Set Annual Interest Rate to 5%");
        System.out.println();
        SavingsAccount.modifyInterestRate(5.0);


        savings1.calculateMonthlyInterest();
        savings2.calculateMonthlyInterest();


        System.out.print("Month 13: \n");
        savings1.showBalance();
        System.out.print("\n");
        savings2.showBalance();
        System.out.println();

    }
}
