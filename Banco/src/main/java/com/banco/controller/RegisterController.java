package com.banco.controller;

import com.banco.banking.Banking;
import com.banco.banking.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class RegisterController {
    public AnchorPane anchorPane;
    public Button backButton;
    public Button registerButton;
    public TextField usernameTextField;
    public PasswordField passwordField;

    private void loadLoginWindow() throws IOException {
        System.out.println("Loading LoginWindow");
        AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-view.fxml")));
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
    }

    @FXML
    protected void onBackButtonClick() throws IOException {
        loadLoginWindow();
    }

    @FXML
    protected void onRegisterButtonClick() {
        Banking banking = Banking.getInstance();
        banking.addUser(new User(usernameTextField.getText(), passwordField.getText()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Banco");
        alert.setHeaderText("Sistema de usuarios");
        alert.setContentText("Usuario " + usernameTextField.getText() + " agregado");
        alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.out.println("Usuario registrado");
            }
        });
        registerButton.setText("Aceptar");
    }
}