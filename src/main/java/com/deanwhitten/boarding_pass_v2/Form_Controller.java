package com.deanwhitten.boarding_pass_v2;

import Model.BoardingPass;
import Model.DepartureSchedule;
import Model.FlightSchedule;
import Model.Locations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.Random;
import java.util.ResourceBundle;

import static javafx.collections.FXCollections.observableArrayList;

public class Form_Controller implements Initializable {
    Locations locations = new Locations();
    DepartureSchedule departureSchedule = new DepartureSchedule();
    static BoardingPass  newPass = new BoardingPass();

    @FXML
    private TextField id_input;
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

    private int generatedIdNum;

    @Override
    public void initialize(URL url, ResourceBundle rb){
        generatedIdNum = generateTicketID();

        id_input.setText("Auto-Gen: " + generatedIdNum);
        gender_selection.getItems().addAll("Male", "Female");
        departureTime_selection.getItems().addAll(observableArrayList(departureSchedule.listOfDepartureTimes()));
        origin_selection.getItems().addAll(observableArrayList(locations.locationNamesList()));
        destination_selection.getItems().addAll(observableArrayList(locations.locationNamesList()));
    }

    
    @FXML
    private void onCancelClick(ActionEvent event) throws IOException {
        loadWindow("Main_view", event);
    }

    @FXML
    private void onEstimateClick(ActionEvent event) throws IOException {
        Boolean valid = validateInputs();

        if (valid){
            loadWindow("Estimate_view", event);
        }
    }


    public static void loadWindow(String page, ActionEvent event)throws IOException {
        page =  page + ".fxml";
        Parent parent = FXMLLoader.load(Main.class.getResource(page));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    public Boolean validateInputs(){
        int validInputs = 0;

        if(name_input.getText().isEmpty()){
            name_input.requestFocus();
        }else{
            validInputs++;
        }

        if(email_input.getText().isEmpty() || !(email_input.getText().contains("@") && email_input.getText().contains("."))){
            email_input.setText("");
            email_input.requestFocus();
        }else{
            validInputs++;
        }

        if(phone_input.getText().isEmpty() || !phone_input.getText().matches("\\d*") || phone_input.getText().length() != 10){
            phone_input.setText("");
            phone_input.requestFocus();
        }else{
            validInputs++;
        }

        if(gender_selection.getValue() == null){
            gender_selection.requestFocus();
        }else{
            validInputs++;
        }

        if(age_input.getText().isEmpty() || !age_input.getText().matches("\\d*")){
            age_input.setText("");
            age_input.requestFocus();
        }else{
            validInputs++;
        }

        if(date_selection.getValue() == null){
            date_selection.requestFocus();
        }else{
            validInputs++;
        }

        if(departureTime_selection.getValue() == null){
            departureTime_selection.requestFocus();
        }else {
            validInputs++;
        }

        if(origin_selection.getValue() == null){
            origin_selection.requestFocus();
        }else{
            validInputs++;
        }

        if (destination_selection.getValue() == null){
            destination_selection.setValue(null);
            destination_selection.requestFocus();
        }else{
            validInputs++;
        }

        if (validInputs == 9){
            newPass.setTicketID(generatedIdNum);
            newPass.setName(name_input.getText());
            newPass.setEmail(email_input.getText());
            newPass.setPhoneNum(phone_input.getText());
            newPass.setGender(gender_selection.getValue());
            newPass.setAge(Integer.parseInt(age_input.getText()));
            newPass.setDate(date_selection.getValue());
            newPass.setDeparture(LocalTime.parse(departureTime_selection.getValue()));
            newPass.setOrigin(origin_selection.getValue());
            newPass.setDestination(origin_selection.getValue());
            newPass.generateEstimates(newPass.getGender(), newPass.getAge(), newPass.getOrigin(), newPass.getDestination(), newPass.getDeparture());

            return true;
        }else {
            return false;
        }
    }


    private int generateTicketID() {
        boolean match;
        Random randomNum = new Random();
        int num = randomNum.nextInt(10003);

        match = verifyIfTaken(num);

        if (!match) {
            id_input.setText(Integer.toString(num));
        } else {
            generateTicketID();
        }
        return num;
    }

    private boolean verifyIfTaken(Integer num) {
        BoardingPass match = FlightSchedule.lookupBoardingPass(num);
        return match != null;
    }
}
