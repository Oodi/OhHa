package blokus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliLautaTest {

    PeliLauta lauta;
    Laatta laatta;

    public PeliLautaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lauta = new PeliLauta();
            int[][]    malli1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        laatta = new Laatta(1, malli1, 1, 1);
        TarkastusLauta tar = new TarkastusLauta(1);
        lauta.lisaaTarkastusLauta(1, tar);
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
        int[][] arr = lauta.getLauta();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                assertEquals(0, arr[i][j]);

            }

        }
    }

    @Test
    public void onkoLaudallatoimii() {
        assertTrue(lauta.onkoLaudalla(9, 9, 3, 3));
        assertFalse(lauta.onkoLaudalla(0, 0, 2, 3));
        assertFalse(lauta.onkoLaudalla(29, 29, 2, 3));
    }

    @Test
    public void laatanLisaysToimii() {
        assertFalse(lauta.lisaaLaattaLaudalle(1, laatta, -1, 0));
        assertTrue(lauta.lisaaLaattaLaudalle(1, laatta, 0, 0));
    }
}
