/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * @author Admin
 */

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

    public class Main extends Application {


        public static Stage rootStage;

        @Override
        public void start(Stage primaryStage) throws Exception {
            rootStage = primaryStage;
            Parent root = FXMLLoader.load(getClass().getResource("quanly.fxml"));
            primaryStage.setTitle("T2108M");
            primaryStage.setScene(new Scene(root, 800, 600));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
    }