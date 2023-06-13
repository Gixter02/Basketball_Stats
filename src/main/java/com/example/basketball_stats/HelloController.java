package com.example.basketball_stats;

import com.example.basketball_stats.classes.OurEvent;
import com.example.basketball_stats.classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;

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

    ArrayList<Point> points = new ArrayList<>();
    ArrayList<OurEvent> ourEvents = new ArrayList<OurEvent>();
    LinkedList<Player> players = new LinkedList<Player>();


    @FXML
    private void initialize() {
        // Get the list of items and add new items
        quarterComboBox.getItems().addAll("1°Q","2°Q","3°Q","4°Q");
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
    @FXML
    void selectQuarter(ActionEvent event) {
        String quarter = quarterComboBox.getValue().substring(0,1);
        resetStatistics();
        for(OurEvent ourEvent : ourEvents){
            if(ourEvent.getQuarter().equals(quarter)){
                String eventType = ourEvent.geteventType();
                Point eventLocation = new Point(ourEvent.getX(), ourEvent.getY());
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

    @FXML
    void handleClick(MouseEvent event) {
        x = event.getX();
        y = event.getY();

        Point point = new Point(x,y);

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
                OurEvent ourEvent = new OurEvent(eventType,whoDidIt,quarter.substring(0,1),x,y);
                /*System.out.println("Premuto il bottone ok");
                System.out.println(controller.getStringFromTextField());
                System.out.println(controller.getStringFromSelectedButton());*/
                ourEvents.add(ourEvent);
                for(OurEvent o : ourEvents){
                    System.out.print(o + " ;");
                }
                System.out.println();
                switch (eventType) {
                    case "Made Shot" -> {
                        if (calculateDistance(point, basket) < 247) {
                            made2PShot();
                        } else {
                            made3PShot();
                        }
                    }
                    case "Missed Shot" -> {
                        if (calculateDistance(point, basket) < 247) {
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
                updateStatistics();

            }
        } catch (NoSuchElementException e) {
            //showNoPersonSelectedAlert();
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
        for (Point p : points){
            System.out.print(p+ ", ");
        }
        System.out.println();
        if(points.size() >= 5){
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