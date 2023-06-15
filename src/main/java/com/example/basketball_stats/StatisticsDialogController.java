package com.example.basketball_stats;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
public class StatisticsDialogController {



    @FXML
    private PieChart freeThrowsChart;

    @FXML
    private Label freeThrowsLabel;

    @FXML
    private PieChart threePointerChart;

    @FXML
    private Label threePointerLabel;
    @FXML
    private Label twoPointerLabel;

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
    @FXML
    private PieChart twoPointerChart = new PieChart();
    @FXML void initialize(){
        twoPointerChart.setData(twoPointerPieChartData);
        twoPointerChart.setTitle("2Pstat");
        twoPointerLabel.setText("13 / 25");
        threePointerChart.setData(threePointerPieChartData);
        threePointerChart.setTitle("3Pstat");

        freeThrowsChart.setData(freeThrowsPieChartData);
        freeThrowsChart.setTitle("FTstat");
        //selectionComboBox.getItems().addAll("1°Q","2°Q","3°Q","4°Q","First Half","Second Half","Game");
    }
    void setChart(Integer twoPointerMade, Integer twoPointerAttempted,Integer threePointerMade, Integer threePointerAttempted, Integer freeThrowsMade, Integer freeThrowsAttempted){
        twoPointerPieChartData.clear();
        twoPointerPieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Made", twoPointerMade),
                        new PieChart.Data("Missed", twoPointerAttempted - twoPointerMade)
                );
        threePointerPieChartData.clear();
        threePointerPieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Made", threePointerMade),
                        new PieChart.Data("Missed", threePointerAttempted - threePointerMade)
                );
        freeThrowsPieChartData.clear();
        freeThrowsPieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Made", freeThrowsMade),
                        new PieChart.Data("Missed", freeThrowsAttempted - freeThrowsMade)
                );

        twoPointerChart.setData(twoPointerPieChartData);
        threePointerChart.setData(threePointerPieChartData);
        freeThrowsChart.setData(freeThrowsPieChartData);

        twoPointerLabel.setText(twoPointerMade +"/"+twoPointerAttempted);
        threePointerLabel.setText(threePointerMade +"/"+threePointerAttempted);
        freeThrowsLabel.setText(freeThrowsMade +"/"+freeThrowsAttempted);
    }
    @FXML
    void handleSelection(ActionEvent event) {
        Integer twoPointerMade, twoPointerAttempted, threePointerMade, threePointerAttempted, freeThrowsMade, freeThrowsAttempted;
        String selection = "selectionComboBox.getValue()";
        switch (selection){
            case "1°Q" ->{

            }
            case "2°Q" ->{

            }
            case "3°Q" ->{

            }
            case "4°Q" ->{

            }
            case "First Half" ->{

            }
            case "Second Half" ->{

            }
            case "Game" ->{

            }
        }
        //setChart();
    }

}

