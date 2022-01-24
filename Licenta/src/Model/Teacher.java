package Model;

public class Teacher {
    private final String id_teacher;
    private final String username;
    private final String password;
    private final String name;
    private final String surname;
    private final String email;

    public Teacher(String id, String username, String password, String nume, String prenume, String email) {

        this.id_teacher= id;
        this.username=username;
        this.password=password;
        this.name=nume;
        this.surname=prenume;
        this.email=email;
    }

    public String getId_teacher() {
        return id_teacher;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}
