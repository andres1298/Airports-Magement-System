package com.aeropuertos.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;

public class MainUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML/Login.fxml"));
        primaryStage.setTitle("Captain - Airport Management");
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.setScene(new Scene(root,900,650));
        primaryStage.show();
    }
}
