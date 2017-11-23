package com.timeOrganizer.view;

import com.timeOrganizer.Main;
import com.timeOrganizer.model.Adventure;
import com.timeOrganizer.model.Person;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdventureOverviewController {

    @FXML
    private Label adventureDateLabel;

    @FXML
    private Label adventureNameLabel;

    @FXML
    private Label adventureAddressLabel;

    @FXML
    private TableView<Adventure> adventureTable;
    @FXML
    private TableColumn<Adventure, String> adventureNameColumn;
    @FXML
    private TableColumn<Adventure, String> adventureAddressColumn;

    private Main main;

    public AdventureOverviewController() {
    }

    private void showAdventureDetails(Adventure adventure) {
        if (adventure != null) {
            // Fill the labels with info from the person object.
            adventureDateLabel.setText(adventure.getAdventureDateTime().toString());
            adventureNameLabel.setText(adventure.getName());
            adventureAddressLabel.setText(adventure.getAddress());
        } else {
            // Person is null, remove all the text.
            adventureDateLabel.setText("");
            adventureNameLabel.setText("");
            adventureAddressLabel.setText("");
        }
    }


    @FXML
    private void initialize() {
        // Initialize the person table with the two columns.
        adventureNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        adventureAddressColumn.setCellValueFactory(cellData -> cellData.getValue().addressProperty());

        // Clear person details.
        showAdventureDetails(null);

        // Listen for selection changes and show the person details when changed.
        adventureTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showAdventureDetails(newValue));

    }

    /**
     * Called when the user clicks on the delete button.
     */
    @FXML
    private void handleDeletePerson() {
        int selectedIndex = adventureTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            adventureTable.getItems().remove(selectedIndex);
        } else {
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a adventure in the table.");

            alert.showAndWait();
        }
    }

    public void setMainApp(Main main) {
        this.main = main;

        // Add observable list data to the table
        adventureTable.setItems(main.getAdventureData());
    }
}