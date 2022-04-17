module com.example.renamer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.renamer to javafx.fxml;
    exports com.example.renamer;
}