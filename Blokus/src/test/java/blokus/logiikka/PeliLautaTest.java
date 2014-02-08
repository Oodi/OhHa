package blokus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PeliLautaTest {

    PeliLauta lauta;

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
    }
}
