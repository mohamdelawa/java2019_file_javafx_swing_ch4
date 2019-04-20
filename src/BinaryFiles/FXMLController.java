
package BinaryFiles;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;



public class FXMLController implements Initializable {
    @FXML
    private Label Path;
    @FXML
    private Label Status;

    private File file;
    private String FileParent;
    private String FileName;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }

    @FXML
    public void Select() {
        System.out.println("Select");
        try {
            FileChooser chooser = new FileChooser();
            FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
            chooser.getExtensionFilters().add(extFilter);
            file = chooser.showOpenDialog(null);
            
            System.out.println(file.getParent());
            FileParent = file.getParent();
            
            Path.setText(file.getPath());
            
            System.out.println(file.getName().length());
            FileName = file.getName().substring(0, file.getName().length() - 4);
                       
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    public void Convert() {
        System.out.println("Convert");
        if (file != null) {
            Status.setText("Success!!!");
            try {
                File file2 = new File(FileParent+"\\"+FileName+".dat");
                file2.createNewFile();
                FileOutputStream fout = new FileOutputStream(file2);
                DataOutputStream dout = new DataOutputStream(fout);
                
                
                FileInputStream fis = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                while (br.ready()) {
                    dout.writeChars(br.readLine() + "\n");
                }

                dout.close();
                fout.close();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        } else {
            Status.setText("Failed!!!");
        }
    }
}
