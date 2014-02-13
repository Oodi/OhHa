package blokus.gui;

import blokus.conf.GlobaalitMuuttujat;
import blokus.gui.kuuntelijat.AntautumisKuuntelija;
import blokus.gui.kuuntelijat.LaattojenHiiriKuuntelija;
import blokus.gui.kuuntelijat.LaudanHiiriKuuntelija;
import blokus.gui.kuuntelijat.OhitaVuoroKuuntelija;
import blokus.logiikka.Blokus;
import blokus.logiikka.Pelaaja;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.image.BufferedImage;
import java.util.Queue;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Nimensä mukaisesti luo käyttöliittymän ja siihen tarvittavat komponentit.
 * Päivittää myös käyttöliittymää tarpeen mukaan.
 */
public class Kayttoliittyma extends JFrame {

    private JPanel paaPaneeli;
    private JPanel vasenPaneeli;
    private JPanel oikeaPaneeli;
    //
    private JPanel lautaPaneeli;
    private JLabel lautaLabel;
    private ImageIcon laudanKuva;
    //
    private JPanel laattaPaneeli;
    private JLabel laattaLabel;
    private ImageIcon laattaKuva;
    //
    private JPanel oikeaYlaPaneeli;
    private JLabel miniLaattaLabel1;
    private JLabel miniLaattaLabel2;
    private JLabel miniLaattaLabel3;
    private ImageIcon miniLaattaKuva1;
    private ImageIcon miniLaattaKuva2;
    private ImageIcon miniLaattaKuva3;
    //
    private JPanel oikeaKeskiPaneeli;
    //
    private JPanel oikeaAlaPaneeli;
    private TextArea tekstialue;
    private JButton ohitaVuoroNappi;
    private JButton antauduNappi;
    //
    private Blokus blokus;
    private Lauta lauta;
    private LaattaValitsin laatat;

    public Kayttoliittyma(Blokus blokus) {
        this.blokus = blokus;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        valmisteleKayttoliittyma();
    }

    private void valmisteleKayttoliittyma() {
        paaPaneeli = new JPanel();
        oikeaYlaPaneeli = new JPanel();
        oikeaKeskiPaneeli = new JPanel();
        oikeaAlaPaneeli = new JPanel();
        oikeaPaneeli = new JPanel();
        vasenPaneeli = new JPanel();

        lautaPaneeli = new JPanel();
        lautaPaneeli.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lauta = new Lauta(blokus.getPeliLauta(), GlobaalitMuuttujat.LAUDAN_RESOLUUTIO);
        laudanKuva = new ImageIcon(lauta.muodostaLaudastaKuva());
        lautaLabel = new JLabel(laudanKuva);
        LaudanHiiriKuuntelija kuuntelija = new LaudanHiiriKuuntelija(blokus, lauta, this);
        lautaLabel.addMouseListener(kuuntelija);
        lautaLabel.addMouseMotionListener(kuuntelija);
        lautaLabel.addMouseWheelListener(kuuntelija);
        lautaPaneeli.add(lautaLabel);

        laattaPaneeli = new JPanel();
        laattaPaneeli.setCursor(new Cursor(Cursor.HAND_CURSOR));
        laatat = new LaattaValitsin(blokus.getVuorossa().getLaatat());
        BufferedImage vKuva = laatat.muodostaValitsimestaKuva();
        laattaKuva = new ImageIcon(vKuva);
        laattaLabel = new JLabel(laattaKuva);
        LaattojenHiiriKuuntelija lKuuntelija = new LaattojenHiiriKuuntelija(blokus, laatat, this);
        laattaLabel.addMouseListener(lKuuntelija);
        laattaLabel.addMouseMotionListener(lKuuntelija);
        laattaPaneeli.add(laattaLabel);
        

        miniLaattaKuva1 = new ImageIcon(laatat.muodostaPieniValitsimestaKuva(blokus.getVuorossa().getLaatat()));
        miniLaattaKuva2 = new ImageIcon(laatat.muodostaPieniValitsimestaKuva(blokus.getVuorossa().getLaatat()));
        miniLaattaKuva3 = new ImageIcon(laatat.muodostaPieniValitsimestaKuva(blokus.getVuorossa().getLaatat()));
        miniLaattaLabel1 = new JLabel(miniLaattaKuva1);
        miniLaattaLabel2 = new JLabel(miniLaattaKuva2);
        miniLaattaLabel3 = new JLabel(miniLaattaKuva3);
        muodostaPienetValitsimet();
        JPanel paneeli1 = new JPanel();
        JPanel paneeli2 = new JPanel();
        JPanel paneeli3 = new JPanel();
        paneeli1.add(miniLaattaLabel1);
        paneeli2.add(miniLaattaLabel2);
        paneeli3.add(miniLaattaLabel3);
        oikeaYlaPaneeli.add(paneeli1);
        oikeaYlaPaneeli.add(paneeli2);
        oikeaYlaPaneeli.add(paneeli3);
        oikeaYlaPaneeli.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        oikeaYlaPaneeli.setLayout(new BoxLayout(oikeaYlaPaneeli, BoxLayout.PAGE_AXIS));
        
        oikeaKeskiPaneeli.setPreferredSize(new Dimension(200, 230));
        
        tekstialue = new TextArea();
        tekstialue.setEditable(false);
        tekstialue.setCursor(new Cursor(Cursor.HAND_CURSOR));
        tekstialue.setPreferredSize(new Dimension(200, 100));
        oikeaAlaPaneeli.add(tekstialue);

        ohitaVuoroNappi = new JButton("Ohita vuoro");
        ohitaVuoroNappi.setPreferredSize(new Dimension(120, 30));
        ohitaVuoroNappi.setAlignmentX(JButton.CENTER_ALIGNMENT);
        ohitaVuoroNappi.addActionListener(new OhitaVuoroKuuntelija(blokus, this));
        oikeaAlaPaneeli.add(ohitaVuoroNappi);

        antauduNappi = new JButton("Antaudu");
        antauduNappi.setPreferredSize(new Dimension(120, 30));
        antauduNappi.setAlignmentX(JButton.CENTER_ALIGNMENT);
        antauduNappi.addActionListener(new AntautumisKuuntelija(blokus, this));
        oikeaAlaPaneeli.add(antauduNappi);
        oikeaAlaPaneeli.setLayout(new BoxLayout(oikeaAlaPaneeli, BoxLayout.PAGE_AXIS));

        vasenPaneeli.add(lautaPaneeli);
        vasenPaneeli.add(laattaPaneeli);     
        vasenPaneeli.setLayout(new BoxLayout(vasenPaneeli, BoxLayout.PAGE_AXIS));
        
        oikeaPaneeli.add(oikeaYlaPaneeli);
        oikeaPaneeli.add(oikeaKeskiPaneeli);
        oikeaPaneeli.add(oikeaAlaPaneeli);
        oikeaPaneeli.setAlignmentY(JPanel.TOP_ALIGNMENT);
        oikeaPaneeli.setLayout(new BoxLayout(oikeaPaneeli, BoxLayout.PAGE_AXIS));

        paaPaneeli.add(vasenPaneeli);
        paaPaneeli.add(oikeaPaneeli);   
        getContentPane().add(paaPaneeli);
        
        pack();
        setResizable(false);
        setVisible(true);
    }

