package com.deanwhitten.boarding_pass_v2;

import Model.BoardingPass;
import Model.FlightSchedule;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main_View.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 500);
        stage.setResizable(false);
        stage.setTitle("Boarding Pass v2");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        FlightSchedule.addBoardingPass(new BoardingPass(1000, "Sandra Smith", "Sandra.Bulick@email.com", "999-999" +
                "-9999", "Female", 45, LocalDate.of(2022, 10, 1), LocalTime.parse("10:00"), "Augusta, Maine",
                "Juneau," +
                " " +
                "Alaska", 60, LocalTime.of(11, 30), 100.00, 0.00, -25.00, 75.00));


        launch();
    }
}