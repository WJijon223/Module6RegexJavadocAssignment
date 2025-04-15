package edu.farmingdale.module6regexjavadocassignment;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistrationController {

    @FXML
    private Button addButton;

    @FXML
    private TextField birthDateInput;

    @FXML
    private TextField emailInput;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField zipCodeInput;

    @FXML
    public void initialize() {

        // Add focus listeners to validate inputs
        nameInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                validateName();
            }
        });

        birthDateInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                validateBirthDate();
            }
        });

        emailInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                validateEmail();
            }
        });

        zipCodeInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                validateZipCode();
            }
        });
    }

    private boolean validateName() {
        String name = nameInput.getText();
        if (!name.matches("^[a-zA-Z]+\\s[a-zA-Z]+$")) {
            nameInput.setStyle("-fx-border-color: red;");
            return false;
        } else {
            nameInput.setStyle("-fx-border-color: green");
            return true;
        }
    }

    private boolean validateBirthDate() {
        String birthDate = birthDateInput.getText();
        if (!birthDate.matches("^(0[1-9]|1[0-2])/(0[1-9]|[12][0-9]|3[01])/\\d{4}$")) { // Example: YYYY-MM-DD
            birthDateInput.setStyle("-fx-border-color: red;");
            return false;
        } else {
            birthDateInput.setStyle("-fx-border-color: green");
            return true;
        }
    }

    private boolean validateEmail() {
        String email = emailInput.getText();
        if (!email.matches("^[\\w.%+-]+@farmingdale\\.edu$")) {
            emailInput.setStyle("-fx-border-color: red;");
            return false;
        } else {
            emailInput.setStyle("-fx-border-color: green");
            return true;
        }
    }

    private boolean validateZipCode() {
        String zipCode = zipCodeInput.getText();
        if (!zipCode.matches("^\\d{5}$")) { // Example: 5-digit zip code
            zipCodeInput.setStyle("-fx-border-color: red;");
            return false;
        } else {
            zipCodeInput.setStyle("-fx-border-color: green");
            return true;
        }
    }
}

