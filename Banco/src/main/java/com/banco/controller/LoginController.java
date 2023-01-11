package com.banco.controller;

import com.banco.banking.Banking;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    public AnchorPane anchorPane;
    public TextField usernameTextField;
    public PasswordField passwordField;
    public Button enterButton;
    public Button registerButton;

    private void loadRegisterWindow() throws IOException {
        System.out.println("Loading RegisterWindow");
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("register-view.fxml")));
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }

    private void loadUserWindow() throws IOException {
        System.out.println("Loading UserWindow");
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("user-view.fxml")));
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }

    @FXML
    protected void onRegisterButtonClick() throws IOException {
        loadRegisterWindow();
    }

    @FXML
    protected void onEnterButtonClick() throws IOException {
        Banking banking = Banking.getInstance();
        if (banking.loginUser(usernameTextField.getText(), passwordField.getText())) {
            loadUserWindow();
        }
    }
}