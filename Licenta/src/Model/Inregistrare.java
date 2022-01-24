package Model;

public class Inregistrare {
    public final String id_inregistrare;
    public final String id_student;
    public final String id_materie;
    public final String id_profesor;
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

    public Inregistrare(String id_inregistrare, String id_student,String id_materie,String id_profesor, String laborator1,String prezenta1,String laborator2,String prezenta2,String laborator3,String prezenta3,String laborator4,String prezenta4,String laborator5,String prezenta5,String laborator6,String prezenta6) {
        this.id_inregistrare=id_inregistrare;
        this.id_student=id_student;
        this.id_materie=id_materie;
        this.id_profesor=id_profesor;

        this.laborator1=laborator1;
        this.prezenta1=prezenta1;

        this.laborator2=laborator2;
        this.prezenta2=prezenta2;

        this.laborator3=laborator3;
        this.prezenta3=prezenta3;

        this.laborator4=laborator4;
        this.prezenta4=prezenta4;

        this.laborator5=laborator5;
        this.prezenta5=prezenta5;

        this.laborator6=laborator6;
        this.prezenta6=prezenta6;
    }

    public String getId_inregistrare() {
        return id_inregistrare;
    }

    public String getId_student() {
        return id_student;
    }

    public String getId_materie() {
        return id_materie;
    }

    public String getId_profesor() {
        return id_profesor;
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
