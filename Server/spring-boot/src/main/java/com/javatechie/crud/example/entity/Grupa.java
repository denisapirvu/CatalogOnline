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
@Table(name = "grupa")
public class Grupa {
    @Id
    @GeneratedValue
    private int id_grupa;
    private String nume_grupa;
    private String materie1;
    private String materie2;
    private String materie3;
    private String materie4;
    private String materie5;
    private String materie6;
    private String materie7;
    private String materie8;
    private String materie9;
    private String materie10;

    public int getId_grupa() {
        return id_grupa;
    }

    public void setId_grupa(int id_grupa) {
        this.id_grupa = id_grupa;
    }

    public String getNume_grupa() {
        return nume_grupa;
    }

    public void setNume_grupa(String nume_grupa) {
        this.nume_grupa = nume_grupa;
    }

    public String getMaterie1() {
        return materie1;
    }

    public void setMaterie1(String materie1) {
        this.materie1 = materie1;
    }

    public String getMaterie2() {
        return materie2;
    }

    public void setMaterie2(String materie2) {
        this.materie2 = materie2;
    }

    public String getMaterie3() {
        return materie3;
    }

    public void setMaterie3(String materie3) {
        this.materie3 = materie3;
    }

    public String getMaterie4() {
        return materie4;
    }

    public void setMaterie4(String materie4) {
        this.materie4 = materie4;
    }

    public String getMaterie5() {
        return materie5;
    }

    public void setMaterie5(String materie5) {
        this.materie5 = materie5;
    }

    public String getMaterie6() {
        return materie6;
    }

    public void setMaterie6(String materie6) {
        this.materie6 = materie6;
    }

    public String getMaterie7() {
        return materie7;
    }

    public void setMaterie7(String materie7) {
        this.materie7 = materie7;
    }

    public String getMaterie8() {
        return materie8;
    }

    public void setMaterie8(String materie8) {
        this.materie8 = materie8;
    }

    public String getMaterie9() {
        return materie9;
    }

    public void setMaterie9(String materie9) {
        this.materie9 = materie9;
    }

    public String getMaterie10() {
        return materie10;
    }

    public void setMaterie10(String materie10) {
        this.materie10 = materie10;
    }
}
