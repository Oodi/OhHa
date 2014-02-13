package blokus.logiikka;

import blokus.conf.GlobaalitMuuttujat;
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

    /**
     *
     * @param id määrittää ID:n pelaajalle
     * Luo pelaajalle laatat ja tarkastus laudan 
     * ja ottaa pelaajan käteen ensimmäisen laatan
     */
    public Pelaaja(int id) {
        this.id = id;
        laatat = new PelaajanLaatat(id);
        lauta = new TarkastusLauta(id);
        valittuna = laatat.getSeuraavaLaatta();
    }

    /**
     * Hakee pelaajan käteen automaattisesti seuraavan vapaan laatan
     */
    public void vaihdaValittuaSeuraavaan() {
        valittuna = laatat.getSeuraavaLaatta();
    }

    /**
     *
     * @param y 
     * @param x
     * Vaihtaa valittua laattaa laattavalitsimesta löytyvään laattaan
     * koordinaattien perusteella.
     */
    public void vaihdaValittuaLaattaa(int y, int x) {
        int laattaId = laatat.getLaattaValitsimesta(y, x);
        if (laattaId != GlobaalitMuuttujat.TYHJA) {
            laatat.palautaLaattaValitsimeen(valittuna.getId());
            laatat.poistaLaattaValitsemesta(laattaId);
            valittuna = laatat.getLaattaById(laattaId);
            
        }
        
    }

    public TarkastusLauta getLauta() {
        return lauta;
    }

    public Laatta getValittuna() {
        return valittuna;
    }

    /**
     * Hakee pelaajan sen hetkisen pistemäärän
     * @return sen hetkinen pistemäärä
     */
    public int getPisteet() {
        HashMap<Integer, Laatta> apu = laatat.getJaljellaLaatat();
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
