package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;


public class RegisterFormController implements Initializable {

    public HelpClass helpClass = new HelpClass();
    @FXML
    private TextField txtNume,txtPrenume,txtUsername,txtPassword,txtEmail,txtConfirmPass;
    @FXML
    private ComboBox comboBox;
    ObservableList<String> list = FXCollections.observableArrayList("student","teacher");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);
    }
    public void inregistrare(ActionEvent event){
        String nume = txtNume.getText();
        String prenume = txtPrenume.getText();
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        String email = txtEmail.getText();
        String confirmPass = txtConfirmPass.getText();
        //String id = generateID("PRO");
        if(password.equals(confirmPass)){
         //   System.out.println("vci");
            if(comboBox.getValue().equals("teacher"))
            helpClass.insertTeacher(username,password,nume,prenume,email);
            else
                helpClass.insertStudent(username,password,nume,prenume,email);

        }
        //ar trebui sa apara casuta cu eroare
    }
}
