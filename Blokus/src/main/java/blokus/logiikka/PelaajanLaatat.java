package blokus.logiikka;

import java.util.HashMap;
import java.util.HashSet;

public class PelaajanLaatat {

    private HashMap<Integer, Laatta> jaljellaLaatat;
    private HashMap<Integer, Laatta> pelatutLaatat;
    private String vari;

    public PelaajanLaatat(String vari) {
        jaljellaLaatat = new HashMap<>();
        pelatutLaatat = new HashMap<>();
        this.vari = vari;
        alustaLaatat();


    }
    
    public Laatta getLaattaById(int id) {
        Laatta laatta = jaljellaLaatat.get(id);
        pelatutLaatat.put(id, laatta);
        return laatta;
    }

    public HashMap<Integer, Laatta> getJaljellaLaatat() {
        return jaljellaLaatat;
    }

    public HashMap<Integer, Laatta> getPelatutLaatat() {
        return pelatutLaatat;
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

        Laatta laatta1 = new Laatta(1, malli1, 1, vari);
        jaljellaLaatat.put(1, laatta1);
        Laatta laatta2 = new Laatta(2, malli2, 2, vari);
        jaljellaLaatat.put(2, laatta2);
        Laatta laatta21 = new Laatta(5, malli21, 21, vari);
        jaljellaLaatat.put(21, laatta21);

    }
}
