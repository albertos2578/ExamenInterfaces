module com.mycompany.exameninterfaces {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires java.base;

    opens com.mycompany.exameninterfaces to javafx.fxml;
    opens models;
    exports com.mycompany.exameninterfaces;
}
