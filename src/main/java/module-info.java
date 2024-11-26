module org.example.prototype {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.prototype to javafx.fxml;
    exports org.example.prototype;
}