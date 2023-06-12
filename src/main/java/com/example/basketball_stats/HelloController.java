package com.example.basketball_stats;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import java.util.ArrayList;

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

    Point basket = new Point(275, 8);

    ArrayList<Point> points = new ArrayList<>();
    //ArrayList<Ourevent> ourevents = new ArrayList<Ourevent>();


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

        Point point = new Point(x,y);

        if(calculateDistance(point,basket) < 247){
            made2PShot(new ActionEvent());
        }

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