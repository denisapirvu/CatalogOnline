package Controller;

import Model.*;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;



public class TeacherUser2Controller implements Initializable {

    public LoginModel loginModel = new LoginModel();
    public HelpClass helpClass = new HelpClass();
    @FXML
    private Label userLbl,idProf;
    @FXML
    private TableView<TableRecords> table;
    @FXML
    private TableColumn<TableRecords,String> id_student;
    @FXML
    private TableColumn<TableRecords,String> nume;
    @FXML
    private TableColumn<TableRecords,String> prenume,lab11,lab21,lab31,lab41,lab51,lab61;
    @FXML
    private TableColumn<TableRecords,String> grupa;
    @FXML
    private TableColumn<TableRecords, String> lab1,lab12,lab22,lab32,lab42,lab52,lab62;
    @FXML
    private TableColumn<TableRecords, String> lab2;
    @FXML
    private TableColumn<TableRecords, String> lab3;
    @FXML
    private TableColumn<TableRecords, String> lab4;
    @FXML
    private TableColumn<TableRecords, String> lab5;
    @FXML
    private TableColumn<TableRecords, String> lab6,id_inregistrare;
    @FXML
    private TextField txtIDStudent;
    @FXML
    private TextField txtNume;
    @FXML
    private TextField txtPrenume;
    @FXML
    private TextField txtNotaLaborator,txtIDInregistrare;
    @FXML
    private RadioButton prezent;
    @FXML
    private RadioButton absent;
    @FXML
    private Pane pnl_materie, pnl_view, pnl,panel;

    @FXML
    private JFXButton btn_materie, btn_view, btn, grupa2;
    @FXML
    private TextField searchField;
    @FXML
    private TextField textMaterie1;
    @FXML
    private Button update, search, emptyFields, label,but1;
    @FXML
    private HBox hbox;
    @FXML
    private ComboBox<String> combo, comboMaterie1,comboMaterie2,comboMaterie;


    @FXML
    private ComboBox<String> comboGrupa;

    @FXML
    private ComboBox<String> comboTipRaport;
    @FXML
    private ComboBox<String> comboPolMaterie;

    @FXML
    private ComboBox<String> comboPolGrupa;

    @FXML
    private TextField data1;

    @FXML
    private TextField data2;

    @FXML
    private TextField data3;

    ObservableList<String> lista = FXCollections.observableArrayList("Laborator 1","Laborator 2","Laborator 3","Laborator 4","Laborator 5","Laborator 6");

    public Integer nrLab=0;
    public ObservableList<Inregistrare> listInregistrari = FXCollections.observableArrayList();
    public ObservableList<StudentFinal> listStudenti = FXCollections.observableArrayList();
    public ObservableList<Teacher> listProfesori = FXCollections.observableArrayList();
    public ObservableList<TableRecords> listTable = FXCollections.observableArrayList();
    public ObservableList<Materie> listMaterii = FXCollections.observableArrayList();
    public ObservableList<String> list = FXCollections.observableArrayList();
    public ObservableList<TableRecords> data = FXCollections.observableArrayList();
    public ObservableList<String> mat = FXCollections.observableArrayList();
    public ObservableList<Grupa> listGrupe = FXCollections.observableArrayList();
    public ObservableList<Quiz> quiz = FXCollections.observableArrayList();

    public String grupaValue;
    private ObservableList<Button> listButtons = FXCollections.observableArrayList();
    Preferences userPreferences = Preferences.userRoot();

