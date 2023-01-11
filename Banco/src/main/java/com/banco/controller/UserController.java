package com.banco.controller;

import com.banco.banking.Account;
import com.banco.banking.AccountType;
import com.banco.banking.Banking;
import com.banco.banking.InsufficientBalanceException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class UserController {
    @FXML
    public Label usernameLabel;
    @FXML
    public Label balanceLabel;
    @FXML
    public Label accountTypeLabel;
    // Transfer
    @FXML
    public TextField accountIdTextField;
    @FXML
    public TextField amountTransferTextField;
    @FXML
    public Button transferButton;
    // Withdraw
    @FXML
    public TextField amountWithdrawTextField;
    public Button withdrawButton;
    // Deposit
    @FXML
    public TextField amountDepositTextField;
    @FXML
    public Button depositButton;

    @FXML
    void initialize() {
        Banking banking = Banking.getInstance();

        if (banking.getLoggedUser() != null){
            usernameLabel.setText("Bienvenido, " + banking.getLoggedUser().getUsername());
            balanceLabel.setText("$" + banking.getLoggedUser().getAccount().getBalance());
            accountTypeLabel.setText(banking.getLoggedUser().getAccount().getType().getName());
        }
    }

    private void updateStatusLabels(){
        Banking banking = Banking.getInstance();
        balanceLabel.setText("$" + banking.getLoggedUser().getAccount().getBalance());
        accountTypeLabel.setText(banking.getLoggedUser().getAccount().getType().getName());
    }
    @FXML
    protected void onTransferButtonClick() {
        Banking banking = Banking.getInstance();
        Account account = banking.getAccount(accountIdTextField.getText());
        try {
            banking.getLoggedUser().getAccount().transfer(account,Double.parseDouble(amountTransferTextField.getText()));
            updateStatusLabels();
        } catch (InsufficientBalanceException e) {
            System.out.println("Saldo insuficiente");
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onDepositButtonClick() {
        Banking banking = Banking.getInstance();
        try {
            banking.getLoggedUser().getAccount().deposit(Double.parseDouble(amountDepositTextField.getText()));
            updateStatusLabels();
        } catch (InsufficientBalanceException e) {
            System.out.println("Saldo insuficiente");
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onWithdrawButtonClick() {
        Banking banking = Banking.getInstance();
        try {
            banking.getLoggedUser().getAccount().withdraw(Double.parseDouble(amountWithdrawTextField.getText()));
            updateStatusLabels();
        } catch (InsufficientBalanceException e) {
            System.out.println("Saldo insuficiente");
            throw new RuntimeException(e);
        }
    }
}
