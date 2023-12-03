package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Mock
    private Bank bank;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bank = new Bank();
    }

    @Test
    void createAccountSuccessfully() throws NegativeAmountException {
        BankAccount account = bank.createAccount("John Doe", 500.0);
        assertNotNull(account);
        assertEquals("John Doe", account.getAccountName());
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void createAccountWithNegativeBalance() {
        Exception exception = assertThrows(NegativeAmountException.class, () -> {
            bank.createAccount("Jane Doe", -100.0);
        });
        assertEquals("Cannot create account with negative balance", exception.getMessage());
    }

    @Test
    void findAccountSuccessfully() throws AccountNotFoundException, NegativeAmountException {
        BankAccount account = bank.createAccount("John Doe", 500.0);
        BankAccount foundAccount = bank.findAccount(account.getAccountNumber());
        assertNotNull(foundAccount);
        assertEquals(account.getAccountNumber(), foundAccount.getAccountNumber());
    }

    @Test
    void findNonExistentAccount() {
        Exception exception = assertThrows(AccountNotFoundException.class, () -> {
            bank.findAccount(999);
        });
        assertEquals("Account not found: 999", exception.getMessage());
    }

    @Test
    void transferMoneySuccessfully() throws InsufficientFundsException, NegativeAmountException, AccountNotFoundException {
        BankAccount accountFrom = bank.createAccount("John Doe", 1000.0);
        BankAccount accountTo = bank.createAccount("Jane Doe", 500.0);

        bank.transferMoney(accountFrom.getAccountNumber(), accountTo.getAccountNumber(), 200.0);

        assertEquals(800.0, accountFrom.getBalance());
        assertEquals(700.0, accountTo.getBalance());
    }

    @Test
    void transferMoneyWithInsufficientFunds() {
        Exception exception = assertThrows(InsufficientFundsException.class, () -> {
            BankAccount accountFrom = bank.createAccount("John Doe", 100.0);
            BankAccount accountTo = bank.createAccount("Jane Doe", 500.0);
            bank.transferMoney(accountFrom.getAccountNumber(), accountTo.getAccountNumber(), 200.0);
        });
        assertEquals("Insufficient funds for withdrawal", exception.getMessage());
    }
}
