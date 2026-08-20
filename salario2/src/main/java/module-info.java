module ni.edu.uam.salario2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.salario2 to javafx.fxml;
    exports ni.edu.uam.salario2;
}