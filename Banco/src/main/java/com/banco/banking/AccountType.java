package com.banco.banking;

import java.util.Comparator;
import java.util.HashMap;

public class AccountType {
    private static final HashMap<String, AccountType> accountTypes = new HashMap<>();
    private static int nextId = 0;

    private final String id;
    private final String name;
    private final double minBalance;

    private AccountType(String name, double minBalance) {
        this.id = "AT" + nextId++;
        this.name = name;
        this.minBalance = minBalance;
    }

    public static void addAccountType(String name, double minBalance) {
        AccountType accountType = new AccountType(name, minBalance);
        accountTypes.put(accountType.getId(), accountType);
    }

    public static AccountType getAccountType(String id) {
        return accountTypes.get(id);
    }

    public static void removeAccountType(String id) {
        accountTypes.remove(id);
    }

    public static AccountType getAccountTypeByBalance(double balance) {
        return accountTypes.values().stream()
                .filter(type -> type.getMinBalance() <= balance)
                .max(Comparator.comparingDouble(AccountType::getMinBalance))
                .orElse(null);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMinBalance() {
        return minBalance;
    }
}
