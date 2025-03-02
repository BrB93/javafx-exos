package Ex6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Exo6Controller {

    @FXML
    private TableView<Person> tableView;

    @FXML
    private TableColumn<Person, String> firstNameColumn;

    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private TableColumn<Person, Integer> ageColumn;

    @FXML
    private Label label;

    @FXML
    private void initialize() {
        // Initialize the columns
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        // Create a list of persons
        ObservableList<Person> persons = FXCollections.observableArrayList(
                new Person("Doe", "John", 25),
                new Person("Doe", "Jane", 22),
                new Person("Doe", "Alice", 30),
                new Person("Doe", "Bob", 28),
                new Person("Doe", "Eve", 35)
        );
        tableView.setItems(persons);
    }

    @FXML
    private void handleButtonAction() {
        // Display the selected person in the console
        System.out.println("Selected person: " + tableView.getSelectionModel().getSelectedItem());
    }
}