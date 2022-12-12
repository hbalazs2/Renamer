package com.example.renamer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
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
    public void onRenameButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("rename.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 180);
            Stage renameStage = (Stage) renameButton.getScene().getWindow();
            renameStage.setTitle("Rename");
            renameStage.setScene(scene);
            renameStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onPrintButtonClick() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("print.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 180);
            Stage renameStage = (Stage) renameButton.getScene().getWindow();
            renameStage.setTitle("Print");
            renameStage.setScene(scene);
            renameStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onExitButtonClick(){
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
