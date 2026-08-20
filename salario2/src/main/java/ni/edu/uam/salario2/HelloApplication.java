package ni.edu.uam.salario2;

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

        Label lblTitle = new Label("Salarios de Empleados");

        Label lblCantidad = new Label("Cantidad de empleados");
        TextField tfCantidad = new TextField();

        Label lblSalarios = new Label("Ingrese los salarios separados por coma");
        TextField tfSalarios = new TextField();

        Button btnCalcular = new Button("Calcular");

        Label lblMayor = new Label("Salario más alto");
        Label lblMenor = new Label("Salario más bajo");
        Label lblPromedio = new Label("Promedio");
        Label lblModa = new Label("Moda");

        btnCalcular.setOnAction(e -> {

            int cantidad = Integer.parseInt(tfCantidad.getText());

            String textoSalarios = tfSalarios.getText();

            String[] salarios = textoSalarios.split(",");

            double mayor = Double.parseDouble(salarios[0]);
            double menor = Double.parseDouble(salarios[0]);

            double suma = 0;

            for (int i = 0; i < cantidad; i++) {

                double salario = Double.parseDouble(salarios[i].trim());

                suma = suma + salario;

                if (salario > mayor) {
                    mayor = salario;
                }

                if (salario < menor) {
                    menor = salario;
                }
            }

            double promedio = suma / cantidad;

            double moda = Double.parseDouble(salarios[0]);
            int mayorRepeticiones = 0;

            for (int i = 0; i < cantidad; i++) {

                double salarioActual = Double.parseDouble(salarios[i].trim());

                int repeticiones = 0;

                for (int j = 0; j < cantidad; j++) {

                    double otroSalario = Double.parseDouble(salarios[j].trim());

                    if (salarioActual == otroSalario) {
                        repeticiones++;
                    }
                }

                if (repeticiones > mayorRepeticiones) {
                    mayorRepeticiones = repeticiones;
                    moda = salarioActual;
                }
            }

            lblMayor.setText("Salario más alto: " + mayor);
            lblMenor.setText("Salario más bajo: " + menor);
            lblPromedio.setText("Promedio: " + promedio);
            lblModa.setText("Moda: " + moda);
        });

        HBox buttons = new HBox();
        buttons.setSpacing(15);
        buttons.setPadding(new Insets(10));

        buttons.getChildren().addAll(btnCalcular);

        root.getChildren().addAll(
                lblTitle,
                lblCantidad,
                tfCantidad,
                lblSalarios,
                tfSalarios,
                lblMayor,
                lblMenor,
                lblPromedio,
                lblModa,
                buttons
        );

        Scene scene = new Scene(root, 600, 400);

        stage.setTitle("UAM");
        stage.setScene(scene);
        stage.show();
    }
}