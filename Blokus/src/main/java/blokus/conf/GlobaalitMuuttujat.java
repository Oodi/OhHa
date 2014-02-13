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
    public static final int[][] LAATTA_VALITSIMEN_ALKUTILANNE = new int[][]{
        {0, 0, 0, 1, 0, 0, 0, 2, 2, 0, 0, 0, 3, 3, 0, 0, 0, 4, 4, 4, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {5, 5, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 9, 9},
        {5, 5, 0, 0, 6, 6, 6, 0, 0, 7, 7, 7, 7, 0, 0, 8, 8, 8, 0, 0, 9, 9, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 11, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 14, 0, 15},
        {10, 0, 0, 0, 0, 0, 11, 0, 0, 12, 0, 0, 0, 0, 13, 13, 13, 0, 14, 14, 14, 0, 15},
        {10, 10, 10, 10, 0, 11, 11, 11, 0, 12, 12, 12, 0, 13, 13, 0, 0, 0, 14, 0, 0, 0, 15},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 15},
        {16, 0, 0, 0, 17, 17, 0, 18, 18, 0, 0, 0, 19, 19, 0, 0, 20, 0, 0, 0, 0, 0, 15},
        {16, 16, 0, 17, 17, 0, 0, 18, 0, 0, 0, 19, 19, 0, 0, 20, 20, 20, 0, 0, 21, 0, 0},
        {16, 16, 0, 17, 0, 0, 0, 18, 18, 0, 0, 0, 19, 0, 0, 0, 20, 0, 0, 21, 21, 21, 21}
    };
}
