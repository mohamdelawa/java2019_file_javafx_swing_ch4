/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryFiles;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Abdullah SHublaq
 */
public class Main extends Application {

    

    

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        stage.setTitle("* Write/Read Serialized *");
        stage.setResizable(false);
        // create a scene 
        Scene scene = new Scene(root);
        // set the scene 
        stage.setScene(scene); 
        stage.setTitle("Convert to Binary File");
        stage.setResizable(false);
        stage.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}
