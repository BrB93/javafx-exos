package Ex8;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

public class Exo8Controller {

    @FXML
    private void handleOpenWindow() {
        // Demander à l'utilisateur de saisir un message
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Saisir le message");
        dialog.setHeaderText("Entrez votre message:");
        Optional<String> result = dialog.showAndWait();

        result.ifPresent(message -> {
            // Créer et afficher la nouvelle fenêtre avec le message saisi
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nouvelle Fenêtre");

            VBox vbox = new VBox(new Label(message), new Button("Fermer"));
            vbox.setSpacing(10);
            vbox.setStyle("-fx-padding: 10px; -fx-alignment: center;");

            Button closeButton = (Button) vbox.getChildren().get(1);
            closeButton.setOnAction(e -> stage.close());

            Scene scene = new Scene(vbox, 300, 200);
            stage.setScene(scene);
            stage.showAndWait();
        });
    }
}