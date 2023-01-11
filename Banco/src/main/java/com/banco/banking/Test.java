package com.banco.banking;

public class Test {
    public static void main(String[] args) {
        AccountType.addAccountType("Estandar",0);
        AccountType.addAccountType("PREMIUM",100000);
        Banking banking = Banking.getInstance();
        //banking.addUser(new User("Josh Nicols"));
        //banking.addUser(new User("Drake Parker"));
        banking.getAccountForUser(0).setBalance(73000);
        banking.getAccountForUser(1).setBalance(150000);
        System.out.println(banking.getUser(0).getUsername());
        System.out.println(banking.getUser(1).getUsername());
        System.out.println(banking.getAccountForUser(0).getBalance());
        System.out.println(banking.getAccountForUser(0).getBalance());
        System.out.println(banking.getAccountForUser(0).getType().getName());
        System.out.println(banking.getAccountForUser(1).getType().getName());

        try {
            banking.getAccountForUser(0).transfer(banking.getAccountForUser(0),10);
        } catch (InsufficientBalanceException e) {
            throw new RuntimeException(e);
        }

    }
}