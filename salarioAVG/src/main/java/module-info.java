module ni.edu.uam.salarioavg {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.salarioavg to javafx.fxml;
    exports ni.edu.uam.salarioavg;
}