package tests;

import formes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Classe de test des vecteur:
 * Spécification de l'api public.
 * @author Antoine-Matis Boudreau
 */
public class VecteurFormeTest {
    private VecteurFormes v1;


    @Before
    /**
     * Test du constructeur.
     */
    public void setUp() {
        v1 = new VecteurFormes();
        // TODO Determiner les specification de l'object
        // Le constructeur ne leve pas d'exception
        // donc aucun test d'invalidité n'est requis.
    }

    @Test
    public void getVecteur() {
        // TODO Doit donner une array
    }

    @Test
    public void melanger() {
        // TODO Verifier si melanger est asser impredictible.
    }

    @Test
    public void remplir() {
        v1.remplir(10);
        assertEquals(10, v1.getVecteur().size());
        // Doit permetre de remplir le vecteur avec les forme manquante

        try {
            v1.remplir(-1);
            fail("Ne doit pas prendre en charge les nombre négatif");
        } catch (ArrayIndexOutOfBoundsException ignored) {

        }
    }

    @Test
    public void testToString() {
        // TODO Doit retourner un chaine string selon les standard etablis
        // TODO FAIL si la chaine retourner est null //Permet d'idiquer si non implementer
    }

    @Test
    public void trier() {
        // TODO Doit trier les objects selon les standart etablis
    }
}
