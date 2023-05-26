package com.example.basketball_stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

public class HelloController {
    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView courtImage;
    @FXML
    private ComboBox<String> quarterComboBox;




    @FXML
    private void initialize() {
        // Get the list of items and add new items
        quarterComboBox.getItems().addAll("1°Q","2°Q","3°Q","4°Q");

    }
    @FXML
    void selectQuarter(ActionEvent event) {

    }


}