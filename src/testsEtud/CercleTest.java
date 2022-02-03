package testsEtud;

import exceptions.FormeException;
import formes.Cercle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CercleTest
{
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 30;

    private Cercle c1, c2, c3, c4;

    @Before
    public void setUp() throws Exception
    {
        c1 = new Cercle();
        c2 = new Cercle(1);
        c3 = new Cercle(30);
        c4 = new Cercle(10);
    }

    @Test
    public void invalide()
    {
        try
        {
            new Cercle(1 - 1);
            // Plus petit que minimum
            fail("Carte invalide");
        } catch (FormeException e)
        {
        }

        try
        {
            new Cercle(30 + 1);
            // Plus grand que maximum
            fail("Carte invalide");
        } catch (FormeException e)
        {
        }
    }

    @Test
    public void calculerPerimetre()
    {
        assertEquals((int) (10 * 2 * Math.PI), c1.calculerPerimetre(), 0);
        assertEquals((int) (1 * 2 * Math.PI), c2.calculerPerimetre(), 0);
        assertEquals((int) (30 * 2 * Math.PI), c3.calculerPerimetre(), 0);
        assertEquals((int) (10 * 2 * Math.PI), c4.calculerPerimetre(), 0);
    }

    @Test
    public void calculerSurface()
    {
        assertEquals((int) (Math.pow(10, 2) * Math.PI), c1.calculerSurface(), 0);
        assertEquals((int) (Math.pow(1, 2) * Math.PI), c2.calculerSurface(), 0);
        assertEquals((int) (Math.pow(30, 2) * Math.PI), c3.calculerSurface(), 0);
        assertEquals((int) (Math.pow(10, 2) * Math.PI), c4.calculerSurface(), 0);
    }

    @Test
    public void testEquals()
    {
        assertFalse(c1.equals(null));
        assertFalse(c2.equals("Cercle"));

        assertFalse(c1.equals(c2));
        c4.setCouleur("bleu");
        assertFalse(c1.equals(c4));
        assertFalse(c1.equals(c2));
        c3.setCouleur("orange");
        assertFalse(c1.equals(c3));
        
        c4.setCouleur(c1.getCouleur());
        assertTrue(c1.equals(c4));
    }

    @Test
    public void getCouleur()
    {
        assertEquals("vert", c1.getCouleur());
        assertEquals("vert", c2.getCouleur());
        assertEquals("vert", c3.getCouleur());
        assertEquals("vert", c4.getCouleur());
    }

    @Test
    public void getNom()
    {
        assertEquals("Cercle", c1.getNom());
        assertEquals("Cercle", c2.getNom());
        assertEquals("Cercle", c3.getNom());
        assertEquals("Cercle", c4.getNom());
    }

    @Test
    public void getRayon()
    {
        assertEquals(10, c1.getRayon());
        assertEquals(1, c2.getRayon());
        assertEquals(30, c3.getRayon());
        assertEquals(10, c4.getRayon());
    }

    @Test
    public void setCouleur()
    {
        c1.setCouleur("rouge");
        c2.setCouleur(" orange ");
        c3.setCouleur(" NoIR ");
        
        c4.setCouleur("blanc");

        assertEquals("rouge", c1.getCouleur());
        assertEquals("orange", c2.getCouleur());
        assertEquals("noir", c3.getCouleur());
        assertEquals("vert", c4.getCouleur());

    }

    @Test
    public void setRayon()
    {
        c1.setRayon(0);
        assertEquals(10, c1.getRayon());
        c2.setRayon(30+1);
        c3.setRayon(3);
        c4.setRayon(23);
        

        assertEquals(1, c2.getRayon());
        assertEquals(3, c3.getRayon());
        assertEquals(23, c4.getRayon());
    }

    @Test
    public void testToString()
    {
        assertEquals("Cercle vert 10", c1.toString());
        assertEquals("Cercle vert 1", c2.toString());
        assertEquals("Cercle vert 30", c3.toString());
        c4.setCouleur("bleu");
        assertEquals("Cercle bleu 10", c4.toString());
    }
}