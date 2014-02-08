package blokus.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaattaTest {

    Laatta laatta1;
    Laatta laatta21;
    int[][] malli1;
    int[][] malli21;

    public LaattaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        malli1 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        laatta1 = new Laatta(1, malli1, 1, 1);

        malli21 = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 2, 1, 0, 0, 0},
            {1, 2, 3, 2, 2, 1, 0},
            {2, 3, 3, 3, 3, 2, 0},
            {1, 2, 2, 2, 2, 1, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        laatta21 = new Laatta(1, malli21, 1, 2);
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
    public void YksinkertainenLaattaKaantoOikeaanTest() {
        laatta1.kaannaOikeaan();
        assertArrayEquals(malli1, laatta1.getMuoto());
    }

    @Test
    public void YksinkertainenLaattaKaantoVasempaanTest() {
        laatta1.kaannaVasempaan();
        assertArrayEquals(malli1, laatta1.getMuoto());
    }

    @Test
    public void YksinkertainenLaattaKaantoYmpariTest() {
        laatta1.kaannaYmpari();
        assertArrayEquals(malli1, laatta1.getMuoto());
    }

    @Test
    public void MonimutkainenLaattaKaantoOikeaanTest() {
        laatta21.kaannaOikeaan();
        int[][] kaannos = new int[][]{
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 2, 3, 2, 1, 0},
            {0, 0, 2, 3, 3, 2, 0},
            {0, 0, 2, 3, 2, 1, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        assertArrayEquals(kaannos, laatta21.getMuoto());
    }

    @Test
    public void MonimutkainenLaattaKaantoVasempaanTest() {
        laatta21.kaannaVasempaan();
        int[][] kaannos = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 2, 1, 0, 0},
            {0, 0, 2, 3, 2, 0, 0},
            {0, 1, 2, 3, 2, 0, 0},
            {0, 2, 3, 3, 2, 0, 0},
            {0, 1, 2, 3, 2, 0, 0},
            {0, 0, 1, 2, 1, 0, 0}
        };
        assertArrayEquals(laatta21.getMuoto(), kaannos);
    }

    @Test
    public void MonimutkainenLaattaKaantoYmpariTest() {
        laatta21.kaannaYmpari();
        int[][] kaannos = new int[][]{
            {0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0},
            {1, 2, 2, 2, 2, 1, 0},
            {2, 3, 3, 3, 3, 2, 0},
            {1, 2, 3, 2, 2, 1, 0},
            {0, 1, 2, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0}
        };
        assertArrayEquals(laatta21.getMuoto(), kaannos);

    }
    

}
