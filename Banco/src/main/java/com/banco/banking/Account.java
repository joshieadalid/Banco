package com.banco.banking;

public class Account {
    private final String accountId;
    private AccountType type;
    private double balance;

    public Account(String accountId) {
        this.balance = 0.0;
        this.accountId = accountId;
        updateAccountType();
    }

    public String getAccountId() {
        return accountId;
    }

    public AccountType getType() {
        return type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        updateAccountType();
    }

    public void updateAccountType() {
        this.type = AccountType.getAccountTypeByBalance(balance);
    }

    public void transfer(Account payee, double amount) throws InsufficientBalanceException {
        if ((balance < amount) || (amount == 0)) {
            throw new InsufficientBalanceException();
        }
        balance -= amount;
        payee.setBalance(payee.getBalance() + amount);

        System.out.printf("Transferring from %s to %s%n", accountId, payee.accountId);

        updateAccountType();
        payee.updateAccountType();
    }

    public void deposit(double amount) throws InsufficientBalanceException {
        if (amount > 0) {
            this.balance += amount;
        } else {
            throw new InsufficientBalanceException("El deposito debe ser mayor a 0");
        }

        updateAccountType();
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
        } else {
            throw new InsufficientBalanceException("El deposito debe ser mayor a 0");
        }

        updateAccountType();
    }
}
