module com.example.calc2 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;
    requires java.net.http;
    requires json.simple;

    opens com.example.calc2 to javafx.fxml;
    exports com.example.calc2;
    exports com.example.calc2.controller;
    opens com.example.calc2.controller to javafx.fxml;
}