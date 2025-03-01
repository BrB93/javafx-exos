package Ex5;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;

public class Exo5Controller {

    @FXML
    private ComboBox<String> comboBox;

    @FXML
    private Label label;

    @FXML
    private void initialize() {
        // Initialisation des éléments du ComboBox
        comboBox.setItems(FXCollections.observableArrayList(
                "Paris", "Lyon", "Marseille", "Toulouse", "Nice", "Nantes",
                "Strasbourg", "Montpellier", "Bordeaux", "Lille"
        ));

        // Action lorsque l'élément du ComboBox est sélectionné
        comboBox.setOnAction(e -> {
            label.setText("Ville sélectionnée : " + comboBox.getValue());
        });
    }

    @FXML
    private void handleButtonAction() {
        // Affiche la ville sélectionnée dans la console
        System.out.println("Voici la ville sélectionnée : " + comboBox.getValue());
    }
}
