package blokus.kaynnistin;

import blokus.gui.Kayttoliittyma;
import blokus.logiikka.Blokus;


public class Kaynnistin 
{
    public static void main( String[] args )
    {
        Blokus peli = new Blokus();
        
        Kayttoliittyma g = new Kayttoliittyma(peli);
        
    }
}
