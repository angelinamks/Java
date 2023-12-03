package org.example;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        try {
            BankAccount account1 = bank.createAccount("Kanye West", 2000.0);
            BankAccount account2 = bank.createAccount("Kim Kardashian", 1000.0);

            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());

            System.out.println("\nПереказ коштів:");
            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 500.0);

            System.out.println("\nОновлена інформація про рахунки:");
            System.out.println(account1.getAccountSummary());
            System.out.println(account2.getAccountSummary());
        } catch (InsufficientFundsException | NegativeAmountException | AccountNotFoundException e) {
            e.printStackTrace();
        }

    }
}
