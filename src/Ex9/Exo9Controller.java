package Ex9;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.util.Duration;

public class Exo9Controller {

    @FXML
    private ProgressBar progressBar;

    @FXML
    private void handleLoad() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(progressBar.progressProperty(), 0)),
                new KeyFrame(Duration.seconds(5), new KeyValue(progressBar.progressProperty(), 1))
        );
        timeline.play();
    }

    @FXML
    private void handleCancel() {
        progressBar.setProgress(0);
    }
}