package com.example.renamer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PrintController {
    @FXML
    private Label displayLabel = new Label();

    @FXML
    private TextField path = new TextField();

    @FXML
    private Button chooseDirButton = new Button();

    @FXML
    private Button printButton = new Button();

    @FXML
    private Button backButton = new Button();

    @FXML
    private Button exitButton = new Button();

    @FXML
    private FileChooser fileChooser = new FileChooser();

    private List<File> selectedFiles;

    public void initialize() {
        displayLabel.setText("Enter the path: ");
        chooseDirButton.setText("Select files");
    }

    @FXML
    private void onPrintButtonClick() {
        if (path.getText().isEmpty()) {
            System.out.println("Path: " + path.getText() + "|");
            displayLabel.setText("Path is empty, please enter valid path!");
            displayLabel.setText(displayLabel.getText().toUpperCase());
            displayLabel.setTextFill(Color.web("Red"));
        } else {
            Print print = new Print();
            //List<File> filesPrinted = print.printFiles();
            int prints = print.printFiles(this.selectedFiles);
            displayLabel.setTextFill(Color.web("Black"));
            displayLabel.setText(prints + " file(s) printed.");
        }
    }

    @FXML
    public void onSelectDirClick() {
        if (fileChooser.getInitialDirectory() == null) {
            fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        }
        Stage directoryStage = new Stage();
        this.selectedFiles = fileChooser.showOpenMultipleDialog(directoryStage);

        if (this.selectedFiles != null) {
            if (this.selectedFiles.size() > 1) {
                path.setText(this.selectedFiles.get(0).getAbsolutePath());
                displayLabel.setText("You have selected multiple files.");
            }
            else {
                path.setText(this.selectedFiles.get(0).getAbsolutePath());
                displayLabel.setText("You have selected one file.");
            }
            System.out.println(selectedFiles.get(0).getParentFile());
            fileChooser.setInitialDirectory(selectedFiles.get(0).getParentFile());
        }
    }

    @FXML
    public void onBackButtonClick() {
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        Main main = new Main();
        main.start(primaryStage);
    }

    @FXML
    public void onExitButtonClick() {
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
