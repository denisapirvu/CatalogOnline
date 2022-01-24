package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class MaterieFormController implements Initializable {
    public HelpClass helpClass = new HelpClass();
    @FXML
    TextField txtNumeMaterie, txtIDProfesor;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void AdaugaMaterie(ActionEvent event){
        String nume = txtNumeMaterie.getText();
        String profesor = txtIDProfesor.getText();
        helpClass.insertMaterie(nume,profesor);
    }
}
