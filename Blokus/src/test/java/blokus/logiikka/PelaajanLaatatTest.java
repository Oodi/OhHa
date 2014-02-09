
package blokus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PelaajanLaatatTest {
    
    PelaajanLaatat laatat;
    
    public PelaajanLaatatTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        laatat = new PelaajanLaatat(1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void alustusToimii() {
        
        assertEquals(21, laatat.getJaljellaLaatat().size());
        assertEquals(0, laatat.getPelatutLaatat().size());
    }
}
