/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login_MD5_hash;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Main extends Application {

    @FXML
    private TextField LoginName;
    @FXML
    private PasswordField Password;

    @FXML
    public void OK() throws IOException {
        
        FileInputStream fis = new FileInputStream("src/Login_MD5_hash/password.txt");
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);
        String user;
        while (br.ready()) {
            user = br.readLine();
            if (LoginName.getText().equals(user.substring(0, user.indexOf(" ")))
                    && getMd5(Password.getText()).equals(user.substring(user.indexOf(" ") + 1, user.length()))) {
                System.out.println("True");
                ShowOptionsPage();
                break;
            } else {
                System.out.println("false");
            }
        }
    }

    @FXML
    public void Exit() {
        System.exit(0);
    }

    private Parent root;
    private Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        ShowLoginPage();
        window.setResizable(false);
        window.show();
    }

    public void ShowLoginPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        loader.setController(this);
        root = loader.load();
        window.setScene(new Scene(root));
        window.setTitle("Login Page");
    }

    public void ShowOptionsPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OptionsPage.fxml"));
        loader.setController(this);
        root = loader.load();
        window.setScene(new Scene(root));
        window.setTitle("Options Page");
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static String getMd5(String input) {
        try {
           
            MessageDigest md = MessageDigest.getInstance("MD5");

           
            byte[] messageDigest = md.digest(input.getBytes());

            
            BigInteger no = new BigInteger(1, messageDigest);

           
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } 
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
