package Controller;

import Controller.StudentUserController;
import Controller.TeacherUser2Controller;
import Model.LoginModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public LoginModel loginModel = new LoginModel();

    @FXML
    private Label isConnected;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private ComboBox<String> comboBox;
    //@FXML
    //public ListView<String> listView;
    ObservableList<String> list = FXCollections.observableArrayList("student","teacher");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBox.setItems(list);

      //  if (loginModel.isDbConnected() && loginModel.isDbConnectedStud()){
   //         isConnected.setText("Connected");
    //    } else{
    //        isConnected.setText("Not Connected");
      //  }
    }
    //define a method that check the username and password
    public void Login(ActionEvent event){
        try {
            if(comboBox.getValue().equals("teacher")){
                if (loginModel.isLoginTeacher(txtUsername.getText(),txtPassword.getText())){
                    isConnected.setText("username and password is correct");
                    ((Node)event.getSource()).getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    Stage primaryStage= new Stage();
                    //writeToFileID(txt)
                    Pane root = loader.load(getClass().getResource("../View/TeacherUser2.fxml").openStream());
                    TeacherUser2Controller teacherUserController = (TeacherUser2Controller)loader.getController();
                    teacherUserController.getUser(txtUsername.getText());

                    Scene scene = new Scene(root);
                    primaryStage.setScene(scene);
                    primaryStage.show();
                }
            } else{
                if(comboBox.getValue().equals("student")){
                    System.out.println("bhdcu");
                    if (loginModel.isLoginStudent(txtUsername.getText(),txtPassword.getText())){
                       System.out.println("student");
                        isConnected.setText("username and password is correct");
                        ((Node)event.getSource()).getScene().getWindow().hide();
                        FXMLLoader loader = new FXMLLoader();
                        Stage primaryStage= new Stage();
                        Pane root = loader.load(getClass().getResource("../View/StudentUser.fxml").openStream());
                        StudentUserController studentUserController = (StudentUserController)loader.getController();
                        studentUserController.getUser(txtUsername.getText());
                        Scene scene = new Scene(root);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    }
                }
            else{
                isConnected.setText("username and password wrong");
            }
            }
        } catch (SQLException e) {
            isConnected.setText("username and password wrong");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void newUser(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            Stage primaryStage = new Stage();
            Pane root = loader.load(getClass().getResource("../View/RegisterForm.fxml").openStream());
           // TeacherUser2Controller teacherUserController = (TeacherUser2Controller) loader.getController();
           // teacherUserController.getUser(txtUsername.getText());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e) {
                e.printStackTrace();
            }
        }
}
