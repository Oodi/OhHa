
package blokus.logiikka;

import java.util.HashMap;
import java.util.Map;


public class Pelaaja {
    
    private int id;
    
    private String vari;
    private PelaajanLaatat laatat;
   // private PeliLauta lauta;

    public Pelaaja(int id, String vari) {
        this.id = id;        
        this.vari = vari;
        laatat = new PelaajanLaatat(vari);
    }

    public int getPisteet() {
        HashMap<Integer,Laatta> apu = laatat.getJaljellaLaatat();
        int pisteet = 0;
        for (Laatta laatta : apu.values()) {
            pisteet += laatta.getKoko();
            
        }
          return pisteet;
    }

    public int getId() {
        return id;
    }

    public PelaajanLaatat getLaatat() {
        return laatat;
    }
    
    
    
    
    
}