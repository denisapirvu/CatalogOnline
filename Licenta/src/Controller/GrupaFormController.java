package Controller;

import Model.Materie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class GrupaFormController implements Initializable {
    public HelpClass helpClass = new HelpClass();
    @FXML
    private TextField txtNumeGrupa;

    @FXML
    private ComboBox<String> combo1;

    @FXML
    private ComboBox<String> combo2;

    @FXML
    private ComboBox<String> combo9;

    @FXML
    private ComboBox<String> combo4;

    @FXML
    private ComboBox<String> combo8;

    @FXML
    private ComboBox<String> combo3;

    @FXML
    private ComboBox<String> combo7;

    @FXML
    private ComboBox<String> combo6;

    @FXML
    private ComboBox<String> combo10;

    @FXML
    private ComboBox<String> combo5;

    public ObservableList<Materie> listMaterii = FXCollections.observableArrayList();
    public ObservableList<String> mat = FXCollections.observableArrayList();

    public String idU;
    public void getID(String id){
        idU=id;
        listaDeMaterii();
    }
    public void listaDeMaterii() {
        System.out.println(idU);
        listMaterii=helpClass.getListMaterii(idU);
        mat.removeAll(mat);
        int size = listMaterii.size();
        for(int i=0;i<size;i++)
           {
                //listMaterii.add(new Materie(resultSet.getString("id_materie"), resultSet.getString("nume_materie"), resultSet.getString("id_prof")));
                mat.add(listMaterii.get(i).getNume_materie());
                //System.out.println(resultSet.getString("nume_materie"));
            }
            if (listMaterii.size() == 0)
                //System.out.println("adauga materie");
                AlertBox.display("Adauga materie!");
            else {
                System.out.println(listMaterii);
                combo1.setItems(mat);
                combo2.setItems(mat);
                combo2.setItems(mat);
                combo3.setItems(mat);
                combo4.setItems(mat);
                combo5.setItems(mat);
                combo6.setItems(mat);
                combo7.setItems(mat);
                combo8.setItems(mat);
                combo9.setItems(mat);
                combo10.setItems(mat);
            }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //listaDeMaterii();
    }
    @FXML
    void AdaugaGrupa(ActionEvent event) {

        String nrGrupa = txtNumeGrupa.getText();
        String materie1 = combo1.getValue();
        String materie2 = combo2.getValue();
        String materie3 = combo3.getValue();
        String materie4 = combo4.getValue();
        String materie5 = combo5.getValue();
        String materie6 = combo6.getValue();
        String materie7 = combo7.getValue();
        String materie8 = combo8.getValue();
        String materie9 = combo9.getValue();
        String materie10 = combo10.getValue();
        //String materie1 = combo1.getValue();


            helpClass.insertGrupa(nrGrupa,materie1,materie2,materie3,materie4,materie5,materie6,materie7,materie8,materie9,materie10); //values ('" + nrGrupa +"', '"+materie1+"','"+materie2+"','"+materie3+"','"+materie4+"','"+materie5+"','"+materie6+"', '"+materie7+"','"+materie8+"','"+materie9+"','"+materie10+"') ";
            AlertBox.display("Grupa adaugata cu succes!");
    }
}
