package Ex11;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.Random;

public class Exo11Controller {

    @FXML
    private Button button;
    @FXML
    private Label label;
    @FXML
    private Label timerLabel;
    @FXML
    private Pane vbox;  // Le Pane pour le jeu (center dans le BorderPane)

    private int score = 0;
    private Random random = new Random();
    private Timeline timeline;
    private int timeRemaining = 10;

    @FXML
    private void handleStart() {
        score = 0;
        timeRemaining = 10;
        label.setText("Score: " + score);
        timerLabel.setText("Temps restant: " + timeRemaining);
        button.setText("Click me!");
        button.setDisable(false);

        // Initialiser la position du bouton
        moveButton();

        // Ajouter l'action pour déplacer le bouton et augmenter le score à chaque clic
        button.setOnAction(event -> {
            handleButtonClick();
            moveButton(); // Déplace le bouton à chaque clic
        });

        // Crée une Timeline pour mettre à jour le timer chaque seconde
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTimer()));
        timeline.setCycleCount(10); // 10 secondes
        timeline.setOnFinished(event -> endGame());
        timeline.play();
    }

    // Méthode pour déplacer le bouton à une position aléatoire dans le Pane avec une transition fluide
    private void moveButton() {
        // Calculer une position aléatoire dans le Pane
        double x = random.nextDouble() * (vbox.getWidth() - button.getWidth());
        double y = random.nextDouble() * (vbox.getHeight() - button.getHeight());

        // Créer une transition pour déplacer le bouton
        TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), button);
        transition.setToX(x);
        transition.setToY(y);
        transition.play();
    }

    @FXML
    private void handleButtonClick() {
        score++;
        label.setText("Score: " + score);
    }

    private void updateTimer() {
        timeRemaining--;
        timerLabel.setText("Temps restant: " + timeRemaining);
    }

    private void endGame() {
        button.setDisable(true);
        label.setText("Jeu terminé! Score final: " + score);
        System.out.println("Jeu terminé! Score final: " + score);
    }

    @FXML
    private void handleRestart() {
        if (timeline != null) {
            timeline.stop();
        }
        handleStart();
    }
}