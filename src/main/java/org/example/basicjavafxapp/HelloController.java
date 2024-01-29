package org.example.basicjavafxapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class HelloController {
    @FXML
    private ImageView imageView;
    private List<String> paths;

    public HelloController(){
        paths = new ArrayList<>();
        paths.add("src/main/resources/reuben-teo-fUZWpaUknyI-unsplash.jpg");
        paths.add("src/main/resources/b-k-HAl6CKxM3xU-unsplash.jpg");
        paths.add("src/main/resources/george-hiles-o_Y93ttoyhw-unsplash.jpg");
        paths.add("src/main/resources/george-hiles-ZHF033ykCx8-unsplash.jpg");
        paths.add("src/main/resources/luke-paris-AdTY2eti9m4-unsplash.jpg");
    }
    @FXML
    private void initialize(){
        loadImage();
    }

    @FXML
    private void loadImage() {
        try {
            String imagePath = paths.get(count);
            File file = new File(imagePath);

            if (file.exists()) {
                // Convert File to URL
                String urlString = file.toURI().toURL().toExternalForm();

                Image img = new Image(urlString);
                imageView.setImage(img);
            } else {
                System.err.println("File does not exist: " + imagePath);
            }
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private int count = 0;
    @FXML
    private Label label;

    @FXML
    protected void nextImage(){
        count = (count + 1 ) % paths.size();
        loadImage();
    }

    @FXML
    protected void previousImage(){
        count = (count - 1) % paths.size();
        loadImage();
    }

    @FXML
    protected void message(){
        label.setText("I TOLD YOU NOT TO PRESS THAT!");
        imageView.setVisible(false);
        label.setVisible(true);

    }
}