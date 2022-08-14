package com.deanwhitten.boarding_pass_v2;

import Model.BoardingPass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main_Controller {
    @FXML
    private TextField SearchBar_TextField;
    @FXML
    private TableView<BoardingPass> Flights_Table;
    @FXML
    private TableColumn<BoardingPass, Integer> ticketID_Col;
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

    public Label error_label;
    public Button yes_btn;
    public Button no_btn;

    @FXML
    private void onSearchBarInput(KeyEvent keyEvent){
        
    }

    @FXML
    private void onBookFlightClick(ActionEvent event) throws IOException {
        loadWindow("Form_view", event);
    }

    @FXML
    private void  onDetailsClick(ActionEvent event) throws IOException {
        loadWindow("Details_view", event);
    }

    @FXML
    private void  onCancelClick(ActionEvent event){

    }

    @FXML
    private void onYesClick(ActionEvent event){
        
    }

    @FXML
    private void onNoClick(ActionEvent event){

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