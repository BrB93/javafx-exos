package Ex10;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Exo10 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Charge le fichier FXML avec le bon chemin relatif
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Exo10.fxml")));

        Scene scene = new Scene(root, 800, 800);
        primaryStage.setTitle("JavaFX Affichage d'une interface avec plusieurs onglets");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}