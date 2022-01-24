package Controller;

import Controller.AlertBox;
import Controller.HelpClass;
import Controller.RaportStudentMaterieController;
import Model.*;
import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentUserController implements Initializable {
  //  public TeacherUserController teach = new TeacherUserController();
    public HelpClass helpClass = new HelpClass();
    public AlertBox alert = new AlertBox();
    @FXML
    private Label userLbl;
    @FXML
    private RadioButton date1,date2,date3;
    @FXML
    private ComboBox<String> comboMaterii;

    @FXML
    private JFXButton materii;

    @FXML
    private JFXButton rapoarte;

    @FXML
    private JFXButton date;

    @FXML
    private Pane pnl_date;

    @FXML
    private Pane pnl_rapoarte;

    @FXML
    private Pane pnl_materii, pnl_quiz;
    @FXML
    private TextField grupa;

    @FXML
    private TableView<TableRecordsForStudents> table;
    @FXML
    private TableColumn<TableRecordsForStudents, String> numeMaterie;

    @FXML
    private TableColumn<TableRecordsForStudents, String> tip;

    @FXML
    private TableColumn<TableRecordsForStudents, String> numeProfesor;

    @FXML
    private TableColumn<TableRecordsForStudents, String> emailProfesor;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab11;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab12;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab21;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab22;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab31;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab32;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab41;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab42;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab51;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab52;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab61;

    @FXML
    private TableColumn<TableRecordsForStudents, String> lab62;

    @FXML
    private TextField parolaNoua;

    @FXML
    private TextField parolaVeche;
    @FXML
    private TextField txtGrupa;

    @FXML
    private ComboBox<String> comboMat;

    @FXML
    private ComboBox<String> combo;
    ObservableList<String> list = FXCollections.observableArrayList("student","teacher","admin");
    public ObservableList<Inregistrare> listInregistrari = FXCollections.observableArrayList();
    public ObservableList<StudentFinal> listStudenti = FXCollections.observableArrayList();
    public ObservableList<Teacher> listProfesori = FXCollections.observableArrayList();
    public ObservableList<TableRecordsForStudents> listTable = FXCollections.observableArrayList();
    public ObservableList<Materie> listMaterii = FXCollections.observableArrayList();
    public ObservableList<Grupa> listGrupe = FXCollections.observableArrayList();

    public ObservableList<Quiz> quiz = FXCollections.observableArrayList();
    //public ObservableList<TableRecords> data = FXCollections.observableArrayList();
    public ObservableList<String> mat = FXCollections.observableArrayList();
    public Quiz qu;
   // public ObservableList<Grupa> listGrupe = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listInregistrari = helpClass.getListInregistrari();

    }

    @FXML
    private void handleButtonAction(ActionEvent event){
        if(event.getSource() == materii){
            pnl_materii.toFront();
        } else
        if(event.getSource() == rapoarte){
            pnl_rapoarte.toFront();
        }else
        if(event.getSource() == date){
            pnl_date.toFront();
            pnl_quiz.setVisible(false);
        }
    }
    public void getIDUser(String nume){
        int size= listStudenti.size();
        for(int i=0;i<size;i++){
            if(listStudenti.get(i).getUsername().equals(nume)){
                userLbl.setText(listStudenti.get(i).getId_student());
            }
        }
    }

    public void getUser(String user){
        listStudenti=helpClass.getListStudent();
        getIDUser(user);
        updateTable();
        getMaterii();
    }

        public void SignOut(ActionEvent event){
        //sign out the user and opens the last windows that was accessed
        try {
            ((Node) event.getSource()).getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            Stage primaryStage = new Stage();
            Pane root = loader.load(getClass().getResource("Login.fxml").openStream());

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(Exception e){

        }
    }

    public void updateTable(){
        listTable.removeAll(listTable);
        listProfesori=helpClass.getListTeachers();

        System.out.println("Update table");
        int sizeS = listInregistrari.size();

        for(int i=0;i<sizeS;i++)
        {
            System.out.println(sizeS);
            System.out.println();
            if(listInregistrari.get(i).getId_student().equals(userLbl.getText())){
                Teacher teach = helpClass.getTeacherByID(listInregistrari.get(i).getId_profesor());
                listTable.add(new TableRecordsForStudents(listInregistrari.get(i).getId_materie(),"laborator",teach.getName()+" "+teach.getSurname(),teach.getEmail(),listInregistrari.get(i).getLaborator1(),listInregistrari.get(i).getPrezenta1(),listInregistrari.get(i).getLaborator2(),listInregistrari.get(i).getPrezenta2(),listInregistrari.get(i).getLaborator3(),listInregistrari.get(i).getPrezenta3(),listInregistrari.get(i).getLaborator4(),listInregistrari.get(i).getPrezenta4(),listInregistrari.get(i).getLaborator5(),listInregistrari.get(i).getPrezenta5(),listInregistrari.get(i).getLaborator6(),listInregistrari.get(i).getPrezenta6()));
                System.out.println("inr");
            }

        }

        numeMaterie.setCellValueFactory( new PropertyValueFactory<TableRecordsForStudents,String>("numeMaterie"));
        tip.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents,String>("tipActivitate"));
        numeProfesor.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("numeProfesor"));
        numeMaterie.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("numeMaterie"));
        emailProfesor.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("email"));
        lab12.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("laborator1"));
        lab11.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("prezenta1"));
        //lab2.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("laborator2"));
        lab22.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("laborator2"));
        lab21.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("prezenta2"));
        // lab3.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("lab3"));
        lab32.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("laborator3"));
        lab31.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("prezenta3"));
        // lab4.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("lab4"));
        lab42.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("laborator4"));
        lab41.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("prezenta4"));
        // lab5.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("lab5"));
        lab52.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("laborator5"));
        lab51.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("prezenta5"));
        //lab6.setCellValueFactory(new PropertyValueFactory<TableRecords, String>("lab6"));
        lab62.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents, String>("laborator6"));
        lab61.setCellValueFactory(new PropertyValueFactory<TableRecordsForStudents,String>("prezenta6"));

        table.setTableMenuButtonVisible(true);
        table.setItems(listTable);
    }
    public void schimbareParola()
    {
        String parolaV=parolaVeche.getText();
        String parolaN=parolaNoua.getText();
        int size=listStudenti.size();
        StudentFinal stud =  helpClass.getStudentByID(userLbl.getText());
        if(parolaV.equals(stud.getPassword()))
             helpClass.updateStud(userLbl.getText(),stud.getUsername(),parolaN,stud.getGrupa(),stud.getNume(),stud.getPrenume());

        System.out.println(userLbl.getText());
    }
    public void getMaterii()
    {
        String value = grupa.getText();
        listMaterii = helpClass.getMaterii();
        for(int i = 0;i<listMaterii.size();i++){
            mat.add(listMaterii.get(i).getNume_materie());
        }
        comboMaterii.setItems(mat);
        comboMat.setItems(mat);
    }
    public void date(ActionEvent event){
        String value = grupa.getText();
        String mate = comboMaterii.getValue();

        quiz = helpClass.getListQuiz();

        int ok=0;
        for(int i=0;i<quiz.size();i++)
        {
            if(quiz.get(i).nume_grupa.equals(value) && quiz.get(i).nume_materie.equals(mate)){
                date1.setText(quiz.get(i).data1);
                date2.setText(quiz.get(i).data2);
                date3.setText(quiz.get(i).data3);
                ok=1;
                qu=quiz.get(i);
            }
        }
        if(ok==0)
            alert.display("Nu a fost stabilita o data de examen");
        else
        {
            pnl_quiz.setVisible(true);
            pnl_quiz.toFront();}
    }
    public void trimite(ActionEvent event){
        int ok1=0,ok2=0,ok3=0;
        if(date1.isSelected())
            ok1=1;
        if(date2.isSelected())
            ok2=1;
        if (date3.isSelected())
            ok3=1;
        ok1+=qu.getNr1();
        ok2+=qu.getNr2();
        ok3+=qu.getNr3();
      //  if (ok1==1)
            helpClass.updateQuiz(qu.getId_quiz(),qu.getNume_materie(),qu.getNume_grupa(),qu.getData1(),qu.getData2(),qu.getData3(),ok1,ok2,ok3);
        alert.display("Optiune trimisa cu succes!");
    }
    public void deschideRaportMaterie()
    {
        ObservableList<Float> valori =FXCollections.observableArrayList(); //nota de la fiecare lab
        //ObservableList<String> val =FXCollections.observableArrayList();
        listInregistrari= helpClass.getListInregistrari();
        //helpClass.getInregistrareByID()
       // listGrupe = helpClass.getListGrupe();
        String val=comboMat.getValue();
        System.out.println(userLbl.getText());
        int prez=0,abs=0;
        for(int i=0;i<listInregistrari.size();i++)
        {
            if(listInregistrari.get(i).getId_student().equals(userLbl.getText()) && listInregistrari.get(i).getId_materie().equals(val)){
                valori.add(Float.parseFloat(listInregistrari.get(i).getLaborator1()));
                valori.add(Float.parseFloat(listInregistrari.get(i).getLaborator2()));
                valori.add(Float.parseFloat(listInregistrari.get(i).getLaborator3()));
                valori.add(Float.parseFloat(listInregistrari.get(i).getLaborator4()));
                valori.add(Float.parseFloat(listInregistrari.get(i).getLaborator5()));
                valori.add(Float.parseFloat(listInregistrari.get(i).getLaborator6()));

                if(listInregistrari.get(i).getPrezenta1().equals("prezent"))
                    prez++;
                else if(listInregistrari.get(i).getPrezenta1().equals("absent"))
                    abs++;
                if(listInregistrari.get(i).getPrezenta2().equals("prezent"))
                    prez++;
                else if(listInregistrari.get(i).getPrezenta2().equals("absent"))
                    abs++;
                if(listInregistrari.get(i).getPrezenta3().equals("prezent"))
                    prez++;
                else if(listInregistrari.get(i).getPrezenta3().equals("absent"))
                    abs++;
                if(listInregistrari.get(i).getPrezenta4().equals("prezent"))
                    prez++;
                else if(listInregistrari.get(i).getPrezenta4().equals("absent"))
                    abs++;
                if(listInregistrari.get(i).getPrezenta5().equals("prezent"))
                    prez++;
                else if(listInregistrari.get(i).getPrezenta5().equals("absent"))
                    abs++;
                if(listInregistrari.get(i).getPrezenta6().equals("prezent"))
                    prez++;
                else if(listInregistrari.get(i).getPrezenta6().equals("absent"))
                    abs++;
            }
        }
        System.out.println(valori);
        try {
            FXMLLoader loader = new FXMLLoader();
            Stage primaryStage= new Stage();
            //writeToFileID(txt)
            Pane root = null;
            root = loader.load(getClass().getResource("../View/RaportStudentPeMaterie.fxml").openStream());
            RaportStudentMaterieController rapController = (RaportStudentMaterieController) loader.getController();
            rapController.initLista(valori,abs,prez);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
