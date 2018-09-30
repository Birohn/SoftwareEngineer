package com.byron.MainLauncher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try { //Starts up the login screen as soon as the program is executed
//			Parent root= FXMLLoader.load(getClass().getResource("../Login/Login.fxml"));
//			Parent root= FXMLLoader.load(getClass().getResource("../Login/Login.fxml"))
            Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("views/Login.fxml"));
            primaryStage.setTitle("Log-in");
            primaryStage.setResizable(false);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
