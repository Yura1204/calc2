package com.example.calc2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppLauncher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppLauncher.class.getResource("app-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 440);
//        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        String css = this.getClass().getResource("/com/example/calc2/style.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setTitle("Calc");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}