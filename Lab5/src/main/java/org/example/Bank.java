package org.example;
import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, BankAccount> accounts;
    private int nextAccountNumber;

    public Bank() {
        accounts = new HashMap<>();
        nextAccountNumber = 1; // Start with account number 1 for simplicity
    }

    public BankAccount createAccount(String accountName, double initialDeposit) throws NegativeAmountException {
        if (initialDeposit < 0) {
            throw new NegativeAmountException("Cannot create account with negative balance");
        }
        BankAccount newAccount = new BankAccount(nextAccountNumber++, accountName, initialDeposit);
        accounts.put(newAccount.getAccountNumber(), newAccount);
        return newAccount;
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        if (!accounts.containsKey(accountNumber)) {
            throw new AccountNotFoundException("Account not found: " + accountNumber);
        }
        return accounts.get(accountNumber);
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws InsufficientFundsException, NegativeAmountException, AccountNotFoundException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

