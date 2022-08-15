package com.deanwhitten.boarding_pass_v2;

import Model.BoardingPass;
import Model.FlightSchedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class Estimate_Controller implements Initializable {
    BoardingPass pass = new BoardingPass();

    public Label departure_txt;
    public Label duration_txt;
    public Label eta_txt;
    public Label base_ticket_cost_txt;
    public Label age_discount_txt;
    public Label gender_discount_txt;
    public Label ticket_total_txt;
    public Button back_btn;
    public Button book_flight_btn;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        pass = Form_Controller.newPass;

        departure_txt.setText(String.valueOf(pass.getDeparture()));
        duration_txt.setText(String.valueOf(pass.getDuration()));
        eta_txt.setText(String.valueOf(pass.getEta()));
        base_ticket_cost_txt.setText(String.valueOf(pass.getBasePrice()));
        age_discount_txt.setText(String.valueOf(pass.getAgeDiscount()));
        gender_discount_txt.setText(String.valueOf(pass.getGenderDiscount()));
        ticket_total_txt.setText(String.valueOf(pass.getTotalPrice()));
    }

    @FXML
    private void onBackClick(ActionEvent event) throws IOException {
        loadWindow("Form_view", event);
    }

    @FXML
    private void onBookFlightClicked(ActionEvent event) throws IOException {
        FlightSchedule.addBoardingPass(pass);
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
