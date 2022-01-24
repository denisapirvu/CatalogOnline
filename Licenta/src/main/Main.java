package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import FXML.*;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        //String data = readFromFile();
        //System.out.println(generateID("INR"));
        //System.out.println("vbfkjd");
       // System.out.println(data.charAt(0));
        try{
            //here we create and open a scene ( kind of a new window)
            Parent root = FXMLLoader.load(getClass().getResource("../View/Login.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
            //scene.getStylesheets().add(getClass().getResource())
        } catch(Exception e){
            e.printStackTrace();
        }

    }
    public static void main(String[] args){
        launch(args);
       // String data = readFromFile();
        //System.out.println("kjbdkbs");
       // System.out.println(data);
    }
}
