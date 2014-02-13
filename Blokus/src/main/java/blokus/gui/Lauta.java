package blokus.gui;

import blokus.conf.GlobaalitMuuttujat;
import blokus.logiikka.Laatta;
import blokus.logiikka.PeliLauta;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 * Visualisoi pelilaudan ja visualisoi pelilaudan yllä olevan "ilmatilan"
 */
public class Lauta {

    private PeliLauta lauta;
    private int resoluutio;
    private int[][] varjoLauta;

    public Lauta(PeliLauta lauta, int resoluutio) {
        this.lauta = lauta;
        this.resoluutio = resoluutio;
        varjoLauta = new int[GlobaalitMuuttujat.LAUDAN_KOKO][GlobaalitMuuttujat.LAUDAN_KOKO];
        lauta.alusta(varjoLauta);
        
    }

    public void paivitaVarjoLautaa(Laatta laatta, int y, int x) {
        lauta.alusta(varjoLauta);
        for (int i = 0; i < GlobaalitMuuttujat.RUUDUKON_KOKO; i++) {
            for (int j = 0; j < GlobaalitMuuttujat.RUUDUKON_KOKO; j++) {
                if (lauta.onkoLaudalla(y, x, i, j) && laatta.getTaulukonArvo(i, j) == GlobaalitMuuttujat.LAATTA) {
                    varjoLauta[y + i - 3][x + j - 3] = laatta.getPelaajanID();
                }
            }
        }
    }

    public void alustaVarjoLauta() {
        lauta.alusta(varjoLauta);
    }

    public BufferedImage muodostaLaudastaKuva() {
        BufferedImage kuva = new BufferedImage(resoluutio + 1, resoluutio + 1, BufferedImage.TYPE_INT_RGB);
        int ruudunKoko = resoluutio / (GlobaalitMuuttujat.LAUDAN_KOKO);
        Graphics2D g = (Graphics2D) kuva.getGraphics();

        for (int i = 0; i < GlobaalitMuuttujat.LAUDAN_KOKO; i++) {
            for (int j = 0; j < GlobaalitMuuttujat.LAUDAN_KOKO; j++) {
                g.setColor(getVari(lauta.getRuudunArvo(j, i)));
                if (varjoLauta[j][i] != 0) {
                    g.setColor(getVari(varjoLauta[j][i]));

                }

                g.fillRect(i * ruudunKoko, j * ruudunKoko, ruudunKoko, ruudunKoko);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(i * ruudunKoko, j * ruudunKoko, ruudunKoko, ruudunKoko);
            }
        }
        g.setColor(Color.BLACK);
        g.drawRect(0, 0, resoluutio, resoluutio);
        return kuva;

    }

    public Point getSijainti(Point pikseli) {
        return new Point(pikseli.y / (resoluutio / GlobaalitMuuttujat.LAUDAN_KOKO), pikseli.x / (resoluutio / GlobaalitMuuttujat.LAUDAN_KOKO));
    }

        public static Color getVari(int vari) {
        switch (vari) {
            case 1:
                return GlobaalitMuuttujat.SININEN;
            case 2:
                return GlobaalitMuuttujat.KELTAINEN;
            case 3:
                return GlobaalitMuuttujat.PUNAINEN;
            case 4:
                return GlobaalitMuuttujat.VIHREA;
            default:
                return Color.WHITE;
        }
    }
}
