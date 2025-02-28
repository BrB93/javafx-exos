package Exercices;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Exo1 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button button = new Button("Click Me");
        StackPane root = new StackPane(button);
        Scene scene = new Scene(root, 400, 300);

        button.setOnAction(e -> {
           System.out.println("Hello, JavaFX !");
        });

        primaryStage.setTitle("JavaFX Test exo1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

