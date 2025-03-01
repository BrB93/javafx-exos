package Ex5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo5 extends Application {

    @Override
    public void start(Stage primaryStage) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Paris", "Lyon", "Marseille", "Toulouse", "Nice", "Nantes", "Strasbourg", "Montpellier", "Bordeaux", "Lille");
        Label label = new Label("Ville selectionnée : ");
        Button button = new Button("Afficher la ville selectionnée dans la console");

        VBox vBox = new VBox(10, comboBox, label, button);
        vBox.setStyle("-fx-padding: 10px; -fx-alignment: center;");

        Scene scene = new Scene(vBox, 800, 800);

        button.setOnAction(e -> {
            System.out.println("Voici la ville selectionnée : " + comboBox.getValue());
        });

        comboBox.setOnAction(e -> {
            label.setText("Ville selectionnée : " + comboBox.getValue());
        });

        primaryStage.setTitle("JavaFX Sélection de la Ville exo5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}