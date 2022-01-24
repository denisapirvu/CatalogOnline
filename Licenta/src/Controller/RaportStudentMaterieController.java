package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class RaportStudentMaterieController implements Initializable {

    @FXML
    private LineChart<?, ?> chart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;
    @FXML
    private Label absente;

    @FXML
    private Label prezente;

    public ObservableList<Float> values = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void initLista(ObservableList<Float> val, int abs, int prez){
        values=val;
        XYChart.Series series = new XYChart.Series();

        absente.setText(String.valueOf(abs));
        prezente.setText(String.valueOf(prez));

        series.getData().add(new XYChart.Data("lab1",values.get(0)));
        series.getData().add(new XYChart.Data("lab2",values.get(1)));
        series.getData().add(new XYChart.Data("lab3",values.get(2)));
        series.getData().add(new XYChart.Data("lab4",values.get(3)));
        series.getData().add(new XYChart.Data("lab5",values.get(4)));
        series.getData().add(new XYChart.Data("lab6",values.get(5)));

        chart.getData().addAll(series);
    }

}
