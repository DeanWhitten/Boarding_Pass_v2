package com.deanwhitten.boarding_pass_v2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Estimate_Controller {
    public Label departure_txt;
    public Label duration_txt;
    public Label eta_txt;
    public Label base_ticket_cost_txt;
    public Label age_discount_txt;
    public Label gender_discount_txt;
    public Label ticket_total_txt;
    public Button back_btn;
    public Button book_flight_btn;

    @FXML
    private void onBackClick(ActionEvent event) throws IOException {
        loadWindow("Form_view", event);
    }

    @FXML
    private void onBookFlightClicked(ActionEvent event) throws IOException {
        loadWindow("Main_view", event);
    }

    public static void loadWindow(String page, ActionEvent event)throws IOException {
        page =  page + ".fxml";
        Parent parent = FXMLLoader.load(Main.class.getResource(page));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
