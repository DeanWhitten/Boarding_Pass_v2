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

public class Details_Controller {
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
