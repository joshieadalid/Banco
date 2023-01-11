package com.banco.banking;

public class InsufficientBalanceException extends Exception{
    public InsufficientBalanceException(){
        super("Couldn't make the transferring");
    }

    public InsufficientBalanceException(String message){
        super(message);
    }
}
