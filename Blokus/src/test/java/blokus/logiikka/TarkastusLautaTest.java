package blokus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TarkastusLautaTest {

    TarkastusLauta testi;
    Laatta laatta;

    public TarkastusLautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        testi = new TarkastusLauta(1);
        int[][] malli2 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 2, 3, 3, 2, 0, 0},
            {0, 1, 2, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        laatta = new Laatta(2, malli2, 2, 1);
    }

    @After
    public void tearDown() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void alustusToimii() {
        assertEquals(1, testi.tLauta[0][0]);
        assertEquals(2, testi.tLauta[0][19]);
        assertEquals(2, testi.tLauta[19][0]);
        assertEquals(2, testi.tLauta[19][19]);
    }

    @Test
    public void laudanOhiEiVoiLisata() {
        assertFalse(testi.tarkistaVoikoLisata(laatta, 0, -1));
        assertFalse(testi.tarkistaVoikoLisata(laatta, 0, 0));
        assertFalse(testi.tarkistaVoikoLisata(laatta, -1, 3));
        assertFalse(testi.tarkistaVoikoLisata(laatta, 20, 20));
        assertFalse(testi.tarkistaVoikoLisata(laatta, 0, 20));
    }

    @Test
    public void minneSattuuEiVoiLisata() {
        assertFalse(testi.tarkistaVoikoLisata(laatta, 13, 13));
        assertFalse(testi.tarkistaVoikoLisata(laatta, 0, 19));
        assertFalse(testi.tarkistaVoikoLisata(laatta, 19, 1));
        assertFalse(testi.tarkistaVoikoLisata(laatta, 19, 19));
        assertFalse(testi.tarkistaVoikoLisata(laatta, 7, 13));
    }

    @Test
    public void laudalleVoiLisata() {
        assertTrue(testi.tarkistaVoikoLisata(laatta, 0, 1));
        testi.lisaaLaatta(1, 9, 9);
        assertTrue(testi.tarkistaVoikoLisata(laatta, 9, 9));
        testi.lisaaLaatta(1, 7, 7);
        testi.lisaaLaatta(1, 7, 6);
        assertTrue(testi.tarkistaVoikoLisata(laatta, 7, 7));
    }
    
    
}
