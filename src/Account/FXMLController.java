
package  Account;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;



public class FXMLController implements Initializable {

    private TextField AccNo;
    private TextField AccName;
    private TextField AccBalance;
    private TextArea txst;
    //**************write****************
    private List<Account> list = new ArrayList<>();
    //**************read*****************
    private List<Account> listtemp = new ArrayList<>();
    
    private File file = new File("src/Account/users.dat");
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void Add() throws FileNotFoundException, IOException {
        System.out.println("add done !.");
        Account account = new Account(AccNo.getText(), AccName.getText(), AccBalance.getText());
        list.add(account);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
    }

    public void Show() throws FileNotFoundException, IOException, ClassNotFoundException {
       
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            listtemp = (List<Account>) ois.readObject();
             txst.setText(" ");
            for (Account acc : listtemp) {
               
                txst.appendText("AccNO : " + acc.getAccNo() + "\nAccName : " + acc.getAccName()
                        + "\nAccBalance : " + acc.getAccBalance() + "\n---------------------\n");
                 System.out.println("show");
            }
            
            sorting();
           
            
        }
    }

    //***************Sorting********************* 
    public void sorting() {
        listtemp.sort((Account o1, Account o2) -> {
            if (Double.parseDouble(o2.getAccBalance()) > Double.parseDouble(o1.getAccBalance())) {
                return 1;
            } else if (Double.parseDouble(o2.getAccBalance()) < Double.parseDouble(o1.getAccBalance())) {
                return -1;
            }
            return 0;
        });
    }

}
