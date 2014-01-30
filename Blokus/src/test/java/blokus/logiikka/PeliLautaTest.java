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
        assertEquals(1, lauta.lauta[0][0]);
        assertEquals(2, lauta.lauta[0][19]);
        assertEquals(3, lauta.lauta[19][0]);
        assertEquals(4, lauta.lauta[19][19]);
    }
}
