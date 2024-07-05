module fifa {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens goalrush to javafx.fxml;
    exports goalrush;
}
