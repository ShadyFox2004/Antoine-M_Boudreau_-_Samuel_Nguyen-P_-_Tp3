package tests;

import formes.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Classe de test des vecteur:
 * Spécification de l'api public.
 * @author Antoine-Matis Boudreau
 */
public class VecteurFormeTest {
    private VecteurFormes v1;
    private static final int GRANDEUR_DU_VECTEUR = 100;



    /**
     * Test du constructeur.
     */
    @Before
    public void setUp() {
        v1 = new VecteurFormes();
        // Le constructeur ne leve pas d'exception
        // donc aucun test d'invalidité n'est requis.
    }

    @Test
    public void getVecteur() {
        assertEquals(true, v1.getVecteur() instanceof ArrayList<?>);
    }

    @Test
    public void melanger() {
        v1.remplir(GRANDEUR_DU_VECTEUR);
        var previous = (ArrayList<Forme>) v1.getVecteur().clone();

        // System.out.println("previous = " + previous);

        for (int i = 0; i < 100; i++) {
            // Nous repetons le test plusieur fois pour assure que le bon comportement n'est pas du hazard
            v1.melanger();
            // Verifier si melanger est asser impredictible.
            assertNotEquals(previous, v1.getVecteur());
            assertEquals(GRANDEUR_DU_VECTEUR, v1.getVecteur().size()); //Le nombre d'objets doit etre le meme
        }
    }

    @Test
    public void remplir() {
        v1.remplir(GRANDEUR_DU_VECTEUR);
        assertEquals(GRANDEUR_DU_VECTEUR, v1.getVecteur().size());
        // Doit permetre de remplir le vecteur avec les forme demander

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
        v1.remplir(GRANDEUR_DU_VECTEUR);

        for (int i = 0; i < GRANDEUR_DU_VECTEUR; i++) {
            // Nous repetons le test plusieur fois pour assure que le bon comportement n'est pas du hazard
            var previous = (ArrayList<Forme>) v1.getVecteur().clone();
            Collections.sort(previous); // Trie selon l'algorithme de java pour un groupe de control
            
            v1.melanger();
            v1.trier();// Trie selon l'algorithme implementer

            assertEquals(previous, v1.getVecteur()); // Nous assumons que le trie est exactement egal.
            assertEquals(GRANDEUR_DU_VECTEUR, v1.getVecteur().size()); //Le nombre d'objets doit etre le meme
            
        }

    }
}
