package com.example.basketball_stats;

import com.example.basketball_stats.classes.OurEvent;
import com.example.basketball_stats.classes.Player;
import com.example.basketball_stats.classes.Point;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Modality;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class HelloController {
    @FXML
    private Label pointsLabel;
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

    @FXML
    private Button Player0;

    @FXML
    private Button Player1;

    @FXML
    private Button Player10;

    @FXML
    private Button Player11;

    @FXML
    private Button Player2;

    @FXML
    private Button Player3;

    @FXML
    private Button Player4;

    @FXML
    private Button Player5;

    @FXML
    private Button Player6;

    @FXML
    private Button Player7;

    @FXML
    private Button Player8;

    @FXML
    private Button Player9;


    // For numbers on court
    @FXML
    private Canvas canvasUponCourt;
    @FXML
    private AnchorPane courtAnchorPane;
    @FXML
    private PieChart twoPointersShotPieChart = new PieChart();
    @FXML
    private PieChart threePointersShotPieChart = new PieChart();
    @FXML
    private PieChart freeThrowsPieChart = new PieChart();
    List<GraphicsContext> graphicsContextList;
    Color color;



    ObservableList<PieChart.Data> twoPointerPieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Made", 13),
                    new PieChart.Data("Missed", 25)
            );
    ObservableList<PieChart.Data> threePointerPieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Made", 13),
                    new PieChart.Data("Missed", 25)
            );
    ObservableList<PieChart.Data> freeThrowsPieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Made", 13),
                    new PieChart.Data("Missed", 25)
            );
    

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
    public int totalPoints;
    public double x = 0.0;
    public double y = 0.0;

    Point BASKET = new Point(300, 8);
    static final int RADIUS = 270;

    ArrayList<Point> points;
    ArrayList<OurEvent> ourEvents;
    LinkedList<Player> players;


    @FXML
    private void initialize() {
        // Get the list of items and add new items
        quarterComboBox.getItems().addAll("1°Q","2°Q","3°Q","4°Q");
        points = new ArrayList<>();
        ourEvents = new ArrayList<>();
        players = new LinkedList<Player>();
        resetStatistics();
        updateStatistics();

        // For numbers on court
        graphicsContextList = new ArrayList<>();

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
        totalPoints = 0;

        // For numbers on court
        GraphicsContext gc = canvasUponCourt.getGraphicsContext2D();
        gc.clearRect(0, 0, canvasUponCourt.getWidth(), canvasUponCourt.getHeight());

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
        pointsLabel.setText(String.valueOf(totalPoints));

        setChart(made2PointsShot, attempted2PointsShot, made3PointsShot, attempted3PointsShot, madeFreeThrows, attemptedFreeThrows);
    }
    void modifyStatistics(String eventType, Point eventLocation){
        switch (eventType) {
            case "Made S" -> {
                if (calculateDistance(eventLocation, BASKET) < RADIUS) {
                    made2PShot();
                } else {
                    made3PShot();
                }
            }
            case "Missed S" -> {
                if (calculateDistance(eventLocation, BASKET) < RADIUS) {
                    missed2PShot();
                } else {
                    missed3PShot();
                }
            }
            case "Made FT" -> madeFreeThrow();
            case "Missed FT" -> missedFreeThrow();
            case "Def R" -> madeDefensiveRebound();
            case "Off R" -> madeOffensiveRebound();
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
                // For numbers on court
                drawNumbersIfRequired(ourEvent);
            }
        }
        updateStatistics();
    }


    void made2PShot() {
        attempted2PointsShot++;
        made2PointsShot++;
        totalPoints += 2;
   }


    void missed2PShot() {
        attempted2PointsShot++;
        }

    void made3PShot() {
        attempted3PointsShot++;
        made3PointsShot++;
        totalPoints += 3;
        }


    void missed3PShot() {
        attempted3PointsShot++;
        }

    void madeFreeThrow() {
        attemptedFreeThrows++;
        madeFreeThrows++;
        totalPoints += 1;
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

    // For buttons on the right side
    @FXML
    void handleInsertActionClick(MouseEvent event) {
        // If quarter not inserted, alert and return
        if(quarterComboBox.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "First you have to select the quarter").showAndWait();
            return;
        }
        // If player or action not selected, alert and return
        if(whoDidIt == null || eventType == null) {
            new Alert(Alert.AlertType.ERROR, "Player or action not selected: you have to select both").showAndWait();
            return;
        }
        //If action is a 2 or 3 pointer shot but point on court is not selected, alert and return
        if((eventType.equals("Made S") || eventType.equals("Missed S")) && (point == null)) {
            new Alert(Alert.AlertType.ERROR, "You have to choose a point on court before inserting a 2P or 3P shot").showAndWait();
            return;
        }


        //If all checks have been passed
        String quarter = quarterComboBox.getValue();
        OurEvent ourEvent = new OurEvent(eventType, whoDidIt, quarter.substring(0, 1), x, y);
        ourEvents.add(ourEvent);

        modifyStatistics(eventType, point);

        for (Player player : players) {
            if (player.getPlayerNumber().equals(Integer.valueOf(ourEvent.getWhoDidIt()))) {
                switch (eventType) {
                    case "Made S" -> {
                        if (calculateDistance(point, BASKET) < RADIUS) {
                            player.setAttemptedTwoPointers(player.getAttemptedTwoPointers() + 1);
                            player.setMadeTwoPointers(player.getMadeTwoPointers() + 1);
                        } else {
                            player.setAttemptedThreePointers(player.getAttemptedThreePointers() + 1);
                            player.setMadeThreePointers(player.getMadeThreePointers() + 1);
                        }
                    }
                    case "Missed S" -> {
                        if (calculateDistance(point, BASKET) < RADIUS) {
                            player.setAttemptedTwoPointers(player.getAttemptedTwoPointers() + 1);
                        } else {
                            player.setAttemptedThreePointers(player.getAttemptedThreePointers() + 1);
                        }
                    }
                    case "Made FT" -> {
                        player.setAttemptedFreeThrows(player.getAttemptedFreeThrows() + 1);
                        player.setMadeFreeThrows(player.getMadeFreeThrows() + 1);
                    }
                    case "Missed FT" -> player.setAttemptedFreeThrows(player.getAttemptedFreeThrows() + 1);
                    case "Def R" -> player.setDefensiveRebounds(player.getDefensiveRebounds() + 1);
                    case "Off R" -> player.setOffensiveRebounds(player.getOffensiveRebounds() + 1);
                    case "Assist" -> player.setAssists(player.getAssists() + 1);
                    case "Block" -> player.setBlocks(player.getBlocks() + 1);
                    case "Foul" -> player.setFouls(player.getFouls() + 1);
                    case "Turnover" -> player.setTurnOver(player.getTurnOver() + 1);
                    case "Steal" -> player.setSteals(player.getSteals() + 1);
                }
            }
        }
        updateStatistics();

        // For numbers on court
        drawNumbersIfRequired(ourEvent);

        // Add the selected point on court to the points array
        points.add(point);

        // Stampo l'evento per debug
        System.out.println(ourEvent);


        // Una volta inserita l'azione, devo resettare whoDidIt, eventType e il punto selezionato (e le coordinate)
        whoDidIt = null;
        eventType = null;
        point = null;
        x = 0.0;
        y = 0.0;
    }

    // For buttons on the right side
    String whoDidIt;
    @FXML
    void handlePlayerButtonClicked(MouseEvent event) {
        if(quarterComboBox.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "First you have to select the quarter").showAndWait();
            return;
        }
        Button clickedButton = (Button) event.getSource();
        whoDidIt = clickedButton.getText();
    }

    // For buttons on the right side
    String eventType;
    @FXML
    void handleActionButtonClicked(MouseEvent event) {
        if(quarterComboBox.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "First you have to select the quarter").showAndWait();
            return;
        }
        Button clickedButton = (Button) event.getSource();
        eventType = clickedButton.getText();
    }

    // For buttons on the right side
    Point point;
    @FXML
    void handleClickUponCourt(MouseEvent event) {
        if(quarterComboBox.getValue() == null) {
            new Alert(Alert.AlertType.ERROR, "First you have to select the quarter").showAndWait();
            return;
        }
        x = event.getX();
        y = event.getY();

        point = new Point(x, y);

        System.out.println(point);

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
                    // Nella nuova interfaccia, questo controllo non serve
                    boolean isPresent = false;
                    for(Player player : players){
                        if(player.getPlayerNumber().equals(Integer.valueOf(whoDidIt))){
                            isPresent = true;
                        }
                    }
                    if(isPresent) {
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
                                        if (calculateDistance(eventLocation, BASKET) < RADIUS) {
                                            player.setAttemptedTwoPointers(player.getAttemptedTwoPointers() + 1);
                                            player.setMadeTwoPointers(player.getMadeTwoPointers() + 1);
                                        } else {
                                            player.setAttemptedThreePointers(player.getAttemptedThreePointers() + 1);
                                            player.setMadeThreePointers(player.getMadeThreePointers() + 1);
                                        }
                                    }
                                    case "Missed Shot" -> {
                                        if (calculateDistance(eventLocation, BASKET) < RADIUS) {
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

                        // For numbers on court
                        drawNumbersIfRequired(ourEvent);



                    }
                    else{
                        new Alert(Alert.AlertType.ERROR, "Player not in the team").showAndWait();
                    }
                }
            } catch (NoSuchElementException e) {
                //showNoQuarterSelectedAlert();
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }



        /*
        if(calculateDistance(point,BASKET) < RADIUS){
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

    void drawNumbersIfRequired(OurEvent ourEvent) {
        if(ourEvent.geteventType().equals("Made S") || ourEvent.geteventType().equals("Missed S")){
            GraphicsContext gc = canvasUponCourt.getGraphicsContext2D();
            gc.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
            if(ourEvent.geteventType().equals("Made S")) {
                color = Color.GREEN;
            }
            else if(ourEvent.geteventType().equals("Missed S")) {
                color = Color.RED;
            }
            gc.setFill(color);
            gc.fillText(ourEvent.getWhoDidIt(), ourEvent.getX(), ourEvent.getY());
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

                //Metto i players nei rispettivi bottoni
                int i=0;
                ArrayList<Button> buttons = new ArrayList<>();
                buttons.add(Player0);
                buttons.add(Player1);
                buttons.add(Player2);
                buttons.add(Player3);
                buttons.add(Player4);
                buttons.add(Player5);
                buttons.add(Player6);
                buttons.add(Player7);
                buttons.add(Player8);
                buttons.add(Player9);
                buttons.add(Player10);
                buttons.add(Player11);
                for(Player player : players) {
                    Button iButton = buttons.get(i);
                    iButton.setText(player.getPlayerNumber().toString());
                    i++;
                }



            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handleOpenGame(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                ArrayList<OurEvent> ourEventsTmp = mapper.readValue(file, new TypeReference<>() {});

                ourEvents = ourEventsTmp;
                ourEventsTmp = null;

            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not load data").showAndWait();
        }
    }

    @FXML
    void handleOpenTeam(ActionEvent event) {
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
            fileChooser.getExtensionFilters().add(extFilter);

            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.registerModule(new JavaTimeModule());
                LinkedList<Player> playersTmp = mapper.readValue(file, new TypeReference<>() {});

                players = playersTmp;
                playersTmp = null;

                System.out.println(playersTmp);
                System.out.println(players);

                //Metto i players nei rispettivi bottoni
                int i=0;
                ArrayList<Button> buttons = new ArrayList<>();
                buttons.add(Player0);
                buttons.add(Player1);
                buttons.add(Player2);
                buttons.add(Player3);
                buttons.add(Player4);
                buttons.add(Player5);
                buttons.add(Player6);
                buttons.add(Player7);
                buttons.add(Player8);
                buttons.add(Player9);
                buttons.add(Player10);
                buttons.add(Player11);
                for(Player player : players) {
                    Button iButton = buttons.get(i);
                    iButton.setText(player.getPlayerNumber().toString());
                    i++;
                }


            }
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not load data").showAndWait();
        }
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
        System.out.println("appena prima del try");
        try {
            FileChooser fileChooser = new FileChooser();
            FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
            fileChooser.getExtensionFilters().add(csvFilter);

            File file = fileChooser.showSaveDialog(null);
            if(file != null) {
                String filePath = file.getPath();
                System.out.println(filePath);

                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));

                // Write the header row
                writer.write("First Name,Last Name,Number,Fouls,DR,OR,ST,TO,AS,BLK,FT made,FT attempted,2P made,2P attempted,3P made,3P attempted,Minutes\n");

                for(Player player : players) {
                    writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", player.getFirstName(), player.getLastName(), player.getPlayerNumber().toString(), player.getFouls().toString(), player.getDefensiveRebounds().toString(), player.getOffensiveRebounds().toString(), player.getSteals().toString(), player.getTurnOver().toString(), player.getAssists().toString(), player.getBlocks().toString(), player.getMadeFreeThrows().toString(), player.getAttemptedFreeThrows().toString(), player.getMadeTwoPointers().toString(), player.getAttemptedTwoPointers().toString(), player.getMadeThreePointers().toString(), player.getAttemptedThreePointers().toString(), player.getMinutesPlayed().toString()));
                }
                // Write data rows
                //writer.write("John Doe,johndoe@example.com,1234567890\n");
                //writer.write("Jane Smith,janesmith@example.com,9876543210\n");

                // Close the writer
                writer.close();

                System.out.println("CSV file exported successfully.");
            }

        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Could not save data in csv").showAndWait();
        }
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



    void setChart(Integer twoPointerMade, Integer twoPointerAttempted,Integer threePointerMade, Integer threePointerAttempted, Integer freeThrowsMade, Integer freeThrowsAttempted) {
        PieChart.Data made = new PieChart.Data("Made", twoPointerMade);
        PieChart.Data missed = new PieChart.Data("Missed", twoPointerAttempted - twoPointerMade);

            twoPointerPieChartData.clear();
            twoPointerPieChartData =
                    FXCollections.observableArrayList(
                            made,
                            missed
                    );

            twoPointersShotPieChart.setData(twoPointerPieChartData);
            made.getNode().setStyle("-fx-pie-color: #00FF00;"); //GREEN
            missed.getNode().setStyle("-fx-pie-color: #FF0000;"); //RED


            made = new PieChart.Data("Made", threePointerMade);
            missed = new PieChart.Data("Missed", threePointerAttempted - threePointerMade);

            threePointerPieChartData.clear();
            threePointerPieChartData =
                    FXCollections.observableArrayList(
                            made,
                            missed
                    );

            threePointersShotPieChart.setData(threePointerPieChartData);
            made.getNode().setStyle("-fx-pie-color: #00FF00;"); //GREEN
            missed.getNode().setStyle("-fx-pie-color: #FF0000;"); //RED


            made = new PieChart.Data("Made", freeThrowsMade);
            missed = new PieChart.Data("Missed", freeThrowsAttempted - freeThrowsMade);

            freeThrowsPieChartData.clear();
            freeThrowsPieChartData =
                    FXCollections.observableArrayList(
                            made,
                            missed
                    );

            freeThrowsPieChart.setData(freeThrowsPieChartData);
            made.getNode().setStyle("-fx-pie-color: #00FF00;"); //GREEN
            missed.getNode().setStyle("-fx-pie-color: #FF0000;"); //RED

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