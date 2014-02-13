package javalabra.blokus;

import blokus.gui.Kayttoliittyma;
import blokus.logiikka.Blokus;
import blokus.logiikka.Pelaaja;
import blokus.logiikka.PelaajanLaatat;


public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Blokus peli = new Blokus();
        Kayttoliittyma g = new Kayttoliittyma(peli);
        
    }
}
