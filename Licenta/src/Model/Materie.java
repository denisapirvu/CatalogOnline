package Model;

public class Materie {
    private final String id;
    private final String nume_materie;
    private final String id_prof;

    public Materie(String id, String nume_materie, String id_prof) {
        this.id = id;
        this.nume_materie = nume_materie;
        this.id_prof = id_prof;
    }

    public String getId() {
        return id;
    }

    public String getNume_materie() {
        return nume_materie;
    }

    public String getId_prof() {
        return id_prof;
    }
}
