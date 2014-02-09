package blokus.logiikka;

import blokus.conf.GlobaalitMuuttujat;

/**
 * Jokaisella pelaajalla on oma näkökulmansa pelilaudalle, siis mihin hän
 * voi laattansa asettaa. Tarkastus laudalta tarkastetaan voiko pelaaja asettaa
 * laattansa tiettyyn kohtaa lautaa.
 */

public class TarkastusLauta {

    int[][] tLauta;

    public TarkastusLauta(int pelaajanId) {
        tLauta = new int[GlobaalitMuuttujat.LAUDAN_KOKO][GlobaalitMuuttujat.LAUDAN_KOKO];
        alusta(pelaajanId);
    }

    public boolean tarkistaVoikoLisata(Laatta laatta, int y, int x) {
        boolean laattaSalKohtaan = false;
        for (int i = 0; i < GlobaalitMuuttujat.RUUDUKON_KOKO; i++) {
            for (int j = 0; j < GlobaalitMuuttujat.RUUDUKON_KOKO; j++) {

                if (!onkoLaudalla(y, x, i, j) && laatta.getMuoto()[i][j] == GlobaalitMuuttujat.LAATTA) {
                    return false;
                } else if (onkoLaudalla(y, x, i, j)) {
                    if (laatta.getMuoto()[i][j] == GlobaalitMuuttujat.LAATTA && tLauta[y + i - 3][x + j - 3] == GlobaalitMuuttujat.KIELLETTY_ALUE) {
                        return false;
                    }else if (laatta.getMuoto()[i][j] == GlobaalitMuuttujat.LAATTA && tLauta[y + i - 3][x + j - 3] == GlobaalitMuuttujat.LAATTA) {
                        return false;
                    }
                    if (laatta.getMuoto()[i][j] == GlobaalitMuuttujat.LAATTA && tLauta[y + i - 3][x + j - 3] == GlobaalitMuuttujat.KULMA) {
                        laattaSalKohtaan = true;
                    }
                }
            }
        }
        return laattaSalKohtaan;
    }

    public void lisaaLaatta(int koodi, int y, int x) {
        if (!(y < 0 || x < 0 || y >= GlobaalitMuuttujat.LAUDAN_KOKO || x >= GlobaalitMuuttujat.LAUDAN_KOKO)) {
            tLauta[y][x] = koodi;
        }

    }

    public boolean onkoLaudalla(int y, int x, int i, int j) {
        return y + i - 3 >= 0 && y + i - 3 < GlobaalitMuuttujat.LAUDAN_KOKO && x + j - 3 >= 0 && x + j - 3 < GlobaalitMuuttujat.LAUDAN_KOKO;
    }

    private void alusta(int id) {
        for (int i = 0; i < tLauta.length; i++) {
            for (int j = 0; j < tLauta.length; j++) {
                tLauta[i][j] = 0;
            }
        }
        tLauta[0][0] = 2;
        tLauta[0][tLauta.length-1] = 2;
        tLauta[tLauta.length-1][0] = 2;
        tLauta[tLauta.length-1][tLauta.length-1] = 2;
        if (id == 1) {
            tLauta[0][0] = 1;
        } else if (id == 2) {
            tLauta[0][tLauta.length-1] = 1;
        } else if (id == 4) {
            tLauta[tLauta.length-1][0] = 1;
        } else if (id == 3) {
            tLauta[tLauta.length-1][tLauta.length-1] = 1;
        } else {
        }

    }
}
