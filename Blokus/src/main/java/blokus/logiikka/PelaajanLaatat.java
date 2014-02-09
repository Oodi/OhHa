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

    public Laatta getSeuraavaLaatta() {
        if (!jaljellaLaatat.isEmpty()) {
            for (int i = 21; i > 0; i--) {
                if (!pelatutLaatat.containsKey(i)) {
                    return getLaattaById(i);
                }
            }
        }
        return null;
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
        int[][] malli3 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 2, 3, 3, 2, 0, 0},
            {0, 1, 2, 3, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli4 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 2, 2, 1, 0},
            {0, 2, 3, 3, 3, 2, 0},
            {0, 1, 2, 2, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli5 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 2, 3, 3, 2, 0, 0},
            {0, 2, 3, 3, 2, 0, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli6 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 1, 2, 3, 2, 1, 0},
            {0, 2, 3, 3, 3, 2, 0},
            {0, 1, 2, 2, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli7 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {1, 2, 2, 2, 2, 1, 0},
            {2, 3, 3, 3, 3, 2, 0},
            {1, 2, 2, 2, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli8 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 2, 1, 0},
            {0, 1, 2, 2, 3, 2, 0},
            {0, 2, 3, 3, 3, 2, 0},
            {0, 1, 2, 2, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };

        int[][] malli9 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 2, 1, 0},
            {0, 1, 2, 3, 3, 2, 0},
            {0, 2, 3, 3, 2, 1, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli10 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 1, 0, 0, 0},
            {0, 2, 3, 2, 2, 2, 1},
            {0, 2, 3, 3, 3, 3, 2},
            {0, 1, 2, 2, 2, 2, 1},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli11 = new int[][]{
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 1, 2, 3, 2, 1, 0},
            {0, 2, 3, 3, 3, 2, 0},
            {0, 1, 2, 2, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli12 = new int[][]{
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 2, 3, 2, 2, 1},
            {0, 0, 2, 3, 3, 3, 2},
            {0, 0, 1, 2, 2, 2, 1},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli13 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 2, 2, 1},
            {0, 1, 2, 3, 3, 3, 2},
            {0, 2, 3, 3, 2, 2, 1},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli14 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 2, 1, 0},
            {0, 1, 2, 2, 3, 2, 0},
            {0, 2, 3, 3, 3, 2, 0},
            {0, 2, 3, 2, 2, 1, 0},
            {0, 1, 2, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli15 = new int[][]{
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 0}
        };
        int[][] malli16 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 1, 0, 0, 0},
            {0, 2, 3, 2, 1, 0, 0},
            {0, 2, 3, 3, 2, 0, 0},
            {0, 2, 3, 3, 2, 0, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli17 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 2, 1, 0},
            {0, 1, 2, 3, 3, 2, 0},
            {0, 2, 3, 3, 2, 1, 0},
            {0, 2, 3, 2, 1, 0, 0},
            {0, 1, 2, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli18 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 2, 1, 0},
            {0, 0, 2, 3, 3, 2, 0},
            {0, 0, 2, 3, 2, 1, 0},
            {0, 0, 2, 3, 3, 2, 0},
            {0, 0, 1, 2, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli19 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 2, 1, 0},
            {0, 1, 2, 3, 3, 2, 0},
            {0, 2, 3, 3, 2, 1, 0},
            {0, 1, 2, 3, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] malli20 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 1, 2, 3, 2, 1, 0},
            {0, 2, 3, 3, 3, 2, 0},
            {0, 1, 2, 3, 2, 1, 0},
            {0, 0, 1, 2, 1, 0, 0},
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
        lisaaUusiLaatta(1, malli1, 1);
        lisaaUusiLaatta(2, malli2, 2);
        lisaaUusiLaatta(3, malli3, 3);
        lisaaUusiLaatta(3, malli4, 4);
        lisaaUusiLaatta(4, malli5, 5);
        lisaaUusiLaatta(4, malli6, 6);
        lisaaUusiLaatta(4, malli7, 7);
        lisaaUusiLaatta(4, malli8, 8);
        lisaaUusiLaatta(4, malli9, 9);
        lisaaUusiLaatta(5, malli10, 10);
        lisaaUusiLaatta(5, malli11, 11);
        lisaaUusiLaatta(5, malli12, 12);
        lisaaUusiLaatta(5, malli13, 13);
        lisaaUusiLaatta(5, malli14, 14);
        lisaaUusiLaatta(5, malli15, 15);
        lisaaUusiLaatta(5, malli16, 16);
        lisaaUusiLaatta(5, malli17, 17);
        lisaaUusiLaatta(5, malli18, 18);
        lisaaUusiLaatta(5, malli19, 19);
        lisaaUusiLaatta(5, malli20, 20);
        lisaaUusiLaatta(5, malli21, 21);


    }
    
    public void lisaaUusiLaatta(int koko, int[][] malli, int id) {
        jaljellaLaatat.put(id, new Laatta(koko,malli,id, pelaajanID));
    }

    public HashMap<Integer, Laatta> getJaljellaLaatat() {
        return jaljellaLaatat;
    }

    public HashMap<Integer, Laatta> getPelatutLaatat() {
        return pelatutLaatat;
    }
}
