package com.example.basketball_stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class HelloController {
    @FXML
    private ComboBox quarterComboBox;
    @FXML
    private ComboBox filterBox;

    @FXML
    private void initialize() {
        // Get the list of items and add new items
        quarterComboBox.getItems().addAll("1°Q","2°Q","3°Q","4°Q");
        filterBox.getItems().addAll("1°Q","2°Q","3°Q","4°Q","1°Half","2°Half","Game","Player...");
    }
    @FXML
    void selectQuarter(ActionEvent event) {

    }
    @FXML
    void filterData(ActionEvent event) {

    }

}