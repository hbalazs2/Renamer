package com.example.renamer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 180);
            primaryStage.setTitle("Rename or print");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}