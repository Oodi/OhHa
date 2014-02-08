package blokus.logiikka;

import blokus.conf.GlobaalitMuuttujat;

/**
 * Pelaaja asettaa laattoja pelilaudalle. Laatalla on muoto, josta ilmenee sen
 * vuorovaikutus muiden pelilaudalla olevien laattojen suhteen. Laatan koko
 * vaikuttaa myös siitä saataviin pisteisiin.
 */


public class Laatta {
     
    private int koko;
    private int[][] muoto;
    private int id;
    private int pelaajanID;

    public Laatta(int koko, int[][] muoto, int id, int pelaajanID) {
        this.koko = koko;
        this.muoto = muoto;
        this.id = id;
        this.pelaajanID = pelaajanID;

    }

    public void kaannaVasempaan() {
        int[][] kaannos = new int[GlobaalitMuuttujat.RUUDUKON_KOKO][GlobaalitMuuttujat.RUUDUKON_KOKO];

        for (int i = 0; i < GlobaalitMuuttujat.RUUDUKON_KOKO; i++) {
            for (int j = 0; j < GlobaalitMuuttujat.RUUDUKON_KOKO; j++) {
                kaannos[GlobaalitMuuttujat.RUUDUKON_KOKO - j - 1][i] = muoto[i][j];
            }
        }
        muoto = kaannos;
    }

    public void kaannaOikeaan() {
        int[][] kaannos = new int[GlobaalitMuuttujat.RUUDUKON_KOKO][GlobaalitMuuttujat.RUUDUKON_KOKO];

        for (int i = 0; i < GlobaalitMuuttujat.RUUDUKON_KOKO; i++) {
            for (int j = 0; j < GlobaalitMuuttujat.RUUDUKON_KOKO; j++) {
                kaannos[j][GlobaalitMuuttujat.RUUDUKON_KOKO - i - 1] = muoto[i][j];
            }
        }
        muoto = kaannos;


    }

    public void kaannaYmpari() {
        int[][] kaannos = new int[GlobaalitMuuttujat.RUUDUKON_KOKO][GlobaalitMuuttujat.RUUDUKON_KOKO];

        for (int i = 0; i < GlobaalitMuuttujat.RUUDUKON_KOKO; i++) {
            for (int j = 0; j < GlobaalitMuuttujat.RUUDUKON_KOKO; j++) {
                kaannos[GlobaalitMuuttujat.RUUDUKON_KOKO - i - 1][j] = muoto[i][j];
            }
        }
        muoto = kaannos;
    }

    public int getTaulukonArvo(int i, int j) {
        return muoto[i][j];
    }

    public int getKoko() {
        return koko;
    }

    public int[][] getMuoto() {
        return muoto;
    }

    public int getPelaajanID() {
        return pelaajanID;
    }

    public int getId() {
        return id;
    }
}
