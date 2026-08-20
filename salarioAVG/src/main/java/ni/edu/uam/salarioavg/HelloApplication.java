package ni.edu.uam.salarioavg;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox();
        root.setPadding(new Insets(30));
        root.setSpacing(15);

        Label lblTitle = new Label("Salario de Trabajador");

        Label lblSalario = new Label("Salario");
        TextField tfSalario = new TextField();

        Button btnCalcular = new Button("Calcular");

        Label lblSeguro = new Label("Seguro Social");
        Label lblBono = new Label("Bono");
        Label lblSalarioFinal = new Label("Salario Final");

        btnCalcular.setOnAction(e -> {

            double salario = Double.parseDouble(tfSalario.getText());

            double seguro = salario * 0.07;

            double bono;

            if (salario < 12000) {
                bono = salario * 0.10;
            } else if (salario <= 20000) {
                bono = salario * 0.05;
            } else {
                bono = salario * 0.03;
            }

            double salarioFinal = salario - seguro + bono;

            lblSeguro.setText("Seguro Social: " + seguro);
            lblBono.setText("Bono: " + bono);
            lblSalarioFinal.setText("Salario Final: " + salarioFinal);
        });

        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(10));

        buttons.getChildren().addAll(btnCalcular);

        root.getChildren().addAll(
                lblTitle,
                lblSalario,
                tfSalario,
                lblSeguro,
                lblBono,
                lblSalarioFinal,
                buttons
        );

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();
    }
}
