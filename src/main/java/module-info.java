module com.example.rentalsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.rentalsystem to javafx.fxml;
    exports com.example.rentalsystem;
}