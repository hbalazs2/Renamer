package com.example.renamer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button renameButton = new Button();

    @FXML
    private Button printButton = new Button();

    @FXML
    private Button exitButton = new Button();

    @FXML
    public void onRenameButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("rename.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 180);
        Stage renameStage = (Stage) renameButton.getScene().getWindow();
        renameStage.setTitle("Rename");
        renameStage.setScene(scene);
        renameStage.show();
    }

    @FXML
    public void onPrintButtonClick() throws IOException {
        System.out.println("im in the print");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("print.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 180);
        Stage renameStage = (Stage) renameButton.getScene().getWindow();
        renameStage.setTitle("Rename");
        renameStage.setScene(scene);
        renameStage.show();
    }

    @FXML
    public void onExitButtonClick(){
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
