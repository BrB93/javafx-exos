package Ex8;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Exo8 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charge le fichier FXML avec le bon chemin relatif
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Exo8.fxml")));

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("JavaFX Affichage d'une liste de d'images exo8");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}