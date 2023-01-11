package com.banco.banking;

public class User {
    private static int nextId = 0;
    private final int id;
    private final String username;
    private final Account account;
    private final String password;

    public User(String username, String password) {
        this.username = username;
        this.id = nextId++;
        this.password = password;
        account = new Account("A" + id);
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Account getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return """
                User{
                    id=%d,
                    username='%s',
                    account=%s,
                    password='%s'
                }""".formatted(id, username, account, password);
    }
}
