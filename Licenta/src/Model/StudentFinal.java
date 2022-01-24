package Model;

public class StudentFinal {
    private final String id_student;
    private final String nume;
    private final String prenume;
    private final String grupa;
    private final String username;
    private final String password;

    public StudentFinal(String id_student, String nume, String prenume, String grupa, String username, String password) {
        this.id_student = id_student;
        this.nume = nume;
        this.prenume = prenume;
        this.grupa = grupa;
        this.username = username;
        this.password = password;
    }

    public String getId_student() {
        return id_student;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getGrupa() {
        return grupa;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
