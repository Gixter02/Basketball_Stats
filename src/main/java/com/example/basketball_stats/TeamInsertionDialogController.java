package com.example.basketball_stats;

import com.example.basketball_stats.classes.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.LinkedList;


public class TeamInsertionDialogController {
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
    void handleAddPlayer() {
        if(numberOfPlayersAdded < numberOfPlayersToAdd) {
            if(getFirstNameFromTextField().matches("[a-zA-Z]+") && getLastNameFromTextField().matches("[a-zA-Z]+") && getNumberFromTextField().matches("[0-9]+")) {
                Player newPlayer = new Player(getFirstNameFromTextField(), getLastNameFromTextField(), Integer.valueOf(getNumberFromTextField()));
                players.add(newPlayer);
                numberOfPlayersAdded++;
                updateNumberOfPlayersAdded(numberOfPlayersAdded);
            }else{
                new Alert(Alert.AlertType.ERROR, "First and Last Name should only contain Letters, Number should only contain Numbers").showAndWait();
            }
            resetTextFields();
        }
    }
    @FXML
    void handleSelectedNumberOfPlayersToAdd() {
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


