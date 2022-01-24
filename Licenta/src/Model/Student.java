package Model;


public class Student {
    private final String id_student;
    private final String nume;
    private final String prenume;
    private final String grupa;


    public Student(String id_student, String nume, String prenume, String grupa){
        this.id_student = id_student;
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;

    }
    public String getId() {
        return id_student;
    }

    public String getGrupa() {
        return grupa;
    }



    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

}
