module ni.edu.uam.ejemplo2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.ejemplo2 to javafx.fxml;
    exports ni.edu.uam.ejemplo2;
}