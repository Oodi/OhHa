package blokus.logiikka;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Blokus {

    private PeliLauta peliLauta;
    private Queue<Pelaaja> pelaajat;

    public Blokus() throws Exception {
        peliLauta = new PeliLauta();
        pelaajat = new LinkedList<>();
        lisaaPelaajat();
        run();

    }

    private void run() throws Exception {
        Scanner lukija = new Scanner(System.in);
//        while(true) {
//            Pelaaja  vuorossa = pelaajat.poll();
//            peliLauta.tulosta();
//            Laatta testi = vuorossa.getLaatat().getLaattaById(2);
//            peliLauta.lisaaLaattaLaudalle(vuorossa.getId(), testi, 0, 1);
//            System.out.println(""
//                    + "");
//            System.out.println("");
//            peliLauta.tulosta();
//            System.out.println("");
//            vuorossa.getLauta().tulosta();
//            String vastaus = lukija.nextLine();
//            
//            pelaajat.add(vuorossa);
//        }
    }

    private void lisaaPelaajat() {
        Pelaaja pelaaja1 = new Pelaaja(1, "Sininen");
        Pelaaja pelaaja2 = new Pelaaja(2, "Keltainen");
        Pelaaja pelaaja3 = new Pelaaja(3, "Punainen");
        Pelaaja pelaaja4 = new Pelaaja(4, "Vihreä");
        pelaajat.add(pelaaja1);
        pelaajat.add(pelaaja2);
        pelaajat.add(pelaaja3);
        pelaajat.add(pelaaja4);
        peliLauta.lisaaTarkastusLauta(1, pelaaja1.getLauta());

    }
}
