package Controller;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {

    public static void display(String message){
        Stage window = new Stage();
        //block the rest of the events
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ErrorBox");
        window.setMinWidth(250);

        Label label= new Label();
        label.setText(message);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e->window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
     }
}
