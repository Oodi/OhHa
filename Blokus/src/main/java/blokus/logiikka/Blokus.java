package blokus.logiikka;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Luo peliin tarvittavat komponentit. Hallinnoi vuoronvaihtoa ja välittää tietoa
 * eteenpäin.
 */

public class Blokus {

    private PeliLauta peliLauta;
    private Queue<Pelaaja> pelaajat;
    private Pelaaja vuorossa;

    public Blokus() {
        peliLauta = new PeliLauta();
        pelaajat = new LinkedList<>();
        lisaaPelaajat();
        aloitaVuoro();
        //run();

    }
    
   
    
    public void aloitaVuoro() {
        vuorossa = pelaajat.poll();
    }
    
    public void lopetaVuoro(){
        vuorossa.vaihdaValittuaSeuraavaan();
        pelaajat.add(vuorossa);
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
