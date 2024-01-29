package org.example.basicjavafxapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.paint.Color.color;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 600, 608);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();

        scene.setFill(Color.web("#81c483"));
    }


    public static void main(String[] args) {
        launch();
    }
}