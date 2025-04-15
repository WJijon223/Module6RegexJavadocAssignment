package edu.farmingdale.module6regexjavadocassignment;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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
    void handleAddButtonClick() {
        try {
            // Load the splash page FXML
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login-page.fxml"));
            Scene loginScene = new Scene(fxmlLoader.load());

            // Get the current stage and set the new scene
            Stage currentStage = (Stage) addButton.getScene().getWindow();
            currentStage.setScene(loginScene);
            currentStage.setTitle("Login Page");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Validation flags
    boolean isValidName = false;
    boolean isValidBirthDate = false;
    boolean isValidEmail = false;
    boolean isValidZipCode = false;

    @FXML
    public void initialize() {

        // Add focus listeners to validate inputs
        nameInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                isValidName = validateName();
                validateAll(isValidName, isValidBirthDate, isValidEmail, isValidZipCode);
            }
        });

        birthDateInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                isValidBirthDate = validateBirthDate();
                validateAll(isValidName, isValidBirthDate, isValidEmail, isValidZipCode);
            }
        });

        emailInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                isValidEmail = validateEmail();
                validateAll(isValidName, isValidBirthDate, isValidEmail, isValidZipCode);
            }
        });

        zipCodeInput.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) { // Focus lost
                isValidZipCode = validateZipCode();
                validateAll(isValidName, isValidBirthDate, isValidEmail, isValidZipCode);
            }
        });

    }

    /**
     * Validates the name input and sets the style accordingly
     * @return true if valid, false otherwise
     */
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

    /**
     * Validates the birth date input and sets the style accordingly
     * @return true if valid, false otherwise
     */
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

    /**
     * Validates the email input and sets the style accordingly
     * @return true if valid, false otherwise
     */
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

    /**
     * Validates the zip code input and sets the style accordingly
     * @return true if valid, false otherwise
     */
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

    /**
     * sets the button to enabled or disabled based on the validation results
     * @param val1 value 1 to be evaluated
     * @param val2 value 2 to be evaluated
     * @param val3 value 3 to be evaluated
     * @param val4 value 4 to be evaluated
     * @return true if all values are valid, false otherwise
     * @throws IllegalArgumentException if an error occurs during validation
     */
    private boolean validateAll(boolean val1, boolean val2, boolean val3, boolean val4) {
        try {
            if (val1 && val2 && val3 && val4) {
                addButton.setDisable(false);
                return true;
            } else {
                addButton.setDisable(true);
                return false;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("An error occurred during validation: " + e.getMessage(), e);
        }
    }
}

