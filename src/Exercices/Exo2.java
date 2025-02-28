package Exercices;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo2 extends Application {
    @Override
    public void start(Stage primaryStage) {
        TextField textField = new TextField();
        Label label = new Label("Tappez votre texte : ");

        textField.textProperty().addListener((observable, oldValue, newValue) -> {
            label.setText(newValue);
        });

        VBox vBox = new VBox(10, label, textField);
        vBox.setStyle("-fx-padding: 10px;");

        Scene scene = new Scene(vBox, 400, 300);


        primaryStage.setTitle("JavaFX Test exo2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}