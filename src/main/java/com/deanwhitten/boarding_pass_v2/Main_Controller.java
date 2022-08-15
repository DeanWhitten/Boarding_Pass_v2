package com.deanwhitten.boarding_pass_v2;

import Model.BoardingPass;
import Model.FlightSchedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class Main_Controller implements Initializable {
    @FXML
    private TextField SearchBar_TextField;
    @FXML
    private TableView<BoardingPass> Flights_Table;
    @FXML
    private TableColumn<BoardingPass, Integer> ticketID_col;
    @FXML
    private TableColumn<BoardingPass, String> name_col;
    @FXML
    private TableColumn<BoardingPass, LocalDate> date_col;
    @FXML
    private TableColumn<BoardingPass, LocalTime> departure_col;
    @FXML
    private TableColumn<BoardingPass, String> origin_col;
    @FXML
    private TableColumn<BoardingPass, String> destination_col;

    public Button book_btn;
    public Button details_btn;
    public Button cancel_btn;

    public Label main_error_label;
    public Button yes_btn;
    public Button no_btn;

    public static BoardingPass selectedBoardingPass;
    private ObservableList<BoardingPass> foundPasses = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources){
     ticketID_col.setCellValueFactory(new PropertyValueFactory<>("ticketID"));
     name_col.setCellValueFactory(new PropertyValueFactory<>("name"));
     date_col.setCellValueFactory(new PropertyValueFactory<>("date"));
     departure_col.setCellValueFactory(new PropertyValueFactory<>("departure"));
     origin_col.setCellValueFactory((new PropertyValueFactory<>("origin")));
     destination_col.setCellValueFactory(new PropertyValueFactory<>("destination"));

     Flights_Table.setItems(FlightSchedule.getAllBoardingPasses());
    }


    @FXML
    private void onSearchBarInput(KeyEvent keyEvent){
        uiRESET();
        foundPasses.clear();
        try {
            try{
                int id = Integer.parseInt(SearchBar_TextField.getText());
                foundPasses.add(FlightSchedule.lookupBoardingPass(id));
            }
            catch(Exception e){
                String name = SearchBar_TextField.getText();
                foundPasses = FlightSchedule.lookupBoardingPass(name);
            }
            if(foundPasses.size() == 0){
                main_error_label.setText("FLIGHT MISSING.");
                main_error_label.setOpacity(1);
            }
            else {
                Flights_Table.setItems(foundPasses);
            }
        }
        catch(Exception e){
            main_error_label.setText("FLIGHT MISSING.");
            main_error_label.setOpacity(1);
        }
    }

    @FXML
    private void onBookFlightClick(ActionEvent event) throws IOException {
        loadWindow("Form_view", event);
    }

    @FXML
    private void  onDetailsClick(ActionEvent event) throws IOException {
        uiRESET();
        selectedBoardingPass = Flights_Table.getSelectionModel().getSelectedItem();

        if(selectedBoardingPass != null){
            loadWindow("Details_view", event);
        } else {
            main_error_label.setText("SELECT A FLIGHT TO VIEW IT'S DETAILS.");
            main_error_label.setOpacity(1);
        }

    }

    @FXML
    private void  onCancelClick(ActionEvent event){
        uiRESET();
        selectedBoardingPass = Flights_Table.getSelectionModel().getSelectedItem();

        if(selectedBoardingPass != null){
            main_error_label.setText("Are you sure you would like to cancel the flight with ticket id : " + selectedBoardingPass.getTicketID() + "?");
            main_error_label.setOpacity(1);
            yes_btn.setOpacity(1);
            no_btn.setOpacity(1);
            yes_btn.setDisable(false);
            no_btn.setDisable(false);
        }else{
            main_error_label.setText("SELECT A FLIGHT TO CANCEL.");
            main_error_label.setOpacity(1);
        }


    }

    @FXML
    private void onYesClick(ActionEvent event){
        uiRESET();
        Boolean deleted = FlightSchedule.cancelFlight(selectedBoardingPass);

        Flights_Table.setItems(FlightSchedule.getAllBoardingPasses());
        if(!deleted){
            main_error_label.setText("FLIGHT FAILED TO BE CANCELED.");
            main_error_label.setOpacity(1);
        }
    }

    @FXML
    private void onNoClick(ActionEvent event){
      uiRESET();
    }

    public void uiRESET(){
        main_error_label.setOpacity(0);
        yes_btn.setOpacity(0);
        no_btn.setOpacity(0);

        yes_btn.setDisable(true);
        no_btn.setDisable(true);
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