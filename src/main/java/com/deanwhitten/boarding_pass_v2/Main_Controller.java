package com.deanwhitten.boarding_pass_v2;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Main_Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}