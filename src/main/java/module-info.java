open module com.example.basketball_stats {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;

    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.datatype.jsr310;

    exports com.example.basketball_stats;
}




/*
module com.example.basketball_stats {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.basketball_stats to javafx.fxml;
    exports com.example.basketball_stats;
}
*/