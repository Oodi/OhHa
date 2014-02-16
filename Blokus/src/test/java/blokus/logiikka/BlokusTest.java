package blokus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BlokusTest {

    Blokus blokus;

    public BlokusTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        blokus = new Blokus();
        blokus.aloitaVuoro();
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void pelaajiaOikeaMaaraJaYksiVuorossa() {
        assertEquals(3, blokus.getPelaajat().size());
        assertTrue(blokus.getVuorossa() != null);
    }

    @Test
    public void vuoronLoppumisenJalkeenSamanverranPelaajiaJonossa() {
        blokus.lopetaVuoro(false, false);
        assertEquals(3, blokus.getPelaajat().size());
        assertTrue(blokus.getVuorossa() != null);
    }

    @Test
    public void pelaajiaVastaaOikeaMaaraTarkastusLautoja() {

        assertEquals(4, blokus.getPeliLauta().getTarkastusLaudat().size());

    }

    @Test
    public void varilleLoytyyTekstit() {

        assertEquals("Sininen", blokus.getIDVariTekstina(1));
        assertEquals("Oranssi", blokus.getIDVariTekstina(2));
        assertEquals("Punainen", blokus.getIDVariTekstina(3));
        assertEquals("Vihreä", blokus.getIDVariTekstina(4));

    }
}
