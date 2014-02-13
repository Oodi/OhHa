package blokus.logiikka;

import blokus.conf.GlobaalitMuuttujat;
import blokus.conf.LaattojenMuodot;
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
    private int[][] laattaValitsin;

    /**
     *
     * @param pelaajanID
     * Luo pelaajalle laatat ja laattavalitsimen
     */
    public PelaajanLaatat(int pelaajanID) {
        jaljellaLaatat = new HashMap<>();
        pelatutLaatat = new HashMap<>();
        this.pelaajanID = pelaajanID;
        laattaValitsin = getLaattaValitimenAlkuTilanne();
        alustaLaatat();
    }
    
    /**
     *
     * @param y
     * @param x
     * @return Palauttaa laatan ID jos sillä kohtaa valitsimessa on laatta,
     * muuten palauttaa TYHJAN
     */
    public int getLaattaValitsimesta(int y, int x) {
        if (koordinaatitOikein(y, x)) {
        return laattaValitsin[y][x];
    }
        return GlobaalitMuuttujat.TYHJA;
    }

    /**
     * 
     * @return Palauttaa automaattisesti seuraavan laatan joka on käyttämättä
     */
    public Laatta getSeuraavaLaatta() {
        if (!jaljellaLaatat.isEmpty()) {
            for (int i = 21; i > 0; i--) {
                if (!pelatutLaatat.containsKey(i)) {
                    poistaLaattaValitsemesta(i);
                    return getLaattaById(i);
                }
            }
        }
        return null;
    }

    /**
     *
     * @param id
     * @return palauttaa tietyn ID:n laatan ja lisää sen pelatuihin laattoihin
     */
    public Laatta getLaattaById(int id) {
        Laatta laatta = jaljellaLaatat.get(id);
        pelatutLaatat.put(id, laatta);
        return laatta;
    }    

    private void alustaLaatat() {
        lisaaUusiLaatta(1, LaattojenMuodot.MALLI1, 1);
        lisaaUusiLaatta(2, LaattojenMuodot.MALLI2, 2);
        lisaaUusiLaatta(3, LaattojenMuodot.MALLI3, 3);
        lisaaUusiLaatta(3, LaattojenMuodot.MALLI4, 4);
        lisaaUusiLaatta(4, LaattojenMuodot.MALLI5, 5);
        lisaaUusiLaatta(4, LaattojenMuodot.MALLI6, 6);
        lisaaUusiLaatta(4, LaattojenMuodot.MALLI7, 7);
        lisaaUusiLaatta(4, LaattojenMuodot.MALLI8, 8);
        lisaaUusiLaatta(4, LaattojenMuodot.MALLI9, 9);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI10, 10);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI11, 11);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI12, 12);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI13, 13);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI14, 14);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI15, 15);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI16, 16);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI17, 17);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI18, 18);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI19, 19);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI20, 20);
        lisaaUusiLaatta(5, LaattojenMuodot.MALLI21, 21);
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

    public int[][] getLaattaValitsin() {
        return laattaValitsin;
    }
    
    

    /**
     *
     * @param id
     */
    public void poistaLaattaValitsemesta(int id) {
        for (int i = 0; i < laattaValitsin.length; i++) {
            for (int j = 0; j < laattaValitsin[i].length; j++) {
                if (laattaValitsin[i][j] == id) {
                    laattaValitsin[i][j] = 0;
                }
                
            }
            
        }
    }
    
    /**
     *
     * @param id
     */
    public void palautaLaattaValitsimeen(int id) {
        int[][] alkuperainen = getLaattaValitimenAlkuTilanne();
        if (pelatutLaatat.containsKey(id)) {
            pelatutLaatat.remove(id);
        }
        for (int i = 0; i < alkuperainen.length; i++) {
            for (int j = 0; j < alkuperainen[i].length; j++) {
                if (alkuperainen[i][j] == id) {
                    laattaValitsin[i][j] = id;
                }
                
            }
            
        }
    }

    public int getPelaajanID() {
        return pelaajanID;
    }

    private boolean koordinaatitOikein(int y, int x) {
        return y >= 0 && x >= 0 && y < laattaValitsin.length && x < laattaValitsin[y].length;
    }
    
    
    private int[][] getLaattaValitimenAlkuTilanne(){
        return  new int[][]{
        {0, 0, 0, 1, 0, 0, 0, 2, 2, 0, 0, 0, 3, 3, 0, 0, 0, 4, 4, 4, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {5, 5, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 9, 9},
        {5, 5, 0, 0, 6, 6, 6, 0, 0, 7, 7, 7, 7, 0, 0, 8, 8, 8, 0, 0, 9, 9, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 11, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 15},
        {10, 0, 0, 0, 0, 0, 11, 0, 0, 12, 0, 0, 0, 0, 13, 13, 13, 0, 14, 14, 14, 0, 15},
        {10, 10, 10, 10, 0, 11, 11, 11, 0, 12, 12, 12, 0, 13, 13, 0, 0, 0, 14, 0, 0, 0, 15},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15},
        {16, 0, 0, 0, 17, 17, 0, 18, 18, 0, 0, 0, 19, 19, 0, 0, 20, 0, 0, 0, 0, 0, 15},
        {16, 16, 0, 17, 17, 0, 0, 18, 0, 0, 0, 19, 19, 0, 0, 20, 20, 20, 0, 0, 21, 0, 0},
        {16, 16, 0, 17, 0, 0, 0, 18, 18, 0, 0, 0, 19, 0, 0, 0, 20, 0, 0, 21, 21, 21, 21}
    };
    }
    
}
