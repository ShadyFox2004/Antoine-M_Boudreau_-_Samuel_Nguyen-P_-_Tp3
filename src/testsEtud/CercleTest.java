package testsEtud;

import org.junit.Assert;
import org.junit.Test;

import exceptions.FormeException;
import formes.Cercle;

public class CercleTest
{
    /**
     * Cercle doit retourne une FormeException lorsque les parametre sont invalide.
     */
    @Test
    public void testConstructeurInvalide()
    {
        Assert.assertThrows(FormeException.class, () -> {new Cercle(32);} );
    }

    /**
     * Perimetre doit retourne une valeur de
     */
    @Test
    public void testCalculerPerimetre()
    {
    }

    /**
     * Surface doit retourne une valeur 
     */
    @Test
    public void testCalculerSurface()
    {
        // TODO
    }

    /**
     * Equals doit retourne vrai lorsque les deux objet comparer sont de meme couleur et surface;
     */
    @Test
    public void testEquals()
    {
        Cercle a = new Cercle(2);
        Cercle b = new Cercle(2);


        Assert.assertEquals(true, a.equals(b));
    }

    @Test
    public void testGetCouleur()
    {

    }

    @Test
    public void testGetNom()
    {

    }

    @Test
    public void testGetRayon()
    {

    }

    @Test
    public void testMain()
    {

    }

    @Test
    public void testSetCouleur()
    {

    }

    @Test
    public void testSetRayon()
    {

    }

    @Test
    public void testToString()
    {

    }
}
