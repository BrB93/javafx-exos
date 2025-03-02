package Ex11;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.*;
import java.util.*;

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
    private String username;

    @FXML
    private void handleStart() {
        username = askForUsername();
        if (username == null || username.isEmpty()) {
            return; // Si l'utilisateur annule ou ne rentre pas de pseudo, ne pas démarrer le jeu
        }

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

    private String askForUsername() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Pseudo");
        dialog.setHeaderText("Entrez votre pseudo");
        dialog.setContentText("Pseudo:");
        Optional<String> result = dialog.showAndWait();
        return result.orElse(null);
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
        saveScoreToFile(username, score);
        displayScoresForUser(username);
    }

    private void saveScoreToFile(String username, int score) {
        Map<String, List<Integer>> scoresMap = readScoresFromFile();
        scoresMap.computeIfAbsent(username, k -> new ArrayList<>()).add(score);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/Ex11/scores.txt"))) {
            for (Map.Entry<String, List<Integer>> entry : scoresMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue().toString().replace("[", "").replace("]", ""));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, List<Integer>> readScoresFromFile() {
        Map<String, List<Integer>> scoresMap = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Ex11/scores.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String username = parts[0];
                    String[] scores = parts[1].split(", ");
                    List<Integer> scoreList = new ArrayList<>();
                    for (String score : scores) {
                        scoreList.add(Integer.parseInt(score));
                    }
                    scoresMap.put(username, scoreList);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return scoresMap;
    }

    private void displayScoresForUser(String username) {
        Map<String, List<Integer>> scoresMap = readScoresFromFile();
        List<Integer> scores = scoresMap.getOrDefault(username, Collections.emptyList());
        System.out.println("Scores pour " + username + ": " + scores);
    }

    @FXML
    private void handleRestart() {
        if (timeline != null) {
            timeline.stop();
        }
        handleStart();
    }
}