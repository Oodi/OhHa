
package blokus.logiikka;

import java.util.HashMap;
/**
 * Pelaaja luokka hallitsee pelaajan komponentteja. Ja laskee pelaajan sen
 * hetkisen pistemäärän.
 * 
 */


public class Pelaaja {
    
    private int id;   
    private PelaajanLaatat laatat;
    private TarkastusLauta lauta;
    private Laatta valittuna;

    public Pelaaja(int id) {
        this.id = id;        
        laatat = new PelaajanLaatat(id);
        lauta = new TarkastusLauta(id);
        valittuna = laatat.getLaattaById(21);
    }

    public TarkastusLauta getLauta() {
        return lauta;
    }

    public Laatta getValittuna() {
        return valittuna;
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
