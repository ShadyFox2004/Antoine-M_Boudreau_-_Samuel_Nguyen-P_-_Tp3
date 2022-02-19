package testsEtud;

import exceptions.FormeException;
import formes.Forme;
import formes.Triangle;
import formes.TypeTriangle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * @author Antoine-Matis Boudreau
 */
public class TriangleTest {

    private Triangle t1, t2, t3, t4, t5, t6, t7, t8;

    @Before
    public void setUp() {
        t1 = new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL); // All-in-one MIN
        t2 = new Triangle(Forme.MAX_VAL, Forme.MAX_VAL, Forme.MAX_VAL); // All-in-one MAX

        t3 = new Triangle(Forme.MIN_VAL, Forme.MAX_VAL, Forme.MAX_VAL);
        t4 = new Triangle(Forme.MAX_VAL, Forme.MIN_VAL, Forme.MAX_VAL);
        t5 = new Triangle(Forme.MAX_VAL, Forme.MAX_VAL, Forme.MIN_VAL);

        t6 = new Triangle(4, 3, 3);
        t7 = new Triangle(12, 5, 13);
        // SCALENE
        t8 = new Triangle(Forme.MAX_VAL - 1, Forme.MAX_VAL / 2 + 1, Forme.MAX_VAL); // Extreme de estTriangle
    }

    @Test
    public void invalide() {
        try {
            new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, 2); // Invalide non possible
            fail("Triangle non possible");
        } catch (FormeException ignored) {
        }

        try {
            new Triangle(Forme.MIN_VAL, 2, Forme.MIN_VAL); // Invalide non possible
            fail("Triangle non possible");
        } catch (FormeException ignored) {
        }

        try {
            new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MAX_VAL); // Invalide non possible
            fail("Triangle non possible");
        } catch (FormeException ignored) {
        }

        try {
            new Triangle(Forme.MIN_VAL, 6, Forme.MIN_VAL); // non possible
            fail("Triangle non possible");
        } catch (FormeException ignored) {
        }

        try {
            new Triangle(4, 2, 2); // Non possible
            fail("Triangle non possible");
        } catch (FormeException ignored) {
        }

        // Extreme min - 1
        try {
            new Triangle(Forme.MIN_VAL - 1, 2, 2); // plus petit que min A
            fail("Triangle plus petit que min -> A");
        } catch (FormeException ignored) {
        }

        try {
            new Triangle(2, Forme.MIN_VAL - 1, 2); // plus petit que min B
            fail("Triangle plus petit que min -> B");
        } catch (FormeException ignored) {
        }

        try {
            new Triangle(2 - 1, 2, Forme.MIN_VAL); // plus petit que min B
            fail("Triangle plus petit que min -> C");
        } catch (FormeException ignored) {
        }

        // Extreme Max - 1
        try {
            new Triangle(Forme.MAX_VAL + 1, Forme.MAX_VAL, Forme.MAX_VAL); // plus grand que max A
            fail("Triangle plus petit que min -> A");
        } catch (FormeException ignored) {
        }

        try {
            new Triangle(Forme.MAX_VAL, Forme.MAX_VAL + 1, Forme.MAX_VAL); // plus grand que max B
            fail("Triangle plus petit que max -> B");
        } catch (FormeException ignored) {
        }

        try {
            new Triangle(Forme.MAX_VAL, Forme.MAX_VAL + 1, Forme.MAX_VAL); // plus grand que max C
            fail("Triangle plus petit que max -> C");
        } catch (FormeException ignored) {
        }
    }

    @Test
    public void getCoteA() {
        assertEquals(Forme.MIN_VAL, t1.getCoteA());
        assertEquals(Forme.MAX_VAL, t2.getCoteA());

        assertEquals(Forme.MIN_VAL, t3.getCoteA());
        assertEquals(Forme.MAX_VAL, t4.getCoteA());
        assertEquals(Forme.MAX_VAL, t5.getCoteA());

        assertEquals(4, t6.getCoteA());
        assertEquals(12, t7.getCoteA());
        assertEquals(Forme.MAX_VAL - 1, t8.getCoteA());
    }

    @Test
    public void getCoteB() {
        assertEquals(Forme.MIN_VAL, t1.getCoteB());
        assertEquals(Forme.MAX_VAL, t2.getCoteB());

        assertEquals(Forme.MAX_VAL, t3.getCoteB());
        assertEquals(Forme.MIN_VAL, t4.getCoteB());
        assertEquals(Forme.MAX_VAL, t5.getCoteB());

        assertEquals(3, t6.getCoteB());
        assertEquals(5, t7.getCoteB());
        assertEquals(Forme.MAX_VAL / 2 + 1, t8.getCoteB());
    }

    @Test
    public void getCoteC() {
        assertEquals(Forme.MIN_VAL, t1.getCoteC());
        assertEquals(Forme.MAX_VAL, t2.getCoteC());

        assertEquals(Forme.MAX_VAL, t3.getCoteC());
        assertEquals(Forme.MAX_VAL, t4.getCoteC());
        assertEquals(Forme.MIN_VAL, t5.getCoteC());

        assertEquals(3, t6.getCoteC());
        assertEquals(13, t7.getCoteC());
        assertEquals(Forme.MAX_VAL, t8.getCoteC());
    }

    @Test
    public void getType() {
        assertEquals(TypeTriangle.EQUILATERAL, t1.getType());
        assertEquals(TypeTriangle.EQUILATERAL, t2.getType());

        assertEquals(TypeTriangle.ISOCELE, t3.getType());
        assertEquals(TypeTriangle.ISOCELE, t4.getType());
        assertEquals(TypeTriangle.ISOCELE, t5.getType());

        assertEquals(TypeTriangle.ISOCELE, t6.getType());
        assertEquals(TypeTriangle.RECTANGLE, t7.getType());
        assertEquals(TypeTriangle.SCALENE, t8.getType());
    }

    @Test
    public void testToString() {
        assertEquals("Triangle rouge équilatéral 1, 1, 1", t1.toString());
        assertEquals("Triangle rouge équilatéral 30, 30, 30", t2.toString());
        assertEquals("Triangle rouge isocèle 1, 30, 30", t3.toString());
        assertEquals("Triangle rouge isocèle 30, 1, 30", t4.toString());
        assertEquals("Triangle rouge isocèle 30, 30, 1", t5.toString());
        assertEquals("Triangle rouge isocèle 4, 3, 3", t6.toString());
        assertEquals("Triangle rouge rectangle 12, 5, 13", t7.toString());
        assertEquals("Triangle rouge scalène 29, 16, 30", t8.toString());
    }
}