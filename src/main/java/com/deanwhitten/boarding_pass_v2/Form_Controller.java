package com.deanwhitten.boarding_pass_v2;

import Model.Locations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class Form_Controller {
    Locations locations = new Locations();
    @FXML
    private TextField name_input;
    @FXML
    private TextField email_input;
    @FXML
    private TextField phone_input;
    @FXML
    private ChoiceBox<String> gender_selection;
    @FXML
    private TextField age_input;
    @FXML
    private DatePicker date_selection;
    @FXML
    private ChoiceBox<String> departureTime_selection;
    @FXML
    private ChoiceBox<String> origin_selection;
    @FXML
    private ChoiceBox<String> destination_selection;

    public Label errorMsg_text;
    public Button cancel_btn;
    public Button getEstimate_btn;

    public void initialize(){
        gender_selection.getItems().addAll("Male", "Female");
        origin_selection.getItems().addAll(observableArrayList(locations.locationNamesList()));
        destination_selection.getItems().addAll(observableArrayList(locations.locationNamesList()));
    }

    
    @FXML
    private void onCancelClick(ActionEvent event) throws IOException {
        loadWindow("Main_view", event);
    }

    @FXML
    private void onEstimateClick(ActionEvent event) throws IOException {
        loadWindow("Estimate_view", event);
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
