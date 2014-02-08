package blokus.gui.kuuntelijat;

import blokus.gui.Kayttoliittyma;
import blokus.gui.Lauta;
import blokus.logiikka.Blokus;
import blokus.logiikka.Laatta;
import blokus.logiikka.Pelaaja;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 * Kuuntelee hiirtä, kun hiiri on pelilaudan yläpuolella. Lähettää laatan asettamis ja
 * kääntelemis komennot eteenpäin.
 */

public class LaudanHiiriKuuntelija implements MouseListener, MouseMotionListener, MouseWheelListener {

    Blokus blokus;
    Lauta lauta;
    Point hiirenSijainti;
    Kayttoliittyma liittyma;

    public LaudanHiiriKuuntelija(Blokus blokus, Lauta lauta, Kayttoliittyma liittyma) {
        this.blokus = blokus;
        this.lauta = lauta;
        this.liittyma = liittyma;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Pelaaja vuorossa = blokus.getVuorossa();
        Laatta valittuna = vuorossa.getValittuna();
        if (e.getButton() == MouseEvent.BUTTON3) {
            valittuna.kaannaYmpari();
            paivitaVarjolautaa();
        } else {
            try {
                if (blokus.getPeliLauta().lisaaLaattaLaudalle(vuorossa.getId(), valittuna,
                        hiirenSijainti.x, hiirenSijainti.y)) {
                    liittyma.paivitaLauta();
                    blokus.lopetaVuoro();
                }


            } catch (Exception ex) {
            }
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
        hiirenSijainti = null;
        lauta.alustaVarjoLauta();
        liittyma.paivitaLauta();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        Point p = lauta.getSijainti(e.getPoint());
        if (!p.equals(hiirenSijainti)) {
            hiirenSijainti = p;
            paivitaVarjolautaa();

        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() > 0) {
            blokus.getVuorossa().getValittuna().kaannaOikeaan();
        } else {
            blokus.getVuorossa().getValittuna().kaannaVasempaan();
        }
        paivitaVarjolautaa();
    }

    private void paivitaVarjolautaa() {
        lauta.paivitaVarjoLautaa(blokus.getVuorossa().getValittuna(), hiirenSijainti.y, hiirenSijainti.x);
        liittyma.paivitaLauta();
    }
}