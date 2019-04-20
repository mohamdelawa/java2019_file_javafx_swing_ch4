/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Account;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

  
    @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("fxml1.fxml"));
        stage.setTitle("* Write/Read Serialized *");
        stage.setResizable(false);
        // create a scene 
        Scene scene = new Scene(root);
        // set the scene 
        stage.setScene(scene); 
        stage.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
}
