package blokus.conf;

import java.awt.Color;

/**
 * Sisältää kaikki globaalit muuttuja, jotka pysyvät samoina kokoajan.
 */
public abstract class GlobaalitMuuttujat {

    public static final int LAUDAN_KOKO = 20;
    public static final int RUUDUKON_KOKO = 7; // 7x7
    //
    public static final int LAATTA = 3;
    public static final int KIELLETTY_ALUE = 2;
    public static final int KULMA = 1;
    public static final int TYHJA = 0;
    //
    public static final boolean ANTAUDU = true;
    public static final boolean OHITA_VUORO = true;
    //
    public static final int LAUDAN_RESOLUUTIO = 500;
    public static final int VALITSIMEN_RESOLUUTIO = 400;
    public static final int PIENEN_VALITSIMEN_RESOLUUTIO = 200;
    //
    public static final Color SININEN = Color.BLUE;
    public static final Color KELTAINEN = Color.ORANGE;
    public static final Color PUNAINEN = Color.red;
    public static final Color VIHREA = Color.green;
    //

}
