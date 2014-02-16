package blokus.kaynnistin;

import blokus.gui.Kayttoliittyma;
import blokus.logiikka.Blokus;


public class Main 
{
    public static void main( String[] args )
    {
        Blokus peli = new Blokus();    
        peli.aloitaVuoro();
        Kayttoliittyma g = new Kayttoliittyma(peli);
        
    }
}