    public void getGrupeByIdProf() {
        String value = comboPolMaterie.getValue();
        int size = listGrupe.size();
        list.remove(list);
        for (int i = 0; i < size; i++) {
            if ((listGrupe.get(i).getMaterie1() != null && listGrupe.get(i).getMaterie1().equals(value)) || (listGrupe.get(i).getMaterie2() != null && listGrupe.get(i).getMaterie2().equals(value)) || (listGrupe.get(i).getMaterie3() != null && listGrupe.get(i).getMaterie3().equals(value)) || (listGrupe.get(i).getMaterie4() != null && listGrupe.get(i).getMaterie4().equals(value)) || (listGrupe.get(i).getMaterie5() != null && listGrupe.get(i).getMaterie5().equals(value)) || (listGrupe.get(i).getMaterie6() != null && listGrupe.get(i).getMaterie6().equals(value)) || (listGrupe.get(i).getMaterie7() != null && listGrupe.get(i).getMaterie7().equals(value)) || (listGrupe.get(i).getMaterie8() != null && listGrupe.get(i).getMaterie8().equals(value)) || (listGrupe.get(i).getMaterie9() != null && listGrupe.get(i).getMaterie9().equals(value)) || (listGrupe.get(i).getMaterie10() != null && listGrupe.get(i).getMaterie10().equals(value))) {
                list.add(listGrupe.get(i).getNrGrupa());
            }
        }
        comboGrupa.setItems(list);
        comboPolGrupa.setItems(list);
    }
    public Inregistrare cautaInregistrare2(String idStud)
    {
        String materie = comboMaterie.getValue();
        int size=listInregistrari.size();
         for(int i=0;i<size;i++)
        {
            if(listInregistrari.get(i).getId_materie().equals(materie) && listInregistrari.get(i).getId_student().equals(idStud))
            {//inregistrarea exista
                //System.out.println(listInregistrari.get(i).getLaborator6());
                return listInregistrari.get(i);
            }
        }
        Inregistrare inr = new Inregistrare("","","","","","","","","","","","","","","","");
        return inr;
    }
    public void valMediePeLab(){
        listaDeStudenti();
        listaDeInregistrari();
        ObservableList<Float> valori =FXCollections.observableArrayList(); //media pe fiecare lab
        String gr = comboMaterie.getValue();
        String gru = comboGrupa.getValue();
        int size = listInregistrari.size();
        int sizeS = listStudenti.size();
        float s1=0,s2=0,s3=0,s4=0,s5=0,s6=0;
        float nr1=0,nr2=0,nr3=0,nr4=0,nr5=0,nr6=0;
         for(int i=0;i<sizeS;i++)
        {
            if(listStudenti.get(i).getGrupa().equals(gru)){
                Inregistrare inr = cautaInregistrare2(listStudenti.get(i).getId_student());
                  if(inr.getLaborator1()!="") {
                    s1 += Float.parseFloat(inr.getLaborator1());
                    nr1++;
                }
                if(inr.getLaborator2()!="") {
                    s2 += Float.parseFloat(inr.getLaborator2());
                    nr2++;
                }
                if(inr.getLaborator3()!="") {
                    s3 += Float.parseFloat(inr.getLaborator3());
                    nr3++;
                }
                if(inr.getLaborator4()!="") {
                    s4 += Float.parseFloat(inr.getLaborator4());
                    nr4++;
                }
                if(inr.getLaborator5()!="") {
                    s5 += Float.parseFloat(inr.getLaborator5());
                    nr5++;
                }
                if(inr.getLaborator6()!="") {
                    s6 += Float.parseFloat(inr.getLaborator6());
                    nr6++;
                }
             //  nr++;
            }

        }
        valori.add(s1/nr1);
        valori.add(s2/nr2);
        valori.add(s3/nr3);
        valori.add(s4/nr4);
        valori.add(s5/nr5);
        valori.add(s6/nr6);
        System.out.println("valori"+valori);

        try {
            FXMLLoader loader = new FXMLLoader();
            Stage primaryStage= new Stage();
            //writeToFileID(txt)
            Pane root = null;
            root = loader.load(getClass().getResource("../View/RaportPeGrupa.fxml").openStream());
            RaportPeGrupaController rapController = (RaportPeGrupaController)loader.getController();
            rapController.initLista(valori);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void trimiteQuiz(ActionEvent event){
        String materie = comboPolMaterie.getValue();
        String grupa = comboPolGrupa.getValue();
        String dat1 = data1.getText();
        String dat2 = data2.getText();
        String dat3 = data3.getText();

        helpClass.insertQuiz(materie,grupa,dat1,dat2,dat3);
        System.out.println(materie + " "+ grupa+" "+dat1+" "+dat2+" "+dat3);
    }
    public void GenerareRaport(ActionEvent event)
    {

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //userPreferences.put(key,value);
        final ObservableList<TableRecords> tableStudSel = table.getSelectionModel().getSelectedItems();
        listStudenti = helpClass.getListStudent();
        listProfesori=helpClass.getListTeachers();
        listGrupe=helpClass.getListGrupe();
        //listMaterii = helpClass.getListMaterii(idProf.getText());

       // listaDeInregistrari();
        ///listaDeStudenti();
        listaDeMaterii();
       // listaDeGrupe();
       tableStudSel.addListener(selectStudent);
        //getUser(user);
        combo.setItems(lista);
      // Search(userLbl.getText());
        //handleButtons();
    }
   // public void getTeacherID(String name, String )
    public void grupe(ActionEvent event){
        String value = comboMaterie2.getValue();
       // listGrupe=helpClass.getListGrupe();
       // listaDeGrupe();
        int size = listGrupe.size();
        System.out.println(size);
        hbox.getChildren().removeAll(listButtons);
        listButtons.removeAll(listButtons);
        int sizea=listButtons.size();
        System.out.println(sizea);
       // size--;
       // int nr=1;
       for(int i=0;i<size;i++){
            System.out.println(listGrupe.get(i).getMaterie1());
            if((listGrupe.get(i).getMaterie1() != null && listGrupe.get(i).getMaterie1().equals(value) ) || (listGrupe.get(i).getMaterie2() != null &&listGrupe.get(i).getMaterie2().equals(value)) || (listGrupe.get(i).getMaterie3() != null && listGrupe.get(i).getMaterie3().equals(value))){// || listGrupe.get(size).getMaterie4().equals(value) || listGrupe.get(size).getMaterie5().equals(value) || listGrupe.get(size).getMaterie6().equals(value) || listGrupe.get(size).getMaterie7().equals(value) || listGrupe.get(size).getMaterie8().equals(value) || listGrupe.get(size).getMaterie9().equals(value) || listGrupe.get(size).getMaterie10().equals(value)){
                Button bt = new Button(listGrupe.get(i).getNrGrupa());
                bt.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event){
                        updateTable(bt.getText());
                        Search(bt.getText());
                        panel.toFront();
                       // System.out.println(bt.getText());
                        userLbl.setText(bt.getText());
                        //handleGrupaAction();
                    }

                });
                listButtons.add(bt);
                hbox.getChildren().add(bt);
                //nr++;
                //bt.setVisible(true);
            }
           // size--;
        }
    }

    public void listaDeMaterii(){

        listMaterii.removeAll(listMaterii);
        mat.removeAll(mat);
        listMaterii=helpClass.getListMaterii(idProf.getText());
        int size = listMaterii.size();
        for(int i=0;i<size;i++) {
            mat.add(listMaterii.get(i).getNume_materie());
           // comboMaterie.setValue(listMaterii.get(i).getNume_materie());
        }
       // System.out.println(mat);
       comboMaterie.setItems(mat);
       // System.out.println(mat);
        comboMaterie2.setItems(mat);
        comboPolMaterie.setItems(mat);

    }
    public void MaterieNoua(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            Stage primaryStage = new Stage();
            Pane root = loader.load(getClass().getResource("../View/MaterieForm.fxml").openStream());
            // TeacherUser2Controller teacherUserController = (TeacherUser2Controller) loader.getController();
            // teacherUserController.getUser(txtUsername.getText());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();



            // listaDeMaterii();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String cautaUser(String nume)
    {
        //listaDeProfesori();
        int size = listProfesori.size();
        while(size>0)
        {
           // System.out.println("ggg");
            size--;
            if(listProfesori.get(size).getUsername().equals(nume)){
                return listProfesori.get(size).getId_teacher();
            }
        }
        return "";
    }
    public void getUser(String user){
        //System.out.println("fff");
        String id = cautaUser(user);
        idProf.setText(id);
        listMaterii = helpClass.getListMaterii(idProf.getText());
       // comboMaterie2.setItems(listMaterii);
        //System.out.println(id);
        listaDeMaterii();
        getGrupeByIdProf();

    }
    public void SignOut(ActionEvent event){
        //sign out the user and opens the last windows that was accessed
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Stage primaryStage = new Stage();
            Pane root = loader.load(getClass().getResource("../sample/Login.fxml").openStream());

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(Exception e){

        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource() == btn_materie){
            pnl_materie.toFront();
        } else
            if(event.getSource() == btn_view){
                pnl_view.toFront();
            }else
                if(event.getSource() == btn){
                pnl.toFront();
                }
    }
    @FXML
    private void newGrupa(ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader();
            Stage primaryStage = new Stage();
            Pane root = loader.load(getClass().getResource("../View/GrupaForm.fxml").openStream());
            GrupaFormController grup = (GrupaFormController) loader.getController();
            System.out.println(idProf.getText());
            grup.getID(idProf.getText());
            // TeacherUser2Controller teacherUserController = (TeacherUser2Controller) loader.getController();
            // teacherUserController.getUser(txtUsername.getText());
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private final ListChangeListener<TableRecords> selectStudent =
            new ListChangeListener<TableRecords>() {
                @Override
                public void onChanged(ListChangeListener.Change<? extends TableRecords> change) {
                    putSelectedStudent();
                }
            };
    public TableRecords getSelectedStudent(){
        if(table != null){
            List<TableRecords> tablee = table.getSelectionModel().getSelectedItems();
            if(tablee.size() == 1){
                final TableRecords selected = tablee.get(0);
                return selected;
            }
        }
        return null;
    }

    private void putSelectedStudent(){
        final TableRecords stud = getSelectedStudent();

        if(stud != null){

            //I fill the textFields with the corect dates
            txtIDStudent.setText(stud.getId_student());
            txtNume.setText(stud.getNume());
            txtPrenume.setText(stud.getPrenume());
            txtIDInregistrare.setText(stud.getId_inregistrare());
        }
    }
    public void emptyFields(){
        txtIDStudent.setText("");
        txtNume.setText("");
        txtPrenume.setText("");
        txtNotaLaborator.setText("");
        txtIDInregistrare.setText("");
        combo.setValue(null);
        Search(userLbl.getText());
    }
    public void listaDeStudenti(){

        listStudenti.removeAll(listStudenti);
        listStudenti = helpClass.getListStudent();
   }
    public void listaDeInregistrari(){
        listInregistrari.removeAll(listInregistrari);
        listInregistrari=helpClass.getListInregistrari();
    }
    public Inregistrare cautaInregistrare(String idStud)
    {
        String materie = comboMaterie2.getValue();
        int size=listInregistrari.size();
        //System.out.println(size);
        for(int i=0;i<size;i++)
        { //size--;
          //  System.out.println(idStud);
          //  System.out.println(materie + "fff "+listInregistrari.get(i).getId_materie());

            if(listInregistrari.get(i).getId_materie().equals(materie) && listInregistrari.get(i).getId_student().equals(idStud))
            {//inregistrarea exista
                System.out.println(listInregistrari.get(i).getLaborator6());
                return listInregistrari.get(i);
            }
        }
        Inregistrare inr = new Inregistrare("","","","","","","","","","","","","","","","");
        return inr;
    }
    public void updateTable(String grup){
        listTable.removeAll(listTable);
        listaDeStudenti();
        listaDeInregistrari();
        int sizeS = listStudenti.size();
        for(int i=0;i<sizeS;i++)
         {
            if(listStudenti.get(i).getGrupa().equals(grup)){
                Inregistrare inr = cautaInregistrare(listStudenti.get(i).getId_student());
                listTable.add(new TableRecords(listStudenti.get(i).getId_student(),inr.getId_inregistrare(),listStudenti.get(i).getNume(),listStudenti.get(i).getPrenume(),listStudenti.get(i).getGrupa(),inr.getLaborator1(),inr.getPrezenta1(),inr.getLaborator2(),inr.getPrezenta2(),inr.getLaborator3(),inr.getPrezenta3(),inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6()));
                System.out.println("lab6"+inr.getLaborator4());
            }

        }

        id_student.setCellValueFactory( new PropertyValueFactory<TableRecords,String>("id_student"));
        id_inregistrare.setCellValueFactory(new PropertyValueFactory<TableRecords,String>("id_inregistrare"));
        nume.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("nume"));
        prenume.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("prenume"));
        grupa.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("grupa"));
        lab12.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("laborator1"));
        lab11.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("prezenta1"));
        //lab2.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("laborator2"));
        lab22.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("laborator2"));
        lab21.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("prezenta2"));
       // lab3.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("lab3"));
        lab32.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("laborator3"));
        lab31.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("prezenta3"));
       // lab4.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("lab4"));
        lab42.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("laborator4"));
        lab41.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("prezenta4"));
       // lab5.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("lab5"));
        lab52.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("laborator5"));
        lab51.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("prezenta5"));
        //lab6.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("lab6"));
        lab62.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("laborator6"));
        lab61.setCellValueFactory(new PropertyValueFactory<TableRecords,String>("prezenta6"));

        table.setTableMenuButtonVisible(true);
        table.setItems(listTable);
    }
    @FXML
    public void Search(String grup){
        data = listTable;
        FilteredList<TableRecords> filteredData = new FilteredList<>(data, b -> true);
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(person -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if(person.getNume().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                    return true;
                } else
                    if(person.getPrenume().toLowerCase().indexOf(lowerCaseFilter)!=-1){
                        return true;
                    }
                    else
                        return false;
            });
        });
        SortedList<TableRecords> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        //data.removeAll(data);
        table.setItems(sortedData);
    }


    public void Update(ActionEvent event){
            try{
                String idValue = txtIDStudent.getText();
                String nameValue = txtNume.getText();
                String prenumeValue = txtPrenume.getText();
                String grup = userLbl.getText();
                String comboValue = combo.getValue();
                StudentFinal stud = helpClass.getStudentByID(idValue);
                if(combo.getValue() == null) {
                   // Statement stmt = connection.createStatement();
                        //vrem sa schimbam doar numele studentului

                    helpClass.updateStud(idValue,stud.getUsername(), stud.getPassword(),grup, nameValue, prenumeValue);
                    updateTable(grup);
                    Search(userLbl.getText());
                }
                else {
                    if (txtIDInregistrare.getText().equals("")) {
                        //nu a fost introdusa inreg si o introducem
                        String id_in = "";
                        // id_in=generateID("INR");
                        helpClass.updateStud(idValue,stud.getUsername(), stud.getPassword(),grup, nameValue, prenumeValue);

                        if (combo.getValue().equals("Laborator 1")) {
                            if (prezent.isSelected()) {
                              //  helpClass.updateStud(idValue, nameValue, prenumeValue, grup,stud.getUsername(), stud.getPassword());
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), notaValue.toString(), "prezent", "", "", "", "", "", "", "", "", "", "");

                            } else if (absent.isSelected()) {
                            //    helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), notaValue.toString(), "absent", "", "", "", "", "", "", "", "", "", "");

                            }
                            updateTable(userLbl.getText());
                            Search(userLbl.getText());
                        } else if (combo.getValue().equals("Laborator 2")) {
                            if (prezent.isSelected()) {
                             //   helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", notaValue.toString(), "prezent", "", "", "", "", "", "", "", "");

                            } else if (absent.isSelected()) {
                             //   helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", notaValue.toString(), "absent", "", "", "", "", "", "", "", "");

                            }
                            updateTable(userLbl.getText());
                            Search(userLbl.getText());
                        } else if (combo.getValue().equals("Laborator 3")) {
                            if (prezent.isSelected()) {
                            //    helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", "", "", notaValue.toString(), "prezent", "", "", "", "", "", "");

                            } else if (absent.isSelected()) {
                           //     helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", "", "", notaValue.toString(), "absent", "", "", "", "", "", "");

                            }
                            updateTable(userLbl.getText());
                            Search(userLbl.getText());

                        } else if (combo.getValue().equals("Laborator 4")) {
                            if (prezent.isSelected()) {
                           //     helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", "", "", "", "", notaValue.toString(), "prezent", "", "", "", "");

                            } else if (absent.isSelected()) {
                            //    helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", "", "", "", "", notaValue.toString(), "absent", "", "", "", "");

                            }
                            updateTable(userLbl.getText());
                            Search(userLbl.getText());
                        } else if (combo.getValue().equals("Laborator 5")) {
                            if (prezent.isSelected()) {
                           //     helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", "", "", "", "", "", "", notaValue.toString(), "prezent", "", "");

                            } else if (absent.isSelected()) {
                          //      helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", "", "", "", "", "", "", notaValue.toString(), "absent", "", "");
                            }
                            updateTable(userLbl.getText());
                            Search(userLbl.getText());
                        } else if (combo.getValue().equals("Laborator 6")) {
                            if (prezent.isSelected()) {
                          //      helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", "", "", "", "", "", "", "", "", notaValue.toString(), "prezent");

                            } else if (absent.isSelected()) {
                           //     helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.insertInregistrare(idValue, comboMaterie2.getValue(), idProf.getText(), "", "", "", "", "", "", "", "", "", "", notaValue.toString(), "absent");

                            }
                            updateTable(userLbl.getText());
                            Search(userLbl.getText());
                        }
                    } else {
                        //inregistrarea exista si doar o vom updata
                        String idInr = txtIDInregistrare.getText();
                        Inregistrare inr = helpClass.getInregistrareByID(idInr);
                       // helpClass.updateStud(idValue, nameValue, prenumeValue, stud.getUsername(), stud.getPassword(), grup);
                        helpClass.updateStud(idValue,stud.getUsername(), stud.getPassword(), grup,nameValue, prenumeValue);

                        if (combo.getValue().equals("Laborator 1")) {
                            if (prezent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), notaValue.toString(), "prezent", inr.getLaborator2(),inr.getPrezenta2(),inr.getLaborator3(),inr.getPrezenta3(),inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6());

                            } else if (absent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), notaValue.toString(), "absent",  inr.getLaborator2(),inr.getPrezenta2(),inr.getLaborator3(),inr.getPrezenta3(),inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6());

                            }
                        } else if (combo.getValue().equals("Laborator 2")) {
                            if (prezent.isSelected()) {

                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), notaValue.toString(), "prezent", inr.getLaborator3(), inr.getPrezenta3(), inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6());

                            } else if (absent.isSelected()) {

                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), notaValue.toString(), "absent", inr.getLaborator3(), inr.getPrezenta3(), inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6());

                            }
                        } else if (combo.getValue().equals("Laborator 3")) {
                            if (prezent.isSelected()) {

                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), inr.getLaborator2(), inr.getPrezenta2(),notaValue.toString(), "prezent", inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6());

                            } else if (absent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), inr.getLaborator2(), inr.getPrezenta2(),notaValue.toString(), "absent", inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6());

                            }

                        } else if (combo.getValue().equals("Laborator 4")) {
                            if (prezent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), inr.getLaborator2(), inr.getPrezenta2(), inr.getLaborator3(),inr.getPrezenta3(),notaValue.toString(), "prezent",inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6());

                            } else if (absent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), inr.getLaborator2(), inr.getPrezenta2(), inr.getLaborator3(),inr.getPrezenta3(),notaValue.toString(), "absent",inr.getLaborator5(),inr.getPrezenta5(),inr.getLaborator6(),inr.getPrezenta6());

                            }
                        } else if (combo.getValue().equals("Laborator 5")) {
                            if (prezent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), inr.getLaborator2(), inr.getPrezenta2(), inr.getLaborator3(),inr.getPrezenta3(),inr.getLaborator4(),inr.getPrezenta4(),notaValue.toString(), "prezent",inr.getLaborator6(),inr.getPrezenta6());

                            } else if (absent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), inr.getLaborator2(), inr.getPrezenta2(), inr.getLaborator3(),inr.getPrezenta3(),inr.getLaborator4(),inr.getPrezenta4(),notaValue.toString(), "absent",inr.getLaborator6(),inr.getPrezenta6());

                            }

                        } else if (combo.getValue().equals("Laborator 6")) {
                            if (prezent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), inr.getLaborator2(), inr.getPrezenta2(), inr.getLaborator3(),inr.getPrezenta3(),inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),notaValue.toString(), "prezent");

                            } else if (absent.isSelected()) {
                                Float notaValue = Float.parseFloat(txtNotaLaborator.getText());
                                helpClass.updateInregistrare(inr.getId_inregistrare(), idValue, inr.getId_materie(), inr.getId_profesor(), inr.getLaborator1(), inr.getPrezenta1(), inr.getLaborator2(), inr.getPrezenta2(), inr.getLaborator3(),inr.getPrezenta3(),inr.getLaborator4(),inr.getPrezenta4(),inr.getLaborator5(),inr.getPrezenta5(),notaValue.toString(), "absent");
                            }
                        }
                    }
                }
                    updateTable(userLbl.getText());
                        Search(userLbl.getText());

                emptyFields();
            }catch (Exception e){
                e.printStackTrace();
            }

    }
    public void Delete(ActionEvent event){
            try{
                String idValue = txtIDStudent.getText();
                String idInreg = txtIDInregistrare.getText();
                helpClass.deleteStud(idValue);
                helpClass.deleteInregistrare(idInreg);
                updateTable(userLbl.getText());
                Search(userLbl.getText());
               // Search(userLbl.getText());

            }catch (Exception e){
                e.printStackTrace();
            }
    }

    public void vizualizeazaRezultate(ActionEvent event){
        String materie = comboPolMaterie.getValue();
        String grupa = comboPolGrupa.getValue();
        quiz = helpClass.getListQuiz();
        Quiz qu = null;
        for(int i = 0;i<quiz.size();i++){
            if(quiz.get(i).getNume_grupa().equals(grupa) && quiz.get(i).getNume_materie().equals(materie)){
                qu=quiz.get(i);
            }
        }
        ObservableList<Integer> valori = FXCollections.observableArrayList();
        valori.add(qu.getNr1());
        valori.add(qu.getNr2());
        valori.add(qu.getNr3());

        try {
            FXMLLoader loader = new FXMLLoader();
            Stage primaryStage= new Stage();
            //writeToFileID(txt)
            Pane root = null;
            root = loader.load(getClass().getResource("../View/RaportQuiz.fxml").openStream());
            RaportQuizController rapController = (RaportQuizController) loader.getController();
            rapController.initLista(valori);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
