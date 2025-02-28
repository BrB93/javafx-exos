package Exercices;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo3 extends Application {
    private int count = 0;

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label(String.valueOf(count));
        Button incrementButton = new Button("+");
        Button decrementButton = new Button("-");

        incrementButton.setOnAction(e -> {
            count++;
            label.setText(String.valueOf(count));
        });

        decrementButton.setOnAction(e -> {
            count--;
            label.setText(String.valueOf(count));
        });

        HBox buttons = new HBox(10, decrementButton, incrementButton);
        VBox vBox = new VBox(10, label, buttons);
        vBox.setStyle("-fx-padding: 10px; -fx-alignment: center;");

        Scene scene = new Scene(vBox, 200, 150);

        primaryStage.setTitle("Counter Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}