package com.example.basketball_stats;

import com.example.basketball_stats.classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;


public class TeamInsertionDialogController {

    @FXML
    private Button addPlayerButton;

    @FXML
    private TextField firstNameTextfield;

    @FXML
    private TextField lastNameTextfield;

    @FXML
    private TextField numberOfPlayerTextField;

    @FXML
    private Label numberOfPlayersAddedLabel;

    @FXML
    private ComboBox<String> numberOfPlayersToAddCombobox;

    Integer numberOfPlayersToAdd;
    Integer numberOfPlayersAdded;
    LinkedList<Player> players;
    @FXML
    public void initialize(){
        numberOfPlayersToAddCombobox.getItems().addAll("5","6","7","8","9","10","11","12");
        players = new LinkedList<>();
        numberOfPlayersToAdd=0;
        numberOfPlayersAdded = 0;
    }
    @FXML
    void handleAddPlayer(ActionEvent event) {
        if(numberOfPlayersAdded < numberOfPlayersToAdd) {
            Player newPlayer = new Player(getFirstNameFromTextField(), getLastNameFromTextField(), Integer.valueOf(getNumberFromTextField()));
            players.add(newPlayer);
            numberOfPlayersAdded++;
            updateNumberOfPlayersAdded(numberOfPlayersAdded);
            resetTextFields();
        }
    }
    @FXML
    void handleSelectedNumberOfPlayersToAdd(ActionEvent event) {
        numberOfPlayersToAdd= Integer.valueOf(numberOfPlayersToAddCombobox.getValue());
        updateNumberOfPlayersAdded(0);
    }
    String getFirstNameFromTextField(){
        return firstNameTextfield.getText();
    }
    String getLastNameFromTextField(){
        return lastNameTextfield.getText();
    }
    String getNumberFromTextField(){
        return numberOfPlayerTextField.getText();
    }
    void resetTextFields(){
        firstNameTextfield.setText("");
        lastNameTextfield.setText("");
        numberOfPlayerTextField.setText("");
    }
    void updateNumberOfPlayersAdded(Integer numberOfPlayersAdded){
        numberOfPlayersAddedLabel.setText(numberOfPlayersAdded.toString());
    }
    public LinkedList<Player> getListOfPlayers(){
        return players;
    }
    int getNumberOfPlayersToAdd(){
        return numberOfPlayersToAdd;
    }



}


