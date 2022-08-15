package com.deanwhitten.boarding_pass_v2;

import Model.BoardingPass;
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
import java.text.Format;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

public class Details_Controller implements Initializable {
    public Label ticket_id_txt;
    public Label name_txt;
    public Label email_txt;
    public Label phoneNumber_txt;
    public Label gender_txt;
    public Label age_txt;
    public Label date_txt;
    public Label flightTime_txt;
    public Label origin_txt;
    public Label destination_txt;
    public Label duration_txt;
    public Label eta_txt;
    public Label basePrice_txt;
    public Label ageDiscount_txt;
    public Label genderDiscount_txt;
    public Label ticketTotal_txt;
    public Button return_btn;

    private BoardingPass pass;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pass = Main_Controller.selectedBoardingPass;

        ticket_id_txt.setText(Integer.toString(pass.getTicketID()));
        name_txt.setText(pass.getName());
        email_txt.setText(pass.getEmail());
        phoneNumber_txt.setText(pass.getPhoneNum());
        gender_txt.setText(pass.getGender());
        age_txt.setText(Integer.toString(pass.getAge()));
        date_txt.setText(String.valueOf(pass.getDate()));
        flightTime_txt.setText(String.valueOf(pass.getDeparture()));
        origin_txt.setText(pass.getOrigin());
        destination_txt.setText(pass.getDestination());
        duration_txt.setText(Integer.toString(pass.getDuration()));
        eta_txt.setText(String.valueOf(pass.getEta()));
        basePrice_txt.setText(Double.toString(pass.getBasePrice()));
        ageDiscount_txt.setText(Double.toString(pass.getAgeDiscount()));
        ageDiscount_txt.setText(Double.toString(pass.getGenderDiscount()));
        ticketTotal_txt.setText(Double.toString(pass.getTotalPrice()));


    }


    @FXML
    private void onReturnClick(ActionEvent event) throws IOException {
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
