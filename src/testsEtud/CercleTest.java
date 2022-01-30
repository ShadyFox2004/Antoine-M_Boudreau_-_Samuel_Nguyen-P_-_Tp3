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
        Assert.assertThrows(FormeException.class, () ->
        {
            new Cercle(32);
        });
    }

    /**
     * Perimetre doit retourne une valeur de 25 lorsque le rayon est 4
     */
    @Test
    public void testCalculerPerimetre()
    {
        Assert.assertEquals(25, new Cercle(4).calculerPerimetre());
    }

    /**
     * Surface doit retourne une valeur 50 lorsque le rayon est de 4
     */
    @Test
    public void testCalculerSurface()
    {
        Assert.assertEquals(50, new Cercle(4).calculerSurface());
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

    /**
     * Get couleur doit retourne une valeur vert lorsque le cercle est par defaut
     */
    @Test
    public void testGetCouleur()
    {
        Assert.assertEquals("vert", new Cercle().getCouleur());
    }

    /**
     * Le nom retourne doit etre "Cercle"
     */
    @Test
    public void testGetNom()
    {
        Assert.assertEquals("Cercle", new Cercle().getNom());
    }

    /**
     * Le rayon par defaut doit etre 10
     */
    @Test
    public void testGetRayon()
    {
        Assert.assertEquals(10, new Cercle().getRayon());
    }

    /**
     * J'ai aucune idee pourquoi il y a un main ici
     */
    @Test
    public void testMain()
    {
    }


    /**
     * Set couleur doit assgner la couleur par defaut lorsque invalide.
     */
    @Test
    public void testSetCouleurInvalide()
    {
        Cercle o = new Cercle();

        o.setCouleur("Ble u");
        Assert.assertEquals("vert", o.getCouleur());
    }

    /**
     * setCouleur doit assigner la couleur loursqu'elle est valide.
     */
    @Test
    public void testSetCouleurValide()
    {
        Cercle o = new Cercle();

        o.setCouleur("  BleU      ");
        Assert.assertEquals("bleu", o.getCouleur());
    }

    /**
     * setRayon doit assigner le rayon.
     */
    @Test
    public void testSetRayon()
    {
        Cercle o = new Cercle();

        o.setRayon(20);
        Assert.assertEquals(20, o.getRayon());
    }

    /**
     * Doit retourne un message sous cette forme:
     * nom couleur rayon
     * Ex: Cercle vert 10
     */
    @Test
    public void testToString()
    {
        Assert.assertEquals("Cercle vert 10", new Cercle().toString());
    }
}
