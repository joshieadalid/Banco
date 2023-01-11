package com.banco.banking;

import java.util.HashMap;
import java.util.Map;

public class Banking {
    private static final Banking INSTANCE = new Banking();
    private final HashMap<Integer, User> users;
    private User loggedUser;

    private Banking() {
        this.users = new HashMap<>();
        AccountType.addAccountType("Estándar",0);
        AccountType.addAccountType("Prémium",100000);
    }

    public static Banking getInstance() {
        return INSTANCE;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
        System.out.println("Usuario registrado: " + user);
    }

    public User getUser(int userId) {
        return users.get(userId);
    }

    public Account getAccountForUser(int userId) {
        return getUser(userId).getAccount();
    }


    private void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
        System.out.println("Usuario establecido: " + loggedUser);
    }
    public boolean loginUser(String username, String password) {
        for (HashMap.Entry<Integer, User> entry : users.entrySet()) {
            User user = entry.getValue();
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                setLoggedUser(user);
                return true;
            }
        }
        return false;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public Account getAccount(String accountId) {
        return users.values().stream()
                .map(User::getAccount)
                .filter(account -> account.getAccountId().equals(accountId))
                .findFirst()
                .orElse(null);
    }
}