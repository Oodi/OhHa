
package blokus.gui.kuuntelijat;

import blokus.conf.GlobaalitMuuttujat;
import blokus.gui.Kayttoliittyma;
import blokus.logiikka.Blokus;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OhitaVuoroKuuntelija implements ActionListener {
    
    Blokus blokus;
    Kayttoliittyma liittyma;
    
    public OhitaVuoroKuuntelija(Blokus blokus, Kayttoliittyma liittyma) {
        this.blokus = blokus;
        this.liittyma = liittyma;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        liittyma.lisaaTeksti(" " + blokus.getIDVariTekstina(blokus.getVuorossa().gePelaajantID()) + " ohitti vuoron.");
        blokus.lopetaVuoro(GlobaalitMuuttujat.OHITA_VUORO,false);    
        liittyma.vuoroVaihtuu();
    }
    
}
