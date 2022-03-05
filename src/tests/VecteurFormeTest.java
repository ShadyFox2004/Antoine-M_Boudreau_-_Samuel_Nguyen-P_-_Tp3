package tests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Classe de test des vecteur:
 * Spécification de l'api public.
 * @author Antoine-Matis Boudreau
 */
public class VecteurFormeTest {
    private VecteurForme v1;


    @Before
    /**
     * Test du constructeur.
     */
    public void setUp() {
        v1 = new VecteurForme(); 
        // TODO Determiner les specification de l'object
        // Le constructeur ne leve pas d'exception
        // donc aucun test d'invalidité n'est requis.
    }

    @Test
    public void getVecteur() {
        v1.remplir(10);

        ArrayList expected = new ArrayList();
        v1.getVecteur();

        // TODO Doit donner une array 
    }

    @Test
    public void melanger() {
        // TODO Verifier si melanger est asser impredictible.
    }

    @Test
    public void remplir() {
        assertEquals(1,v1.getVecteur().size());
        // TODO Doit permetre de remplir le vecteur avec les forme manquante
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
