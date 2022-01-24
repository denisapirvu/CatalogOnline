package com.javatechie.crud.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inregistrare")
public class Inregistrare {
    @Id
    @GeneratedValue
    private int id_inregistrare;
    private String id_student;
    private String id_materie;
    private String id_profesor;

    private String laborator1;
    private String prezenta1;

    private String laborator2;
    private String prezenta2;

    private String laborator3;
    private String prezenta3;

    private String laborator4;
    private String prezenta4;

    private String laborator5;
    private String prezenta5;

    private String laborator6;
    private String prezenta6;

    public int getId_inregistrare() {
        return id_inregistrare;
    }

    public void setId_inregistrare(int id_inregistrare) {
        this.id_inregistrare = id_inregistrare;
    }

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getId_materie() {
        return id_materie;
    }

    public void setId_materie(String id_materie) {
        this.id_materie = id_materie;
    }

    public String getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getLaborator1() {
        return laborator1;
    }

    public void setLaborator1(String laborator1) {
        this.laborator1 = laborator1;
    }

    public String getPrezenta1() {
        return prezenta1;
    }

    public void setPrezenta1(String prezenta1) {
        this.prezenta1 = prezenta1;
    }

    public String getLaborator2() {
        return laborator2;
    }

    public void setLaborator2(String laborator2) {
        this.laborator2 = laborator2;
    }

    public String getPrezenta2() {
        return prezenta2;
    }

    public void setPrezenta2(String prezenta2) {
        this.prezenta2 = prezenta2;
    }

    public String getLaborator3() {
        return laborator3;
    }

    public void setLaborator3(String laborator3) {
        this.laborator3 = laborator3;
    }

    public String getPrezenta3() {
        return prezenta3;
    }

    public void setPrezenta3(String prezenta3) {
        this.prezenta3 = prezenta3;
    }

    public String getLaborator4() {
        return laborator4;
    }

    public void setLaborator4(String laborator4) {
        this.laborator4 = laborator4;
    }

    public String getPrezenta4() {
        return prezenta4;
    }

    public void setPrezenta4(String prezenta4) {
        this.prezenta4 = prezenta4;
    }

    public String getLaborator5() {
        return laborator5;
    }

    public void setLaborator5(String laborator5) {
        this.laborator5 = laborator5;
    }

    public String getPrezenta5() {
        return prezenta5;
    }

    public void setPrezenta5(String prezenta5) {
        this.prezenta5 = prezenta5;
    }

    public String getLaborator6() {
        return laborator6;
    }

    public void setLaborator6(String laborator6) {
        this.laborator6 = laborator6;
    }

    public String getPrezenta6() {
        return prezenta6;
    }

    public void setPrezenta6(String prezenta6) {
        this.prezenta6 = prezenta6;
    }
}
