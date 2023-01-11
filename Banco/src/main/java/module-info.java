module com.banco.banco {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.banco.controller to javafx.fxml;
    exports com.banco.controller;
}