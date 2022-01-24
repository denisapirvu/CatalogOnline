package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.sql.*;

public class LoginModel {

    public boolean isLoginTeacher(String user, String pass) throws SQLException {
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
            ObservableList<Teacher> masterData = FXCollections.observableArrayList();
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
               // System.out.println(jsonObject.get("id_Teacher").toString());
                masterData.add(new Teacher(jsonObject.get("id_Teacher").toString(), jsonObject.get("username").toString(), jsonObject.get("password").toString(), jsonObject.get("name").toString(), jsonObject.get("surname").toString(), jsonObject.get("email").toString()));
            }

            int size = masterData.size();
            for(int i=0;i<size;i++)
            {
                if(masterData.get(i).getUsername().equals(user) && masterData.get(i).getPassword().equals(pass)){
                    return true;
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean isLoginStudent(String user, String pass) throws SQLException {

        // System.out.println("vbjsdvvk");
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
            ObservableList<StudentFinal> masterData = FXCollections.observableArrayList();
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) parser.parse(object.toString());
                masterData.add(new StudentFinal(jsonObject.get("id_student").toString(), jsonObject.get("name").toString(), jsonObject.get("surname").toString(), jsonObject.get("grupa").toString(), jsonObject.get("username").toString(), jsonObject.get("password").toString()));
            }

            int size = masterData.size();
            for(int i=0;i<size;i++)
            {
                if(masterData.get(i).getUsername().equals(user) && masterData.get(i).getPassword().equals(pass)){
                    return true;
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
