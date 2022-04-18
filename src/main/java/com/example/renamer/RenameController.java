package com.example.renamer;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.List;

public class RenameController {

    @FXML
    private ComboBox<String> extensionPicker = new ComboBox<>();

    @FXML
    private TextField path = new TextField();

    @FXML
    private Label displayLabel = new Label();

    @FXML
    private Label extensionLabel = new Label();

    @FXML
    private Button backButton = new Button();

    @FXML
    private Button exitButton = new Button();

    @FXML
    private Button renameButton = new Button();

    @FXML
    private Button chooseDir = new Button();

    @FXML
    private DirectoryChooser directoryChooser = new DirectoryChooser();

    public void initialize() {
        displayLabel.setText("Enter the path: ");
        setExtensionPicker();
        extensionLabel.setText("Select extension");
        extensionPicker.setEditable(true);
        directoryChooser.setInitialDirectory(new File("src/main/java/com/example/renamer"));
        chooseDir.setText("Select Directory");

//   If you want to set the buttons inside the code
//        setButtonBar(this.buttonBar);
//        System.out.println(extensionPicker.getValue());
    }

    @FXML
    private void onRenameButtonClick() {
        if (path.getText().isEmpty()) {
            System.out.println("Path: " + path.getText() + "|");
            displayLabel.setText("Path is empty, please enter valid path!");
            displayLabel.setText(displayLabel.getText().toUpperCase());
            displayLabel.setTextFill(Color.web("Red"));
        } else {
            Rename rename = new Rename(path.getText(), extensionPicker.getValue());
            List<File> filesRenamed = rename.renameFiles();
            displayLabel.setTextFill(Color.web("Black"));
            displayLabel.setText(filesRenamed.size() + " file(s) renamed.");
        }
    }

    public void setExtensionPicker() {
        this.extensionPicker.setItems(FXCollections.observableArrayList(
                ".txt",
                ".pdf",
                ".doc",
                "(other)"
        ));
    }

//    - if you want to set the buttons inside the code
//    public void setButtonBar(ButtonBar buttonBar) {
//        buttonBar.getButtons().addAll(exitButton, renameButton);
//        ButtonBar.setButtonData(renameButton, ButtonBar.ButtonData.LEFT);
//        ButtonBar.setButtonData(exitButton, ButtonBar.ButtonData.BACK_PREVIOUS);
//    }

    @FXML
    public void onSelectDirClick() {
        Stage directoryStage = new Stage();
        File selectedDirectory = directoryChooser.showDialog(directoryStage);
        if (selectedDirectory != null) {
            path.setText(selectedDirectory.getAbsolutePath());
        }
    }

    @FXML
    public void onBackButtonClick() {
        Stage primaryStage = (Stage) backButton.getScene().getWindow();
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("home.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 400, 100);
            primaryStage.setTitle("Rename or print");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void onExitButtonClick() {
        // get a handle to the stage
        Stage stage = (Stage) exitButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}