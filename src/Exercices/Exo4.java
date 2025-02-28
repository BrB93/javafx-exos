package Exercices;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Exo4 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Change my color");

        Button redButton = new Button("rouge");
        Button greenButton = new Button("vert");
        Button yellowButton = new Button("yellow");

        VBox vBox = new VBox(50, label);
        HBox hBox = new HBox(50, redButton, greenButton, yellowButton);
        vBox.getChildren().add(hBox);
        vBox.setStyle("-fx-padding: 10px;");

        redButton.setOnAction(e -> {
            vBox.setStyle("-fx-background-color: red; -fx-padding: 10px;");
        });

        greenButton.setOnAction(e -> {
            vBox.setStyle("-fx-background-color: green; -fx-padding: 10px;");
        });

        yellowButton.setOnAction(e -> {
            vBox.setStyle("-fx-background-color: yellow; -fx-padding: 10px;");
        });

        Scene scene = new Scene(vBox, 600, 500);
        primaryStage.setTitle("Color Change Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}