package blokus.gui;

import blokus.conf.GlobaalitMuuttujat;
import blokus.gui.kuuntelijat.AntautumisKuuntelija;
import blokus.gui.kuuntelijat.LaattojenHiiriKuuntelija;
import blokus.gui.kuuntelijat.LaudanHiiriKuuntelija;
import blokus.gui.kuuntelijat.OhitaVuoroKuuntelija;
import blokus.logiikka.Blokus;
import blokus.logiikka.Pelaaja;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.image.BufferedImage;
import java.util.Queue;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultCaret;

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
    private Label pelaaja1Pisteet;
    private Label pelaaja2Pisteet;
    private Label pelaaja3Pisteet;
    private Label pelaaja4Pisteet;
    //
    private JPanel oikeaAlaPaneeli;
    private JTextArea tekstialue;
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




        oikeaKeskiPaneeli.setLayout(new GridLayout(5, 2));
        oikeaKeskiPaneeli.setBorder(new LineBorder(Color.BLACK));
        Label pelaaja1 = new Label("Sininen: ");
        pelaaja1Pisteet = new Label("" + blokus.getPelaajanPisteet(1));
        pelaaja1.setForeground(GlobaalitMuuttujat.SININEN);
        Label pelaaja2 = new Label("Oranssi: ");
        pelaaja2Pisteet = new Label("" + blokus.getPelaajanPisteet(1));
        pelaaja2.setForeground(GlobaalitMuuttujat.VIOLETTI);
        Label pelaaja3 = new Label("Punainen: ");
        pelaaja3Pisteet = new Label("" + blokus.getPelaajanPisteet(1));
        pelaaja3.setForeground(GlobaalitMuuttujat.PUNAINEN);
        Label pelaaja4 = new Label("Vihreä: ");
        pelaaja4Pisteet = new Label("" + blokus.getPelaajanPisteet(1));
        pelaaja4.setForeground(GlobaalitMuuttujat.VIHREA);
        Label pisteet = new Label("Pisteet: ");
        pisteet.setFont(new Font("test", Font.BOLD, 15));
        oikeaKeskiPaneeli.add(pisteet);
        oikeaKeskiPaneeli.add(new Label(""));
        oikeaKeskiPaneeli.add(pelaaja1);
        oikeaKeskiPaneeli.add(pelaaja1Pisteet);
        oikeaKeskiPaneeli.add(pelaaja2);
        oikeaKeskiPaneeli.add(pelaaja2Pisteet);
        oikeaKeskiPaneeli.add(pelaaja3);
        oikeaKeskiPaneeli.add(pelaaja3Pisteet);
        oikeaKeskiPaneeli.add(pelaaja4);
        oikeaKeskiPaneeli.add(pelaaja4Pisteet);
        oikeaKeskiPaneeli.setPreferredSize(new Dimension(190, 100));

        tekstialue = new JTextArea();
        tekstialue.setText("Peli alkaa. \nAloita omasta kulmastasi. "
                + "\nLaatta saa koskea vain kulmittain\njo asettamaasi laattaan nähden. "
                + "\nSe jolla on lopussa vähiten pisteitä voittaa pelin.\nOnnea peliin!");
        tekstialue.setEditable(false);

        oikeaAlaPaneeli.add(new Label("Tapahtumat: "));
        tekstialue.setWrapStyleWord(true);
        tekstialue.setLineWrap(true);
        JScrollPane scroll = new JScrollPane(tekstialue);
        scroll.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(190, 120));

        DefaultCaret caret = (DefaultCaret) tekstialue.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        
        oikeaAlaPaneeli.add(scroll);

        oikeaAlaPaneeli.add(Box.createRigidArea(new Dimension(0, 4)));
        JPanel napit = new JPanel();
        ohitaVuoroNappi = new JButton("Ohita vuoro");
        ohitaVuoroNappi.setPreferredSize(new Dimension(100, 30));
        ohitaVuoroNappi.setAlignmentX(JButton.CENTER_ALIGNMENT);
        ohitaVuoroNappi.addActionListener(new OhitaVuoroKuuntelija(blokus, this));
        napit.add(ohitaVuoroNappi);        
        
        antauduNappi = new JButton("Antaudu");
        antauduNappi.setPreferredSize(new Dimension(85, 30));
        antauduNappi.setAlignmentX(JButton.CENTER_ALIGNMENT);
        antauduNappi.addActionListener(new AntautumisKuuntelija(blokus, this));
        napit.add(antauduNappi);
        oikeaAlaPaneeli.add(napit);
        oikeaAlaPaneeli.setLayout(new BoxLayout(oikeaAlaPaneeli, BoxLayout.PAGE_AXIS));

        vasenPaneeli.add(lautaPaneeli);
        vasenPaneeli.add(laattaPaneeli);
        vasenPaneeli.setLayout(new BoxLayout(vasenPaneeli, BoxLayout.Y_AXIS));

        oikeaPaneeli.add(oikeaYlaPaneeli);
        oikeaPaneeli.add(Box.createRigidArea(new Dimension(0, 5)));
        oikeaPaneeli.add(oikeaKeskiPaneeli);
        oikeaPaneeli.add(Box.createRigidArea(new Dimension(0, 5)));
        oikeaPaneeli.add(oikeaAlaPaneeli);

        oikeaPaneeli.setLayout(new BoxLayout(oikeaPaneeli, BoxLayout.Y_AXIS));

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
        paivitaPisteTekstit();
        paivitaLaatat();
        paivitaLauta();
        lisaaTeksti("--------------------------------------------");
        lisaaTeksti(" On " + blokus.getVuorossa().getId() + ". pelaajan vuoro.");
    }

    public void lisaaTeksti(String teksti) {
        String nykyinen = tekstialue.getText();
        if (!teksti.isEmpty()) {
            tekstialue.setText(nykyinen + "\n-" + teksti);
        }
        
    }

    private void paivitaPisteTekstit() {
        pelaaja1Pisteet.setText("" + blokus.getPelaajanPisteet(1));
        pelaaja2Pisteet.setText("" + blokus.getPelaajanPisteet(2));
        pelaaja3Pisteet.setText("" + blokus.getPelaajanPisteet(3));
        pelaaja4Pisteet.setText("" + blokus.getPelaajanPisteet(4));

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
            miniLaattaKuva3.setImage(laatat.muodostaTyhjaKuva(getBackground()));
            jono.add(p1);
            jono.add(p2);

        } else if (jono.size() == 1) {
            Pelaaja p1 = jono.poll();
            miniLaattaKuva1.setImage(laatat.muodostaPieniValitsimestaKuva(p1.getLaatat()));
            miniLaattaKuva2.setImage(laatat.muodostaTyhjaKuva(getBackground()));
            miniLaattaKuva3.setImage(laatat.muodostaTyhjaKuva(getBackground()));
            jono.add(p1);
        } else {
            miniLaattaKuva1.setImage(laatat.muodostaTyhjaKuva(getBackground()));
            miniLaattaKuva2.setImage(laatat.muodostaTyhjaKuva(getBackground()));
            miniLaattaKuva3.setImage(laatat.muodostaTyhjaKuva(getBackground()));
        }

        miniLaattaLabel1.repaint();
        miniLaattaLabel2.repaint();
        miniLaattaLabel3.repaint();

    }
}
