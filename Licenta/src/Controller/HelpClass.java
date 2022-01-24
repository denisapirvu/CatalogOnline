package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HelpClass {
    public static List<String> list = new ArrayList<String>();

    public ObservableList<Teacher> getListTeachers() {
        ObservableList<Teacher> masterData = FXCollections.observableArrayList();
        try {
            URL urll = new URL("http://localhost:8080/Teachers");
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());

            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                // System.out.println(jsonObject.get("id_Teacher").toString());
                masterData.add(new Teacher(jsonObject.get("id_Teacher").toString(), jsonObject.get("username").toString(), jsonObject.get("password").toString(), jsonObject.get("name").toString(), jsonObject.get("surname").toString(), jsonObject.get("email").toString()));
            }

            return masterData;

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return masterData;
    }

    public ObservableList<Quiz> getListQuiz() {
        ObservableList<Quiz> masterData = FXCollections.observableArrayList();
        try {
            URL urll = new URL("http://localhost:8080/Quizuri");
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());

            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                // System.out.println(jsonObject.get("id_Teacher").toString());
                masterData.add(new Quiz(jsonObject.get("id_quiz").toString(), jsonObject.get("nume_materie").toString(), jsonObject.get("nume_grupa").toString(), jsonObject.get("data1").toString(), jsonObject.get("data2").toString(), jsonObject.get("data3").toString(),Integer.parseInt(jsonObject.get("nr1").toString()),Integer.parseInt(jsonObject.get("nr2").toString()),Integer.parseInt(jsonObject.get("nr3").toString())));
            }

            return masterData;

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masterData;
    }
    public void insertQuiz(String nume_materie,String nume_grupa,String data1,String data2,String data3) {
        //ObservableList<Teacher> masterData = FXCollections.observableArrayList();
        JSONObject json = new JSONObject();
        //json.put("id_student",1);
        json.put("nume_materie",nume_materie);
        json.put("nume_grupa",nume_grupa);
        json.put("data1",data1);
        json.put("data2",data2);
        json.put("data3",data3);
        json.put("nr1",0);
        json.put("nr2",0);
        json.put("nr3",0);
        try{
            URL url = new URL("http://localhost:8080/addQuiz");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            //BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // if(in.readLine().equalsIgnoreCase("succes")){
            //    System.out.println("ceva");
            // }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void updateQuiz(String id_quiz,String nume_materie, String nume_grupa,String data1,String data2,String data3,int nr1,int nr2,int nr3){
        JSONObject json = new JSONObject();
        json.put("id_quiz",id_quiz);
        json.put("nume_materie",nume_materie);
        json.put("nume_grupa",nume_grupa);
        json.put("data1",data1);
        json.put("data2",data2);
        json.put("data3",data3);
        json.put("nr1",nr1);
        json.put("nr2",nr2);
        json.put("nr3",nr3);
        try{
            URL url = new URL("http://localhost:8080/updateQuiz");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //   if(in.readLine().equalsIgnoreCase("succes")){
            //       System.out.println("ceva");
            //  }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void insertTeacher(String username, String password, String nume,String prenume,String email) {
        //ObservableList<Teacher> masterData = FXCollections.observableArrayList();
        JSONObject json = new JSONObject();
        //json.put("id_student",1);
        json.put("username",username);
        json.put("password",password);
        json.put("name",nume);
        json.put("surname",prenume);
        json.put("email",email);
        try{
            URL url = new URL("http://localhost:8080/addTeacher");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            //BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
           // if(in.readLine().equalsIgnoreCase("succes")){
            //    System.out.println("ceva");
           // }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void insertStudent(String username, String password, String nume,String prenume,String grupa) {
        //ObservableList<Teacher> masterData = FXCollections.observableArrayList();
        JSONObject json = new JSONObject();
        //json.put("id_student",1);
        json.put("username",username);
        json.put("password",password);
        json.put("name",nume);
        json.put("surname",prenume);
        json.put("grupa",grupa);
        try{
            URL url = new URL("http://localhost:8080/addStudent");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            //BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // if(in.readLine().equalsIgnoreCase("succes")){
            //    System.out.println("ceva");
            // }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void insertMaterie(String nume_materie, String id_prof) {
        //ObservableList<Teacher> masterData = FXCollections.observableArrayList();
        JSONObject json = new JSONObject();
        //json.put("id_student",1);
        json.put("nume_materie",nume_materie);
        json.put("id_profesor",id_prof);

        try{
            URL url = new URL("http://localhost:8080/addMaterie");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            //BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // if(in.readLine().equalsIgnoreCase("succes")){
            //    System.out.println("ceva");
            // }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void insertGrupa(String nume_grupa, String materie1,String materie2,String materie3,String materie4,String materie5,String materie6,String materie7,String materie8,String materie9,String materie10) {
        //ObservableList<Teacher> masterData = FXCollections.observableArrayList();
        JSONObject json = new JSONObject();
        //json.put("id_student",1);
        json.put("nume_grupa",nume_grupa);
       // if(materie1==null)
       // json.put("materie1","");
       // else
            json.put("materie1",materie1);
      //  if(materie2==null) {
       //     json.put("materie2", "");
       // }else
            json.put("materie2", materie2);

        json.put("materie3",materie3);
        json.put("materie4",materie4);
        json.put("materie5",materie5);
        json.put("materie6",materie6);
        json.put("materie7",materie7);
        json.put("materie8",materie8);
        json.put("materie9",materie9);
        json.put("materie10",materie10);

        try{
            URL url = new URL("http://localhost:8080/addGrupa");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            //BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // if(in.readLine().equalsIgnoreCase("succes")){
            //    System.out.println("ceva");
            // }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void insertInregistrare(String id_student,String id_materie, String id_prof,String laborator1,String prezenta1,String laborator2,String prezenta2,String laborator3,String prezenta3,String laborator4,String prezenta4,String laborator5,String prezenta5,String laborator6,String prezenta6) {
        //ObservableList<Teacher> masterData = FXCollections.observableArrayList();
        JSONObject json = new JSONObject();
        //json.put("id_student",1);
        json.put("id_student",id_student);
        json.put("id_profesor",id_prof);
        json.put("id_materie",id_materie);
        json.put("prezenta1",prezenta1);
        json.put("laborator1",laborator1);
        json.put("prezenta2",prezenta2);
        json.put("laborator2",laborator2);
        json.put("prezenta3",prezenta3);
        json.put("laborator3",laborator4);
        json.put("prezenta4",prezenta4);
        json.put("laborator4",laborator4);
        json.put("prezenta5",prezenta5);
        json.put("laborator5",laborator5);
        json.put("prezenta6",prezenta6);
        json.put("laborator6",laborator6);

        try{
            URL url = new URL("http://localhost:8080/addInregistrare");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            //BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // if(in.readLine().equalsIgnoreCase("succes")){
            //    System.out.println("ceva");
            // }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public ObservableList<StudentFinal> getListStudent(){
        ObservableList<StudentFinal> masterData = FXCollections.observableArrayList();

        try {
            URL urll = new URL("http://localhost:8080/students");
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());

            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                masterData.add(new StudentFinal(jsonObject.get("id_student").toString(), jsonObject.get("name").toString(), jsonObject.get("surname").toString(), jsonObject.get("grupa").toString(), jsonObject.get("username").toString(), jsonObject.get("password").toString()));
            }
            return masterData;

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
      return masterData;
    }
    public void updateStud(String id,String username, String password,String grupa,String nume,String prenume){
        JSONObject json = new JSONObject();
        json.put("id_student",id);
        json.put("username",username);
        json.put("password",password);
        json.put("name",nume);
        json.put("surname",prenume);
        json.put("grupa",grupa);
        try{
            URL url = new URL("http://localhost:8080/update");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         //   if(in.readLine().equalsIgnoreCase("succes")){
         //       System.out.println("ceva");
          //  }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public ObservableList<Grupa> getListGrupe() {
        ObservableList<Grupa> masterData = FXCollections.observableArrayList();
        try {
            URL urll = new URL("http://localhost:8080/Grupe");
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());


            for (Object object : jsonArray) {
                String materie1="";
                String materie2="";
                String materie3="";
                String materie4="";
                String materie5="";
                String materie6="";
                String materie7="";
                String materie8="";
                String materie9="";
                String materie10="";
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                // System.out.println(jsonObject.get("nume_grupa").toString());
                if(!(jsonObject.get("materie1")==null))
                    materie1=jsonObject.get("materie1").toString();
                if(!(jsonObject.get("materie2")==null))
                    materie2=jsonObject.get("materie2").toString();
                if(!(jsonObject.get("materie3")==null))
                    materie3=jsonObject.get("materie3").toString();
                if(!(jsonObject.get("materie4")==null))
                    materie4=jsonObject.get("materie4").toString();
                if(!(jsonObject.get("materie5")==null))
                    materie5=jsonObject.get("materie5").toString();
                if(!(jsonObject.get("materie6")==null))
                    materie6=jsonObject.get("materie6").toString();
                if(!(jsonObject.get("materie7")==null))
                    materie7=jsonObject.get("materie7").toString();
                if(!(jsonObject.get("materie8")==null))
                    materie8=jsonObject.get("materie8").toString();
                if(!(jsonObject.get("materie9")==null))
                    materie9=jsonObject.get("materie9").toString();
                if(!(jsonObject.get("materie10")==null))
                    materie10=jsonObject.get("materie10").toString();
                masterData.add(new Grupa(jsonObject.get("nume_grupa").toString(),materie1,materie2,materie3,materie4,materie5,materie6,materie7,materie8,materie9,materie10));
            }

            return masterData;

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masterData;
    }
    public ObservableList<Inregistrare> getListInregistrari() {
        ObservableList<Inregistrare> masterData = FXCollections.observableArrayList();
        try {
            URL urll = new URL("http://localhost:8080/Inregistrari");
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());

            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                 System.out.println(jsonObject.get("id_inregistrare").toString());
                masterData.add(new Inregistrare(jsonObject.get("id_inregistrare").toString(), jsonObject.get("id_student").toString(),jsonObject.get("id_materie").toString(),jsonObject.get("id_profesor").toString(),jsonObject.get("laborator1").toString(),jsonObject.get("prezenta1").toString(),jsonObject.get("laborator2").toString(),jsonObject.get("prezenta2").toString(),jsonObject.get("laborator3").toString(),jsonObject.get("prezenta3").toString(),jsonObject.get("laborator4").toString(),jsonObject.get("prezenta4").toString(),jsonObject.get("laborator5").toString(),jsonObject.get("prezenta5").toString(),jsonObject.get("laborator6").toString(),jsonObject.get("prezenta6").toString()));
            }

            return masterData;

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masterData;
    }
    public ObservableList<Materie> getListMaterii(String id) {
        ObservableList<Materie> masterData = FXCollections.observableArrayList();
        try {
            URL urll = new URL("http://localhost:8080/Materii");
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());

            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                // System.out.println(jsonObject.get("ifesd_proo").toString());
                if(jsonObject.get("id_profesor").toString().equals(id))
                masterData.add(new Materie(jsonObject.get("id_materie").toString(), jsonObject.get("nume_materie").toString(),jsonObject.get("id_profesor").toString()));
            }

            return masterData;

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masterData;
    }
    public ObservableList<Materie> getMaterii() {
        ObservableList<Materie> masterData = FXCollections.observableArrayList();
        try {
            URL urll = new URL("http://localhost:8080/Materii");
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());

            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                // System.out.println(jsonObject.get("ifesd_proo").toString());
                //if(jsonObject.get("id_profesor").toString().equals(id))
                    masterData.add(new Materie(jsonObject.get("id_materie").toString(), jsonObject.get("nume_materie").toString(),jsonObject.get("id_profesor").toString()));
            }

            return masterData;

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masterData;
    }
    public StudentFinal getStudentByID(String id){
        ObservableList<StudentFinal> lista;
        lista = getListStudent();
        int size = lista.size();
        for(int i=0;i<size;i++){
            if(lista.get(i).getId_student().equals(id)){
                return lista.get(i);
            }
        }
        return null;
    }
    public Inregistrare getInregistrareByID(String id){
        ObservableList<Inregistrare> lista;
        lista = getListInregistrari();
        int size=lista.size();
        for(int i=0;i<size;i++){
            if(lista.get(i).getId_inregistrare().equals(id)){
                return lista.get(i);
            }
        }
        return null;
    }
    public Teacher getTeacherByID(String id){
        ObservableList<Teacher> lista = FXCollections.observableArrayList();
        lista = getListTeachers();
        int size=lista.size();
        for(int i=0;i<size;i++){
            if(lista.get(i).getId_teacher().equals(id)){
                return lista.get(i);
            }
        }
        return null;
    }
    public void deleteStud(String id){
        try {
            URL urll = new URL("http://localhost:8080/delete/"+id);
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());



        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void deleteInregistrare(String id){
        try {
            URL urll = new URL("http://localhost:8080/deleteInregistrare/"+id);
            HttpURLConnection conn = (HttpURLConnection) urll.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            //  conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("DELETE");
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            JSONParser parser = new JSONParser();
            JSONArray jsonArray = (JSONArray) parser.parse(in.readLine());



        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void updateInregistrare(String id_inregistrare,String id_student, String id_materie,String id_profesor,String laborator1,String prezenta1, String laborator2,String prezenta2,String laborator3,String prezenta3,String laborator4,String prezenta4,String laborator5,String prezenta5,String laborator6,String prezenta6){
        JSONObject json = new JSONObject();
        json.put("id_inregistrare",id_inregistrare);
        json.put("id_student",id_student);
        json.put("id_materie",id_materie);
        json.put("id_profesor",id_profesor);
        json.put("laborator1",laborator1);
        json.put("prezenta1",prezenta1);
        json.put("laborator2",laborator2);
        json.put("prezenta2",prezenta2);
        json.put("laborator3",laborator3);
        json.put("prezenta3",prezenta3);
        json.put("laborator4",laborator4);
        json.put("prezenta4",prezenta4);
        json.put("laborator5",laborator5);
        json.put("prezenta5",prezenta5);
        json.put("laborator6",laborator6);
        json.put("prezenta6",prezenta6);

        try{
            URL url = new URL("http://localhost:8080/updateInregistrare");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setDoOutput(true);
            conn.setRequestMethod("PUT");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(json.toString());
            wr.flush();
            wr.flush();
            wr.close();
            conn.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            //   if(in.readLine().equalsIgnoreCase("succes")){
            //       System.out.println("ceva");
            //  }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
