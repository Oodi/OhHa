package blokus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja pelaaja1;

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        pelaaja1 = new Pelaaja(1);
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
    public void pisteetOikeinAlussa() {
        assertEquals(89, pelaaja1.getPisteet());
    }

    @Test
    public void vaihtaminenToimii() {
        pelaaja1.vaihdaValittuaLaattaa(0, 3);    
        assertEquals(1, pelaaja1.getValittuna().getId());
        pelaaja1.vaihdaValittuaLaattaa(0, 0);    
        assertEquals(1, pelaaja1.getValittuna().getId());
    }
}
