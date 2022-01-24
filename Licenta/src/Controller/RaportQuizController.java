package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;

public class RaportQuizController implements Initializable {
    @FXML
    private BarChart<?, ?> chart;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    public ObservableList<Integer> values = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void initLista(ObservableList<Integer> val){
        values=val;
        XYChart.Series series = new XYChart.Series();

        series.getData().add(new XYChart.Data("data1",values.get(0)));
        series.getData().add(new XYChart.Data("data2",values.get(1)));
        series.getData().add(new XYChart.Data("data3",values.get(2)));
      //  series.getData().add(new XYChart.Data("lab4",values.get(3)));
     //   series.getData().add(new XYChart.Data("lab5",values.get(4)));
     //   series.getData().add(new XYChart.Data("lab6",values.get(5)));

        chart.getData().addAll(series);
    }
}
