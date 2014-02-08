package blokus.logiikka;

import blokus.conf.GlobaalitMuuttujat;
import java.util.HashMap;
import java.util.Map;

/**
 * Pelilaudalle sijoitetaan laatat. Pelilauta esittää laattojen omistajat. 
 * Pelilauta päivittää myös pelaajien tarkastus laudat oikeanlaisiksi.
 */

public class PeliLauta {

    private int[][] lauta;
    private HashMap<Integer, TarkastusLauta> tarkastusLaudat;

    public PeliLauta() {
        lauta = new int[GlobaalitMuuttujat.LAUDAN_KOKO][GlobaalitMuuttujat.LAUDAN_KOKO];
        alusta(lauta);
        tarkastusLaudat = new HashMap<>();

    }

    public boolean lisaaLaattaLaudalle(int pelaajaId, Laatta laatta, int y, int x) {
        TarkastusLauta kasiteltava = tarkastusLaudat.get(pelaajaId);
        if (kasiteltava.tarkistaVoikoLisata(laatta, y, x)) {
            lisaaLaatta(kasiteltava, laatta, y, x);
            return true;
        } else {
            System.out.println("Et voi asettaa laattaa tähän");
            return false;
        }

    }

    private void lisaaLaatta(TarkastusLauta kasiteltava, Laatta laatta, int y, int x) {
        for (int i = 0; i < GlobaalitMuuttujat.RUUDUKON_KOKO; i++) {
            for (int j = 0; j < GlobaalitMuuttujat.RUUDUKON_KOKO; j++) {

                if (laatta.getMuoto()[i][j] == 3) {
                    lisaaLaattaTarkastusLautoihin(y + i - 3, x + j - 3);
                    muutaRuudunOmistaja(laatta.getPelaajanID(), y + i - 3, x + j - 3);
                } else if (laatta.getMuoto()[i][j] == 1 && onkoLaudalla(y, x, i, j)) {
                    kasiteltava.lisaaLaatta(1, y + i - 3, x + j - 3);
                }
            }
        }
    }

    public boolean onkoLaudalla(int y, int x, int i, int j) {
        return y + i - 3 >= 0 && y + i - 3 < GlobaalitMuuttujat.LAUDAN_KOKO && x + j - 3 >= 0 && x + j - 3 < GlobaalitMuuttujat.LAUDAN_KOKO;
    }

    public void muutaRuudunOmistaja(int pelaajaId, int y, int x) {
        this.lauta[y][x] = pelaajaId;
    }

    public void lisaaTarkastusLauta(int id, TarkastusLauta l) {
        tarkastusLaudat.put(id, l);
    }

    private void lisaaLaattaTarkastusLautoihin(int y, int x) {
        for (Map.Entry<Integer, TarkastusLauta> entry : tarkastusLaudat.entrySet()) {
            TarkastusLauta tarkastusLauta = entry.getValue();
            tarkastusLauta.lisaaLaatta(3, y, x);

        }
    }

    public void alusta(int[][] alustettava) {
        for (int i = 0; i < alustettava.length; i++) {
            for (int j = 0; j < alustettava.length; j++) {
                alustettava[i][j] = 0;
            }
        }
    }

    public HashMap<Integer, TarkastusLauta> getTarkastusLaudat() {
        return tarkastusLaudat;
    }

    public int[][] getLauta() {
        return lauta;
    }

    public int getRuudunArvo(int y, int x) {
        return lauta[y][x];
    }
}
