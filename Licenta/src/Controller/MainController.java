package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private Label lbStatus;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    public void Login(ActionEvent event) throws Exception{
        //here we check if the "username" text matches our username
        if (txtUsername.getText().equals("user") && txtPassword.getText().equals("pass"))
        {
            lbStatus.setText("Login succes");
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        else {
            lbStatus.setText("Login failed");
        }
    }
}
