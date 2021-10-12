package com.eleonoralion;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

        @Override
        public void start(Stage primaryStage) throws Exception{
            //Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));

            primaryStage.setTitle("Hello World");
            primaryStage.setScene(new Scene(new Group(), 300, 275));
            primaryStage.show();
        }

        public static void main(String[] args) {
            Application.launch(args);
        }
}
