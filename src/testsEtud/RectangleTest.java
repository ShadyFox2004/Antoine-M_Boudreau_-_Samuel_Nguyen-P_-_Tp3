package testsEtud;

import org.junit.Assert;
import org.junit.Test;

import exceptions.FormeException;
import formes.Rectangle;

public class RectangleTest 
{
    /**
     * Rectangle doit retourne une FormeException lorsque les parametre son invalide.
     */
    @Test
    public void testConstructeurInvalide()
    {
        Assert.assertThrows(FormeException.class, () -> {new Rectangle(32, 32);} );
    }

    /**
     * Perimetre doit retourne une valeur de 8 lorsque les attribus sont 2 et 2 
     */
    @Test
    public void testCalculerPerimetre()
    {
        Assert.assertEquals(8, new Rectangle(2,2).calculerPerimetre());
    }

    /**
     * Surface doit retourne une valeur de 4 lorsque les attribus sont 2 et 2;
     */
    @Test
    public void testCalculerSurface()
    {
        Assert.assertEquals(4, new Rectangle(2, 2).calculerSurface());
    }

    /**
     * Equals doit retourne vrai lorsque les deux objet comparer sont de meme couleur et surface;
     */
    @Test
    public void testEquals()
    {
        Rectangle a = new Rectangle(2, 6);
        Rectangle b = new Rectangle(3, 4);


        Assert.assertEquals(true, a.equals(b));
    }

    /**
     * Get couleur doit retourne la couleur rouge. 
     */
    @Test
    public void testGetCouleur()
    {
        Assert.assertEquals("rouge", new Rectangle(2, 2).getCouleur());
    }

    /**
     * Get hauteur doit retourne une valeur de 2
     */
    @Test
    public void testGetHauteur()
    {
        Assert.assertEquals(2, new Rectangle(2, 3).getHauteur());
    }

    /**
     * Get hauteur doit retourne une valeur de 3
     */
    @Test
    public void testGetLargeur()
    {
        Assert.assertEquals(3, new Rectangle(2, 3).getLargeur());
    }

    /**
     * Get nom doit retourne "Rectangle"
     */
     @Test
    public void testGetNom() 
    {
        Assert.assertEquals("Rectangle", new Rectangle(2, 2).getNom());
    }

    /**
     * Set couleur doit retourne la couleur rouge lorsque invalide
     */
    @Test
    public void testSetCouleurInvalide()
    {
        Rectangle o = new Rectangle(2,3);

        o.setCouleur("couleur");
        Assert.assertEquals("rouge", o.getCouleur());
    }

    /**
     * Set couleur valide doit assigner la couleur
     */
    @Test
    public void testSetCouleurValide()
    {
        Rectangle o = new Rectangle(2,3);

        o.setCouleur("bleu");
        Assert.assertEquals("bleu", o.getCouleur());
    }

    /**
     * toString  doit retourne:
     * Rectangle rouge 2, 2
     */
    @Test
    public void testToString()
    {
        Assert.assertEquals("Rectangle rouge 2, 2", new Rectangle(2, 2).toString());
    }
}
