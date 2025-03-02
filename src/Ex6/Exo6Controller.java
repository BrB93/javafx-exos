package Ex6;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Optional;

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

    private ObservableList<Person> persons;

    @FXML
    private void initialize() {
        // Initialize the columns
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        // Create a list of persons
        persons = FXCollections.observableArrayList(
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

    @FXML
    private void addPerson() {
        // Use dialogs to get user input
        TextInputDialog lastNameDialog = new TextInputDialog();
        lastNameDialog.setTitle("Add Person");
        lastNameDialog.setHeaderText("Enter the last name of the person:");
        Optional<String> lastNameResult = lastNameDialog.showAndWait();

        TextInputDialog firstNameDialog = new TextInputDialog();
        firstNameDialog.setTitle("Add Person");
        firstNameDialog.setHeaderText("Enter the first name of the person:");
        Optional<String> firstNameResult = firstNameDialog.showAndWait();

        TextInputDialog ageDialog = new TextInputDialog();
        ageDialog.setTitle("Add Person");
        ageDialog.setHeaderText("Enter the age of the person:");
        Optional<String> ageResult = ageDialog.showAndWait();

        if (lastNameResult.isPresent() && firstNameResult.isPresent() && ageResult.isPresent()) {
            try {
                int age = Integer.parseInt(ageResult.get());
                Person person = new Person(lastNameResult.get(), firstNameResult.get(), age);
                persons.add(person);
            } catch (NumberFormatException e) {
                // Handle invalid age input
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Input");
                alert.setHeaderText("Invalid age input");
                alert.setContentText("Please enter a valid number for age.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void removePerson() {
        // Remove the selected person from the list
        Person selectedPerson = tableView.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            persons.remove(selectedPerson);
        }
    }
}