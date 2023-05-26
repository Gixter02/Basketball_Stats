package com.example.basketball_stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class HelloController {

    @FXML
    private Label twoPontersShot;
    @FXML
    private Button made2Shot;

    @FXML
    private Button missed2Shot;
    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView courtImage;
    @FXML
    private ComboBox<String> quarterComboBox;


    public int attemptedShot = 0;
    public int madeShot = 0;

    public double x = 0.0;
    public double y = 0.0;


    @FXML
    private void initialize() {
        // Get the list of items and add new items
        quarterComboBox.getItems().addAll("1°Q","2°Q","3°Q","4°Q");

        twoPontersShot.setText(String.valueOf(madeShot) + "/" + String.valueOf(attemptedShot));
    }
    @FXML
    void selectQuarter(ActionEvent event) {

    }
    @FXML
    void made2PShot(ActionEvent event) {
        attemptedShot++;
        madeShot++;
        twoPontersShot.setText(String.valueOf(madeShot) + "/" + String.valueOf(attemptedShot));
    }

    @FXML
    void missed2PShot(ActionEvent event) {
        attemptedShot++;
        twoPontersShot.setText(String.valueOf(madeShot) + "/" + String.valueOf(attemptedShot));
    }
    @FXML
    void handleClick(MouseEvent event) {
        x = event.getX();
        y = event.getY();
        System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
    }


}