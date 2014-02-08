package blokus.gui;

import blokus.gui.kuuntelijat.LaudanHiiriKuuntelija;
import blokus.logiikka.Blokus;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Nimensä mukaisesti luo käyttöliittymän  ja siihen tarvittavat komponentit.
 * Päivittää myös käyttöliittymää tarpeen mukaan.
 */

public class Kayttoliittyma extends JFrame {

    private JPanel paaPaneeli;
    private JPanel lautaPaneeli;
    private JLabel label;
    private ImageIcon laudanKuva;   
    private Blokus blokus;
    private Lauta lauta;

    public Kayttoliittyma(Blokus blokus) {
        this.blokus = blokus;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        valmisteleKayttoliittyma();
    }

    private void valmisteleKayttoliittyma() {
        paaPaneeli = new JPanel();
        lautaPaneeli = new JPanel();
        lauta = new Lauta(blokus.getPeliLauta(), 800);
        BufferedImage kuva = lauta.muodostaLaudastaKuva();
        laudanKuva = new ImageIcon(kuva);
        label = new JLabel(laudanKuva);
        LaudanHiiriKuuntelija kuuntelija = new LaudanHiiriKuuntelija(blokus, lauta, this);
        label.addMouseListener(kuuntelija);
        label.addMouseMotionListener(kuuntelija);
        label.addMouseWheelListener(kuuntelija);

        lautaPaneeli.add(label);
        paaPaneeli.add(lautaPaneeli);
        getContentPane().add(paaPaneeli);
        pack();
        setVisible(true);
    }

    public void paivitaLauta() {
        laudanKuva.setImage(lauta.muodostaLaudastaKuva());
        label.repaint();
    }
}
