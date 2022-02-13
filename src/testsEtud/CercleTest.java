package testsEtud;

import exceptions.FormeException;
import formes.Cercle;
import org.junit.Before;
import org.junit.Test;

import static formes.Forme.MAX_VAL;
import static formes.Forme.MIN_VAL;
import static org.junit.Assert.*;

public class CercleTest {

    private static final int RAYON_DEFAUT = 10;
    private Cercle c1, c2, c3;

    @Before
    public void setUp() throws Exception {
        c1 = new Cercle(RAYON_DEFAUT);
        c2 = new Cercle(MIN_VAL);
        c3 = new Cercle(MAX_VAL);
    }

    @Test
    public void invalide() {
        try {
            new Cercle(MIN_VAL - 1);
            // Plus petit que minimum
            fail("Cercle invalide");
        } catch (FormeException ignored) {
        }

        try {
            new Cercle(MAX_VAL + 1);
            // Plus grand que maximum
            fail("Cercle invalide");
        } catch (FormeException ignored) {
        }
    }

    @Test
    public void calculerPerimetre() {
        assertEquals((int) (RAYON_DEFAUT * 2 * Math.PI), c1.calculerPerimetre(), 0);
        assertEquals((int) (MIN_VAL * 2 * Math.PI), c2.calculerPerimetre(), 0);
        assertEquals((int) (MAX_VAL * 2 * Math.PI), c3.calculerPerimetre(), 0);
    }

    @Test
    public void calculerSurface() {
        assertEquals((int) (Math.pow(RAYON_DEFAUT, 2) * Math.PI), c1.calculerSurface(), 0);
        assertEquals((int) (Math.pow(MIN_VAL, 2) * Math.PI), c2.calculerSurface(), 0);
        assertEquals((int) (Math.pow(MAX_VAL, 2) * Math.PI), c3.calculerSurface(), 0);
    }

    @Test
    public void getRayon() {
        assertEquals(RAYON_DEFAUT, c1.getRayon());
        assertEquals(MIN_VAL, c2.getRayon());
        assertEquals(MAX_VAL, c3.getRayon());
    }

    @Test
    public void setRayon() {
        c1.setRayon(MIN_VAL - 1);
        assertEquals(RAYON_DEFAUT, c1.getRayon());
        c2.setRayon(MAX_VAL + 1);
        c3.setRayon(3);

        assertEquals(1, c2.getRayon());
        assertEquals(3, c3.getRayon());
    }

    @Test
    public void testToString() {
        assertEquals("Cercle rouge 10", c1.toString());
        assertEquals("Cercle rouge 1", c2.toString());
        assertEquals("Cercle rouge 30", c3.toString());
    }
}