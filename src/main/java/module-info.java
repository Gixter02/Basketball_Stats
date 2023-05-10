module com.example.basketball_stats {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.basketball_stats to javafx.fxml;
    exports com.example.basketball_stats;
}