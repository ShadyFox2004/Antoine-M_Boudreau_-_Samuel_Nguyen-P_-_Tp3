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

    @Test
    public void testGetCouleur() {

    }

    @Test
    public void testGetHauteur() {

    }

    @Test
    public void testGetLargeur() {

    }

    @Test
    public void testGetNom() {

    }

    @Test
    public void testSetCouleur() {

    }

    @Test
    public void testSetHauteur() {

    }

    @Test
    public void testSetLargeur() {

    }

    @Test
    public void testToString() {

    }
}
