package testsEtud;

import formes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Antoine-Matis Boudreau
 */
public class FormeTest {
    private Forme t1, t2, t3;
    private Forme c1, c2, c3;
    private Forme r1, r2, r3;

    @Before
    public void setUp() {
        t1 = new Triangle(Forme.MIN_VAL, Forme.MIN_VAL, Forme.MIN_VAL);
        t2 = new Triangle(Forme.MAX_VAL, Forme.MAX_VAL, Forme.MAX_VAL);
        t3 = new Triangle(4,4,4);

        c1 = new Cercle(Forme.MIN_VAL);
        c2 = new Cercle(Forme.MAX_VAL);
        c3 = new Cercle(4);

        r1 = new Rectangle(Forme.MAX_VAL, Forme.MIN_VAL);
        r2 = new Rectangle(Forme.MIN_VAL, Forme.MAX_VAL);
        r3 = new Rectangle(4, 9);
    }

    @Test
    public void getNom() {
        assertEquals("Triangle", t1.getNom());
        assertEquals("Triangle", t2.getNom());
        assertEquals("Triangle", t3.getNom());

        assertEquals("Cercle", c1.getNom());
        assertEquals("Cercle", c2.getNom());
        assertEquals("Cercle", c3.getNom());

        assertEquals("Rectangle", r1.getNom());
        assertEquals("Rectangle", r2.getNom());
        assertEquals("Rectangle", r3.getNom());
    }

    @Test
    public void getCouleur() {
        assertEquals(Couleur.ROUGE,t1.getCouleur());
        assertEquals(Couleur.ROUGE,t2.getCouleur());
        assertEquals(Couleur.ROUGE,t3.getCouleur());

        assertEquals(Couleur.ROUGE,c1.getCouleur());
        assertEquals(Couleur.ROUGE,c2.getCouleur());
        assertEquals(Couleur.ROUGE,c3.getCouleur());

        assertEquals(Couleur.ROUGE,r1.getCouleur());
        assertEquals(Couleur.ROUGE,r2.getCouleur());
        assertEquals(Couleur.ROUGE,r3.getCouleur());
    }

    @Test
    public void setCouleur() {
        // Valide
        t1.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,t1.getCouleur());

        t2.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,t2.getCouleur());

        t3.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,t3.getCouleur());

        c1.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,c1.getCouleur());

        c2.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,c2.getCouleur());

        c3.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,c3.getCouleur());

        r1.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,r1.getCouleur());

        r2.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,r2.getCouleur());

        r3.setCouleur(Couleur.BLEU);
        assertEquals(Couleur.BLEU,r3.getCouleur());

        // Invalide
        t1.setCouleur(null);
        assertEquals(Couleur.BLEU, t1.getCouleur());
    }

    @Test
    public void compareTo() {
        t2.setCouleur(Couleur.VERT);
        t3.setCouleur(Couleur.ORANGE);

        c2.setCouleur(Couleur.NOIR);
        c3.setCouleur(Couleur.VERT);

        r2.setCouleur(Couleur.ORANGE);
        r3.setCouleur(Couleur.JAUNE);

        Forme[] mesForme = {t1,t2,t3,c1,c2,c3,r1,r2,r3}; // To test the sort behaviour

        Forme[] expectedResult = {c2,c1,c3,r3,r2,r1,t3,t1,t2};

        Arrays.sort(mesForme);

        assertEquals(expectedResult ,mesForme);
    }

    @Test
    public void testEquals() {
        assertNotEquals(null, t1); // Should not work
        assertNotEquals("Hello", t2); //Instance of checking
        // NotEquals use internally .equals() of the class

        assertNotEquals(t1,r1); // Not the same name nor surface 010
        ((Rectangle) r1).setHauteur(3);
        ((Rectangle) r1).setHauteur(3);
        assertNotEquals(c1, r1); // Not the same name only 011

        r1.setCouleur(Couleur.BLEU);
        assertNotEquals(c1, r1); // Not name, not color, same surface 001

        assertNotEquals(c1, c2); // Same name, same color 110

        t3.setCouleur(Couleur.BLEU);
        assertNotEquals(t1, t3); // Same name, not color, not surface 100

        r3.setCouleur(Couleur.BLEU);
        assertNotEquals(t1, r3); // Not the same at all 000

        ((Cercle)c1).setRayon(Forme.MAX_VAL);
        assertEquals(c1,c2);    // Same name, same color, same surface 111

        // Every possibility in the equals requirements are met.
    }

    @Test
    public void calculerSurface() {
        assertEquals(0, t1.calculerSurface());
        assertEquals(389, t2.calculerSurface());
        assertEquals(6, t3.calculerSurface());

        assertEquals(3,c1.calculerSurface());
        assertEquals(2827, c2.calculerSurface());
        assertEquals(50, c3.calculerSurface());

        assertEquals(30, r1.calculerSurface());
        assertEquals(30, r2.calculerSurface());
        assertEquals(36, r3.calculerSurface());
    }

    @Test
    public void calculerPerimetre() {
        assertEquals(Forme.MIN_VAL*3, t1.calculerPerimetre());
        assertEquals(Forme.MAX_VAL*3, t2.calculerPerimetre());
        assertEquals(4*3, t3.calculerPerimetre());

        assertEquals(6, c1.calculerPerimetre());
        assertEquals(188, c2.calculerPerimetre());
        assertEquals(25, c3.calculerPerimetre());

        assertEquals(62, r1.calculerPerimetre());
        assertEquals(62, r2.calculerPerimetre());
        assertEquals(26, r3.calculerPerimetre());
    }
}