package testsEtud;

import exceptions.FormeException;
import formes.Couleur;
import formes.Rectangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class RectangleTest {
    private Rectangle r1, r2, r3, r4, r5, r6, r7, r8, r9;

    @Before
    public void setUp() {
        r1 = new Rectangle(Rectangle.MIN_VAL, Rectangle.MIN_VAL);
        r2 = new Rectangle(Rectangle.MIN_VAL, 13);
        r3 = new Rectangle(Rectangle.MIN_VAL, Rectangle.MAX_VAL);

        r4 = new Rectangle(13, Rectangle.MIN_VAL);
        r5 = new Rectangle(15, 23);
        r6 = new Rectangle(9, Rectangle.MAX_VAL);

        r7 = new Rectangle(Rectangle.MAX_VAL, Rectangle.MIN_VAL);
        r8 = new Rectangle(Rectangle.MAX_VAL, 22);
        r9 = new Rectangle(Rectangle.MAX_VAL, Rectangle.MAX_VAL);
    }

    @Test
    public void invalide() {
        try {
            new Rectangle(Rectangle.MIN_VAL - 1, Rectangle.MIN_VAL - 1);
            fail("Rectangle invalide");
        } catch (FormeException ignored) {
        }

        try {
            new Rectangle(Rectangle.MIN_VAL - 1, 12);
            fail("Rectangle invalide");
        } catch (FormeException ignored) {
        }

        try {
            new Rectangle(Rectangle.MIN_VAL - 1, Rectangle.MAX_VAL + 1);
            fail("Rectangle invalide");
        } catch (FormeException ignored) {
        }

        try {
            new Rectangle(19, Rectangle.MIN_VAL - 1);
            fail("Rectangle invalide");
        } catch (FormeException ignored) {
        }

        try {
            new Rectangle(34, Rectangle.MAX_VAL + 1);
            fail("Rectangle invalide");
        } catch (FormeException ignored) {
        }

        try {
            new Rectangle(Rectangle.MAX_VAL + 1, Rectangle.MIN_VAL - 1);
            fail("Rectangle invalide");
        } catch (FormeException ignored) {
        }

        try {
            new Rectangle(Rectangle.MAX_VAL + 1, 12);
            fail("Rectangle invalide");
        } catch (FormeException ignored) {
        }

        try {
            new Rectangle(Rectangle.MAX_VAL + 1, Rectangle.MAX_VAL + 1);
            fail("Rectangle invalide");
        } catch (FormeException ignored) {
        }
    }

    @Test
    public void calculerPerimetre() {
        assertEquals(Rectangle.MIN_VAL*4, r1.calculerPerimetre());
        assertEquals(Rectangle.MIN_VAL*2 + 13*2, r2.calculerPerimetre());
        assertEquals(Rectangle.MIN_VAL*2 + Rectangle.MAX_VAL*2, r3.calculerPerimetre());

        assertEquals(13*2 + Rectangle.MIN_VAL*2, r4.calculerPerimetre());
        assertEquals(15*2 + 23*2, r5.calculerPerimetre());
        assertEquals(9*2 + Rectangle.MAX_VAL*2, r6.calculerPerimetre());

        assertEquals(r3.calculerPerimetre(), r7.calculerPerimetre());
        assertEquals(Rectangle.MAX_VAL*2 + 22*2, r8.calculerPerimetre());
        assertEquals(Rectangle.MAX_VAL*4, r9.calculerPerimetre());
    }

    @Test
    public void calculerSurface() {
        assertEquals(Rectangle.MIN_VAL*Rectangle.MIN_VAL, r1.calculerSurface());
        assertEquals(Rectangle.MIN_VAL*13, r2.calculerSurface());
        assertEquals(Rectangle.MIN_VAL*Rectangle.MAX_VAL, r3.calculerSurface());

        assertEquals(r2.calculerSurface(),r4.calculerSurface());
        assertEquals(15*23, r5.calculerSurface());
        assertEquals(9*Rectangle.MAX_VAL, r6.calculerSurface());

        assertEquals(r3.calculerSurface(), r7.calculerSurface());
        assertEquals(Rectangle.MAX_VAL*22, r8.calculerSurface());
        assertEquals(Rectangle.MAX_VAL*Rectangle.MAX_VAL, r9.calculerSurface());
    }

    @Test
    public void getHauteur() {
        assertEquals(Rectangle.MIN_VAL, r1.getHauteur());
        assertEquals(r1.getHauteur(), r2.getHauteur());
        assertEquals(r2.getHauteur(), r3.getHauteur());

        assertEquals(13, r4.getHauteur());
        assertEquals(15, r5.getHauteur());
        assertEquals(9, r6.getHauteur());

        assertEquals(Rectangle.MAX_VAL, r7.getHauteur());
        assertEquals(r7.getHauteur(), r8.getHauteur());
        assertEquals(r8.getHauteur(), r9.getHauteur());
    }

    @Test
    public void getLargeur() {
        assertEquals(Rectangle.MIN_VAL, r1.getLargeur());
        assertEquals(13, r2.getLargeur());
        assertEquals(Rectangle.MAX_VAL, r3.getLargeur());

        assertEquals(r1.getLargeur(), r4.getLargeur());
        assertEquals(23, r5.getLargeur());
        assertEquals(r3.getLargeur(), r6.getLargeur());

        assertEquals(r4.getLargeur(), r7.getLargeur());
        assertEquals(22, r8.getLargeur());
        assertEquals(r6.getLargeur(), r9.getLargeur());
    }

    @Test
    public void setHauteur() {
        r1.setHauteur(Rectangle.MIN_VAL - 1);
        assertEquals(Rectangle.MIN_VAL, r1.getHauteur());
        r2.setHauteur(Rectangle.MAX_VAL + 1);
        assertEquals(Rectangle.MIN_VAL, r2.getHauteur());
        r3.setHauteur(Rectangle.MAX_VAL);
        assertEquals(Rectangle.MAX_VAL, r3.getHauteur());

        r4.setHauteur(Rectangle.MIN_VAL);
        assertEquals(Rectangle.MIN_VAL, r4.getHauteur());
        r5.setHauteur(17);
        assertEquals(17, r5.getHauteur());
        r6.setHauteur(4);
        assertEquals(4, r6.getHauteur());

        r7.setHauteur(Rectangle.MAX_VAL + 3);
        assertEquals(Rectangle.MAX_VAL, r7.getHauteur());
        r8.setHauteur(Rectangle.MIN_VAL - 15);
        assertEquals(Rectangle.MAX_VAL, r8.getHauteur());
        r9.setHauteur(17);
        assertEquals(r5.getHauteur(), r9.getHauteur());
    }

    @Test
    public void setLargeur() {
        r1.setLargeur(Rectangle.MIN_VAL - 1);
        assertEquals(Rectangle.MIN_VAL, r1.getLargeur());
        r2.setLargeur(Rectangle.MAX_VAL + 1);
        assertEquals(13, r2.getLargeur());
        r3.setLargeur(Rectangle.MAX_VAL);
        assertEquals(Rectangle.MAX_VAL, r3.getLargeur());

        r4.setLargeur(Rectangle.MIN_VAL);
        assertEquals(Rectangle.MIN_VAL, r4.getLargeur());
        r5.setLargeur(17);
        assertEquals(17, r5.getLargeur());
        r6.setLargeur(4);
        assertEquals(4, r6.getLargeur());

        r7.setLargeur(Rectangle.MAX_VAL + 3);
        assertEquals(Rectangle.MIN_VAL, r7.getLargeur());
        r8.setLargeur(Rectangle.MIN_VAL - 15);
        assertEquals(22, r8.getLargeur());
        r9.setLargeur(17);
        assertEquals(r5.getLargeur(), r9.getLargeur());
    }

    @Test
    public void testToString() {
        assertEquals("Rectangle rouge 1, 1", r1.toString());
        assertEquals("Rectangle rouge 1, 13",r2.toString());
        assertEquals("Rectangle rouge 1, 30", r3.toString());
        assertEquals("Rectangle rouge 13, 1", r4.toString());
    }

    @Test
    public void testEquals() {
        assertNotEquals(null, r1);
        assertNotEquals(r2, new Object());
        assertEquals(r3, r7);
        r4.setCouleur(Couleur.BLEU);
        assertNotEquals(r4, r2);
        assertNotEquals(r5, r4);
        assertNotEquals(r1, r9);
    }
}