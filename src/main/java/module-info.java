module com.fxexample.lab1to3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.fxexample.lab1to3 to javafx.fxml;
    exports com.fxexample.lab1to3;
}