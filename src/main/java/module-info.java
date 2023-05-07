module com.example.contacts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.contacts to javafx.fxml;
    exports com.example.contacts;
}