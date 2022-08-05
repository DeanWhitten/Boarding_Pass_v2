package com.deanwhitten.boarding_pass_v2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        launch();
    }
}