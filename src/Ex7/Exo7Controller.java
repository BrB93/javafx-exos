package Ex7;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;

import java.io.File;
import java.util.Optional;

public class Exo7Controller {

    @FXML
    private Pane pane;

    @FXML
    private Label label;

    @FXML
    private ListView<String> listView;

    @FXML
    private ImageView imageView;

    private ObservableList<String> images;

    @FXML
    private void initialize() {
        // Initialize the list of images with valid URLs of random images from Picsum Photos
        images = FXCollections.observableArrayList(
                "https://picsum.photos/800/600?random=1",
                "https://picsum.photos/800/600?random=2",
                "https://picsum.photos/800/600?random=3",
                "https://picsum.photos/800/600?random=4",
                "https://picsum.photos/800/600?random=5"
        );
        listView.setItems(images);

        // Set custom cell factory to display thumbnails
        listView.setCellFactory(param -> new ListCell<>() {
            private final ImageView thumbnail = new ImageView();

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    thumbnail.setImage(new Image(item, 50, 50, true, true));
                    setGraphic(thumbnail);
                }
            }
        });
    }

    @FXML
    private void handleListViewClick() {
        // Display the selected image in the ImageView
        String selectedImage = listView.getSelectionModel().getSelectedItem();
        if (selectedImage != null) {
            imageView.setImage(new Image(selectedImage));
            label.setText("Selected image: " + selectedImage);
        }
    }

    @FXML
    private void addImage() {
        // Use dialogs to get user input
        TextInputDialog imageDialog = new TextInputDialog();
        imageDialog.setTitle("Add Image");
        imageDialog.setHeaderText("Enter the URL of the image:");
        Optional<String> imageResult = imageDialog.showAndWait();
        imageResult.ifPresent(images::add);
    }

    @FXML
    private void removeImage() {
        // Remove the selected image
        String selectedImage = listView.getSelectionModel().getSelectedItem();
        if (selectedImage != null) {
            images.remove(selectedImage);
            imageView.setImage(null);
            label.setText("Selected image: ");
        }
    }

    @FXML
    private void handleDragOver(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.COPY);
        }
        event.consume();
    }

    @FXML
    private void handleDragDropped(DragEvent event) {
        var db = event.getDragboard();
        boolean success = false;
        if (db.hasFiles()) {
            success = true;
            for (File file : db.getFiles()) {
                String filePath = file.getAbsolutePath();
                images.add(filePath);
                imageView.setImage(new Image("file:" + filePath));
                label.setText("Selected image: " + filePath);
            }
        }
        event.setDropCompleted(success);
        event.consume();
    }
}