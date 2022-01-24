package Model;

public class Quiz {
    public final String id_quiz;
    public final String nume_materie;
    public final String nume_grupa;
    public final String data1;
    public final String data2;
    public final String data3;
    public final int nr1;
    public final int nr2;
    public final int nr3;

    public Quiz(String id_quiz, String nume_materie, String nume_grupa, String data1, String data2, String data3, int nr1, int nr2, int nr3) {
        this.id_quiz = id_quiz;
        this.nume_materie = nume_materie;
        this.nume_grupa = nume_grupa;
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.nr1 = nr1;
        this.nr2 = nr2;
        this.nr3 = nr3;
    }

    public String getId_quiz() {
        return id_quiz;
    }

    public String getNume_materie() {
        return nume_materie;
    }

    public String getNume_grupa() {
        return nume_grupa;
    }

    public String getData1() {
        return data1;
    }

    public String getData2() {
        return data2;
    }

    public String getData3() {
        return data3;
    }

    public int getNr1() {
        return nr1;
    }

    public int getNr2() {
        return nr2;
    }

    public int getNr3() {
        return nr3;
    }
}
