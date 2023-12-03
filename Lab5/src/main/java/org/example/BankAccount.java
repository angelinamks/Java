package org.example;

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot deposit negative amount");
        }
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw negative amount");
        }
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getAccountSummary() {
        return "Account Number: " + accountNumber + ", Account Name: " + accountName + ", Balance: " + balance;
    }
}
