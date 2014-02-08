package blokus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        blokus.lopetaVuoro();
        assertEquals(3, blokus.getPelaajat().size());
        assertTrue(blokus.getVuorossa() != null);
    }

    @Test
    public void pelaajiaVastaaOikeaMaaraTarkastusLautoja() {
        
        assertEquals(4, blokus.getPeliLauta().getTarkastusLaudat().size());
        
    }
}
