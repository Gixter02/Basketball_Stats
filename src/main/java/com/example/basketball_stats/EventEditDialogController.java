package com.example.basketball_stats;
import com.example.basketball_stats.classes.OurEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class EventEditDialogController {

    @FXML
    private Button assistButton;

    @FXML
    private Button blockButton;

    @FXML
    private Button defensiveReboundButton;

    @FXML
    private Button foulButton;

    @FXML
    private Button madeFreeThrowsButton;

    @FXML
    private Button madeShotButton;

    @FXML
    private Button missedFreeThrowsButton;

    @FXML
    private Button missedShotButton;

    @FXML
    private TextField numberTextField;

    @FXML
    private Button offensiveReboundButton;

    @FXML
    private Button stealButton;

    @FXML
    private Button turnoverButton;

    String eventType;
    //String whoDidIt;
    //OurEvent ourEvent = new OurEvent("tiro","numero", "1", 50, 50);
    //@FXML
            //public void initialize(){
                    //
            //}

    public String getStringFromTextField(){
        return numberTextField.getText();
    }
    public String getStringFromSelectedButton(){
        return eventType;
    }
    @FXML
    public void handleButton(ActionEvent event){
        Button clickedButton = (Button) event.getSource();
        eventType = clickedButton.getText();
    }
}
