package blokus.logiikka;

import java.util.HashMap;
import java.util.HashSet;

/**
 * PelaajanLaatat luo pelaajalle alussa kaikki käytössä olevat laatat ja pitää
 * niitä kasassa.
 */

public class PelaajanLaatat {

    private HashMap<Integer, Laatta> jaljellaLaatat;
    private HashMap<Integer, Laatta> pelatutLaatat;
    private int pelaajanID;

    public PelaajanLaatat(int pelaajanID) {
        jaljellaLaatat = new HashMap<>();
        pelatutLaatat = new HashMap<>();
        this.pelaajanID = pelaajanID;
        alustaLaatat();


    }

    public Laatta getLaattaById(int id) {
        Laatta laatta = jaljellaLaatat.get(id);
        pelatutLaatat.put(id, laatta);
        return laatta;
    }

    // 0= vapaa ruutu, 1=kulma ruutu, 2 = ei sallittu ruutu, 3= laatta itse
    private void alustaLaatat() {
        int[][] malli1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };


        int[][] malli2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 2, 3, 3, 2, 0, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli21 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 1, 0, 0, 0},
            {1, 2, 3, 2, 2, 1, 0},
            {2, 3, 3, 3, 3, 2, 0},
            {1, 2, 2, 2, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };

        Laatta laatta1 = new Laatta(1, malli1, 1, pelaajanID);
        jaljellaLaatat.put(1, laatta1);
        Laatta laatta2 = new Laatta(2, malli2, 2, pelaajanID);
        jaljellaLaatat.put(2, laatta2);
        Laatta laatta21 = new Laatta(5, malli21, 21, pelaajanID);
        jaljellaLaatat.put(21, laatta21);

    }

    public HashMap<Integer, Laatta> getJaljellaLaatat() {
        return jaljellaLaatat;
    }

    public HashMap<Integer, Laatta> getPelatutLaatat() {
        return pelatutLaatat;
    }
}