    public void paivitaLauta() {
        laudanKuva.setImage(lauta.muodostaLaudastaKuva());
        lautaLabel.repaint();
    }

    public void paivitaLaatat() {
        laattaKuva.setImage(laatat.muodostaValitsimestaKuva());
        laattaLabel.repaint();
    }

    public void vuoroVaihtuu() {
        laatat.setLaatat(blokus.getVuorossa().getLaatat());
        muodostaPienetValitsimet();
        paivitaLaatat();
        paivitaLauta();
    }

    private void muodostaPienetValitsimet() {
        Queue<Pelaaja> jono = blokus.getPelaajat();

        if (jono.size() == 3) {
            Pelaaja p1 = jono.poll();
            Pelaaja p2 = jono.poll();
            Pelaaja p3 = jono.poll();
            miniLaattaKuva1.setImage(laatat.muodostaPieniValitsimestaKuva(p1.getLaatat()));
            miniLaattaKuva2.setImage(laatat.muodostaPieniValitsimestaKuva(p2.getLaatat()));
            miniLaattaKuva3.setImage(laatat.muodostaPieniValitsimestaKuva(p3.getLaatat()));
            jono.add(p1);
            jono.add(p2);
            jono.add(p3);
        } else if (jono.size() == 2) {
            Pelaaja p1 = jono.poll();
            Pelaaja p2 = jono.poll();
            miniLaattaKuva1.setImage(laatat.muodostaPieniValitsimestaKuva(p1.getLaatat()));
            miniLaattaKuva2.setImage(laatat.muodostaPieniValitsimestaKuva(p2.getLaatat()));
            miniLaattaKuva3.setImage(laatat.muodostaTyhjaKuva());
            jono.add(p1);
            jono.add(p2);

        } else if (jono.size() == 1) {
            Pelaaja p1 = jono.poll();
            miniLaattaKuva1.setImage(laatat.muodostaPieniValitsimestaKuva(p1.getLaatat()));
            miniLaattaKuva2.setImage(laatat.muodostaTyhjaKuva());
            miniLaattaKuva3.setImage(laatat.muodostaTyhjaKuva());
            jono.add(p1);
        } else {
            miniLaattaKuva1.setImage(laatat.muodostaTyhjaKuva());
            miniLaattaKuva2.setImage(laatat.muodostaTyhjaKuva());
            miniLaattaKuva3.setImage(laatat.muodostaTyhjaKuva());
        }

        miniLaattaLabel1.repaint();
        miniLaattaLabel2.repaint();
        miniLaattaLabel3.repaint();

    }
}
