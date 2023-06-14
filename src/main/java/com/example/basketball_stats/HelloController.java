package com.example.basketball_stats;

import com.example.basketball_stats.classes.OurEvent;
import com.example.basketball_stats.classes.Player;
import com.example.basketball_stats.classes.Point;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class HelloController {
    @FXML
    private Label assistsLabel;

    @FXML
    private Label blocksLabel;

    @FXML
    private BorderPane borderPane;

    @FXML
    private ImageView courtImage;

    @FXML
    private Label defensiveReboundLabel;

    @FXML
    private Label freeThrowsLabel;

    @FXML
    private Button made2Shot;

    @FXML
    private Button missed2Shot;

    @FXML
    private Label offensiveReboundLabel;

    @FXML
    private ComboBox<String> quarterComboBox;

    @FXML
    private Label stealsLabel;

    @FXML
    private Label threePointersShotLabel;

    @FXML
    private Label turnoversLabel;

    @FXML
    private Label twoPointersShotLabel;
    @FXML
    private Label foulsLabel;


    public int attempted2PointsShot;
    public int made2PointsShot;
    public int attempted3PointsShot;
    public int made3PointsShot;
    public int attemptedFreeThrows;
    public int madeFreeThrows;
    public int assists;
    public int offensiveRebound;
    public int defensiveRebound;
    public int steals;
    public int turnovers;
    public int blocks;
    public int fouls;

    public double x = 0.0;
    public double y = 0.0;

    Point basket = new Point(275, 8);

    ArrayList<Point> points;
    ArrayList<OurEvent> ourEvents;
    LinkedList<Player> players;


    @FXML
    private void initialize() {
        // Get the list of items and add new items
        quarterComboBox.getItems().addAll("1°Q","2°Q","3°Q","4°Q");
        points = new ArrayList<>();
        ourEvents = new ArrayList<OurEvent>();
        players = new LinkedList<Player>();
        resetStatistics();
        updateStatistics();

    }
    void resetStatistics(){
        attempted2PointsShot = 0;
        made2PointsShot = 0;
        attempted3PointsShot = 0;
        made3PointsShot = 0;
        attemptedFreeThrows = 0;
        madeFreeThrows = 0;
        assists = 0;
        offensiveRebound = 0;
        defensiveRebound = 0;
        steals = 0;
        turnovers = 0;
        blocks = 0;
        fouls = 0;
    }
    void updateStatistics(){
        twoPointersShotLabel.setText(String.valueOf(made2PointsShot) + "/" + String.valueOf(attempted2PointsShot));
        threePointersShotLabel.setText(String.valueOf(made3PointsShot)+ "/" +String.valueOf(attempted3PointsShot));
        freeThrowsLabel.setText(String.valueOf(madeFreeThrows)+ "/" +String.valueOf(attemptedFreeThrows));
        assistsLabel.setText(String.valueOf(assists));
        offensiveReboundLabel.setText(String.valueOf(offensiveRebound));
        defensiveReboundLabel.setText(String.valueOf(defensiveRebound));
        stealsLabel.setText(String.valueOf(steals));
        turnoversLabel.setText(String.valueOf(turnovers));
        blocksLabel.setText(String.valueOf(blocks));
        foulsLabel.setText(String.valueOf(fouls));
    }
    void modifyStatistics(String eventType, Point eventLocation){
        switch (eventType) {
            case "Made Shot" -> {
                if (calculateDistance(eventLocation, basket) < 247) {
                    made2PShot();
                } else {
                    made3PShot();
                }
            }
            case "Missed Shot" -> {
                if (calculateDistance(eventLocation, basket) < 247) {
                    missed2PShot();
                } else {
                    missed3PShot();
                }
            }
            case "Made FreeThrows" -> madeFreeThrow();
            case "Missed FreeThrows" -> missedFreeThrow();
            case "Defensive Rebound" -> madeDefensiveRebound();
            case "Offensive Rebound" -> madeOffensiveRebound();
            case "Assist" -> madeAssist();
            case "Block" -> madeBlock();
            case "Foul" -> madeFoul();
            case "Turnover" -> madeTurnover();
            case "Steal" -> madeSteal();
        }
    }
    @FXML
    void selectQuarter(ActionEvent event) {
        String quarter = quarterComboBox.getValue().substring(0,1);
        resetStatistics();
        for(OurEvent ourEvent : ourEvents){
            if(ourEvent.getQuarter().equals(quarter)){
                String eventType = ourEvent.geteventType();
                Point eventLocation = new Point(ourEvent.getX(), ourEvent.getY());
                modifyStatistics(eventType, eventLocation);
            }
        }
        updateStatistics();
    }


    void made2PShot() {
        attempted2PointsShot++;
        made2PointsShot++;
   }


    void missed2PShot() {
        attempted2PointsShot++;
        }

    void made3PShot() {
        attempted3PointsShot++;
        made3PointsShot++;
        }


    void missed3PShot() {
        attempted3PointsShot++;
        }

    void madeFreeThrow() {
        attemptedFreeThrows++;
        madeFreeThrows++;
        }


    void missedFreeThrow() {
        attemptedFreeThrows++;
        }
    void madeAssist(){
        assists++;
    }
    void madeDefensiveRebound(){
        defensiveRebound++;
    }
    void madeOffensiveRebound(){
        offensiveRebound++;
    }
    //steals,turnovers,blocks
    void madeSteal(){
        steals++;
    }
    void madeTurnover(){
        turnovers++;
    }
    void madeBlock(){
        blocks++;
    }
    void madeFoul(){
        fouls++;
    }
    void showNoQuarterSelectedAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("No Selection");
        alert.setHeaderText("No Quarter Selected");
        alert.setContentText("Please select a quarter.");
        alert.showAndWait();
    }

    @FXML
    void handleClick(MouseEvent event) {
        if(quarterComboBox.getValue() != null) {
            x = event.getX();
            y = event.getY();

            Point point = new Point(x, y);

            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("event-edit-view.fxml"));
                DialogPane view = loader.load();
                EventEditDialogController controller = loader.getController();

                // Set the person into the controller.
                //int selectedIndex = selectedIndex();
                //controller.setPerson(new Person(personTable.getItems().get(selectedIndex)));

                // Create the dialog
                Dialog<ButtonType> dialog = new Dialog<>();
                dialog.setTitle("Edit Event");
                dialog.initModality(Modality.WINDOW_MODAL);
                dialog.setDialogPane(view);

                // Show the dialog and wait until the user closes it
                Optional<ButtonType> clickedButton = dialog.showAndWait();
                if (clickedButton.orElse(ButtonType.CANCEL) == ButtonType.OK) {
                    String eventType = controller.getStringFromSelectedButton();
                    String quarter = quarterComboBox.getValue();
                    String whoDidIt = controller.getStringFromTextField();
                    Point eventLocation = new Point(x, y);
                    OurEvent ourEvent = new OurEvent(eventType, whoDidIt, quarter.substring(0, 1), x, y);
                /*System.out.println("Premuto il bottone ok");
                System.out.println(controller.getStringFromTextField());
                System.out.println(controller.getStringFromSelectedButton());*/
                    ourEvents.add(ourEvent);
                    for (OurEvent o : ourEvents) {
                        System.out.print(o + " ;");
                    }
                    System.out.println();
                    modifyStatistics(eventType, eventLocation);
                    //Player mattia = new Player("Mattia","Montanari",12);
                    //players.add(mattia);
                    for (Player player : players) {
                        if (player.getPlayerNumber().equals(Integer.valueOf(ourEvent.getWhoDidIt()))) {
                            switch (eventType) {
                                case "Made Shot" -> {
                                    if (calculateDistance(eventLocation, basket) < 247) {
                                        player.setAttemptedTwoPointers(player.getAttemptedTwoPointers() + 1);
                                        player.setMadeTwoPointers(player.getMadeTwoPointers() + 1);
                                    } else {
                                        player.setAttemptedThreePointers(player.getAttemptedThreePointers() + 1);
                                        player.setMadeThreePointers(player.getMadeThreePointers() + 1);
                                    }
                                }
                                case "Missed Shot" -> {
                                    if (calculateDistance(eventLocation, basket) < 247) {
                                        player.setAttemptedTwoPointers(player.getAttemptedTwoPointers() + 1);
                                    } else {
                                        player.setAttemptedThreePointers(player.getAttemptedThreePointers() + 1);
                                    }
                                }
                                case "Made FreeThrows" -> {
                                    player.setAttemptedFreeThrows(player.getAttemptedFreeThrows() + 1);
                                    player.setMadeFreeThrows(player.getMadeFreeThrows() + 1);
                                }
                                case "Missed FreeThrows" -> player.setAttemptedFreeThrows(player.getAttemptedFreeThrows() + 1);
                                case "Defensive Rebound" -> player.setDefensiveRebounds(player.getDefensiveRebounds() + 1);
                                case "Offensive Rebound" -> player.setOffensiveRebounds(player.getOffensiveRebounds() + 1);
                                case "Assist" -> player.setAssists(player.getAssists() + 1);
                                case "Block" -> player.setBlocks(player.getBlocks() + 1);
                                case "Foul" -> player.setFouls(player.getFouls() + 1);
                                case "Turnover" -> player.setTurnOver(player.getTurnOver() + 1);
                                case "Steal" -> player.setSteals(player.getSteals() + 1);
                            }
                            //System.out.println(player.toString());
                        }
                    }
                    updateStatistics();

                }
            } catch (NoSuchElementException e) {
                //showNoQuarterSelectedAlert();
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        /*
        if(calculateDistance(point,basket) < 247){
            made2PShot();
            updateStatistics();
        }
        */
            points.add(point);
            System.out.println("Mouse clicked at: (" + x + ", " + y + ")");
            System.out.print(points.size() + ". ");
            for (Point p : points) {
                System.out.print(p + ", ");
            }
            System.out.println();
            if (points.size() >= 5) {
                double[] semicircleParams = calculateSemicircle(points);

                double radius = semicircleParams[0];
                double centerX = semicircleParams[1];
                double centerY = semicircleParams[2];

                System.out.println("Semicircle parameters:");
                System.out.println("Radius: " + radius);
                System.out.println("Center X: " + centerX);
                System.out.println("Center Y: " + centerY);
            }
        }
    }


    @FXML
    void handleNewGame(ActionEvent event) {
        points = new ArrayList<>();
        ourEvents = new ArrayList<OurEvent>();
        players = new LinkedList<Player>();
        resetStatistics();
        updateStatistics();
    }

    @FXML
    void handleNewTeam(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("team-insertion-view.fxml"));
            DialogPane view = loader.load();
            TeamInsertionDialogController controller = loader.getController();

            // Set the person into the controller.
            //int selectedIndex = selectedIndex();
            //controller.setPerson(new Person(personTable.getItems().get(selectedIndex)));

            // Create the dialog
            Dialog<ButtonType> dialog = new Dialog<>();
            dialog.setTitle("Team Insertion");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.setDialogPane(view);

            // Show the dialog and wait until the user closes it
            Optional<ButtonType> clickedButton = dialog.showAndWait();
            if (clickedButton.orElse(ButtonType.CANCEL) == ButtonType.FINISH){
                players = controller.getListOfPlayers();
                System.out.println(players);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleOpenGame(ActionEvent event) {

    }

    @FXML
    void handleOpenTeam(ActionEvent event) {

    }


    @FXML
    private void handleSaveGameAsJson(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter jsonFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
            fileChooser.getExtensionFilters().add(jsonFilter);

            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, ourEvents);
            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not save data in json").showAndWait();
        }
    }


    @FXML
    void handleSaveGameAsCsv(ActionEvent event) {

    }

    @FXML
    void handleSaveTeamAsJson(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter jsonFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
            fileChooser.getExtensionFilters().add(jsonFilter);

            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                mapper.writerWithDefaultPrettyPrinter().writeValue(file, players);
            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not save data in json").showAndWait();
        }
    }






    public static double[] calculateSemicircle(ArrayList<Point> points) {
        if (points.size() < 2) {
            throw new IllegalArgumentException("At least two points are required.");
        }

        // Extract the x and y coordinates of the points
        double[] xValues = new double[points.size()];
        double[] yValues = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            Point point = points.get(i);
            xValues[i] = point.getX();
            yValues[i] = point.getY();
        }

        // Fit a semicircle to the points
        double[] semicircleParams = fitSemicircle(xValues, yValues);

        return semicircleParams;
    }

    private static double[] fitSemicircle(double[] x, double[] y) {
        // Calculate the centroid of the points
        double sumX = 0.0;
        double sumY = 0.0;
        for (int i = 0; i < x.length; i++) {
            sumX += x[i];
            sumY += y[i];
        }
        double centerX = sumX / x.length;
        double centerY = sumY / y.length;

        // Calculate the radius as the average distance from the centroid
        double sumDistances = 0.0;
        for (int i = 0; i < x.length; i++) {
            double dx = x[i] - centerX;
            double dy = y[i] - centerY;
            double distance = Math.sqrt(dx * dx + dy * dy);
            sumDistances += distance;
        }
        double radius = sumDistances / x.length;

        return new double[]{radius, centerX, centerY};
    }

    public static double calculateDistance(Point p1, Point p2) {
        double dx = p2.getX() - p1.getX();
        double dy = p2.getY() - p1.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

}