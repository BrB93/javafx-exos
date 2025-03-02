package Ex10;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;

public class Exo10Controller {

    @FXML
    private TabPane tabPane;

    @FXML
    private void initialize() {
        // Créer les onglets
        Tab tabAccueil = new Tab("Accueil", new VBox(new Label("Contenu de l'onglet Accueil")));
        Tab tabProfil = new Tab("Profil", new VBox(new Label("Contenu de l'onglet Profil")));
        Tab tabParametres = new Tab("Paramètres", new VBox(new Label("Contenu de l'onglet Paramètres")));

        // Ajouter les onglets au TabPane
        tabPane.getTabs().addAll(tabAccueil, tabProfil, tabParametres);
    }
}