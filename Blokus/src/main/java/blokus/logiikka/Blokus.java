package blokus.logiikka;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Luo peliin tarvittavat komponentit. Hallinnoi vuoronvaihtoa ja välittää
 * tietoa eteenpäin.
 */
public class Blokus {

    private PeliLauta peliLauta;
    private Queue<Pelaaja> pelaajat;
    private Pelaaja vuorossa;
    private int[] pelaajienPisteet;

    /**
     *
     */
    public Blokus() {
        peliLauta = new PeliLauta();
        pelaajat = new LinkedList<>();
        pelaajienPisteet = new int[4];
        lisaaPelaajat();
        alustaPelaajienPisteet();
        aloitaVuoro();

    }

    /**
     *
     */
    public void aloitaVuoro() {
        if (pelaajat.isEmpty()) {
        } else {
            vuorossa = pelaajat.poll();
        }

    }

    /**
     *
     * @param ohita
     * @param antautuu
     */
    public void lopetaVuoro(Boolean ohita, Boolean antautuu) {

        if (!ohita) {
            paivitaVuoroaLopettavanPisteet();
            vuorossa.vaihdaValittuaSeuraavaan();
        }
        if (!antautuu) {
            pelaajat.add(vuorossa);
        }

        aloitaVuoro();
    }

    private void lisaaPelaajat() {
        Pelaaja pelaaja1 = new Pelaaja(1);
        Pelaaja pelaaja2 = new Pelaaja(2);
        Pelaaja pelaaja3 = new Pelaaja(3);
        Pelaaja pelaaja4 = new Pelaaja(4);
        pelaajat.add(pelaaja1);
        pelaajat.add(pelaaja2);
        pelaajat.add(pelaaja3);
        pelaajat.add(pelaaja4);
        peliLauta.lisaaTarkastusLauta(1, pelaaja1.getLauta());
        peliLauta.lisaaTarkastusLauta(2, pelaaja2.getLauta());
        peliLauta.lisaaTarkastusLauta(3, pelaaja3.getLauta());
        peliLauta.lisaaTarkastusLauta(4, pelaaja4.getLauta());

    }

    private void alustaPelaajienPisteet() {
        for (int i = 0; i < pelaajienPisteet.length; i++) {
            pelaajienPisteet[i] = 89;

        }
    }

    public void paivitaVuoroaLopettavanPisteet() {
        pelaajienPisteet[vuorossa.getId() - 1] = vuorossa.getPisteet();
    }

    public int getPelaajanPisteet(int pelaajanID) {
        return pelaajienPisteet[pelaajanID - 1];
    }

    public PeliLauta getPeliLauta() {
        return peliLauta;
    }

    public Queue<Pelaaja> getPelaajat() {
        return pelaajat;
    }

    public Pelaaja getVuorossa() {
        return vuorossa;
    }
}
