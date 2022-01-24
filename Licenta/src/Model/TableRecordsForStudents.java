package Model;

public class TableRecordsForStudents {
    private final String numeMaterie;
    private final String tipActivitate;
    private final String numeProfesor;
    private final String email;

    private final String laborator1;
    private final String prezenta1;

    private final String laborator2;
    private final String prezenta2;

    private final String laborator3;
    private final String prezenta3;

    private final String laborator4;
    private final String prezenta4;

    private final String laborator5;
    private final String prezenta5;

    private final String laborator6;
    private final String prezenta6;

    public TableRecordsForStudents(String numeMaterie, String tipActivitate, String numeProfesor, String email, String laborator1, String prezenta1, String laborator2, String prezenta2, String laborator3, String prezenta3, String laborator4, String prezenta4, String laborator5, String prezenta5, String laborator6, String prezenta6) {
        this.numeMaterie = numeMaterie;
        this.tipActivitate = tipActivitate;
        this.numeProfesor = numeProfesor;
        this.email = email;
        this.laborator1 = laborator1;
        this.prezenta1 = prezenta1;
        this.laborator2 = laborator2;
        this.prezenta2 = prezenta2;
        this.laborator3 = laborator3;
        this.prezenta3 = prezenta3;
        this.laborator4 = laborator4;
        this.prezenta4 = prezenta4;
        this.laborator5 = laborator5;
        this.prezenta5 = prezenta5;
        this.laborator6 = laborator6;
        this.prezenta6 = prezenta6;
    }

    public String getNumeMaterie() {
        return numeMaterie;
    }

    public String getTipActivitate() {
        return tipActivitate;
    }

    public String getNumeProfesor() {
        return numeProfesor;
    }

    public String getEmail() {
        return email;
    }

    public String getLaborator1() {
        return laborator1;
    }

    public String getPrezenta1() {
        return prezenta1;
    }

    public String getLaborator2() {
        return laborator2;
    }

    public String getPrezenta2() {
        return prezenta2;
    }

    public String getLaborator3() {
        return laborator3;
    }

    public String getPrezenta3() {
        return prezenta3;
    }

    public String getLaborator4() {
        return laborator4;
    }

    public String getPrezenta4() {
        return prezenta4;
    }

    public String getLaborator5() {
        return laborator5;
    }

    public String getPrezenta5() {
        return prezenta5;
    }

    public String getLaborator6() {
        return laborator6;
    }

    public String getPrezenta6() {
        return prezenta6;
    }
}
