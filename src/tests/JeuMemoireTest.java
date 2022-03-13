package tests;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import formes.Forme;
import formes.VecteurFormes;
import jeu.JeuMemoire;

import java.awt.*;

/**
 * Test de la classe JeuMemoire
 *
 * @author Antoine-Matis Boudreau
 * @author Samuel Nguyen-Phok
 */
public class JeuMemoireTest {

    private JeuMemoire jeu;

    @Before
    public void setup() {
        jeu = new JeuMemoire();
        // Pas de test invalide ni plusieur acteurs puisque pas d'argument en entré.
    }

    @Test
    public void getGrille() {
        try {
            Forme[][] matrice = jeu.getGrille();
            if (matrice == null) {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            fail("" + jeu.getGrille() + "");
        }

    }

    @Test
    public void getNiveau() {
        assertEquals(1, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(2, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(3, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(4, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(5, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(6, jeu.getNiveau());

        jeu.setNiveauPlusUn();
        assertEquals(6, jeu.getNiveau());

    }

    @Test
    public void getNomForme() {

        Forme[][] matrice = jeu.getGrille();
        // Doit retourner une string formater selon : NomCouleur
        for (int x = 0; x < matrice.length; x++) {
            // Nous repetons le test plusieur fois pour assure que le bon comportement n'est
            // pas du hazard'
            for (int y = 0; y < matrice.length; y++) {
                // Pour chaques ligne et chaque colone.

                // Tous se processus est pour changer la premiere lettre du nom de la forme et
                // de la couleur
                Forme forme = matrice[x][y];

                String nom = forme.getNom();
                String couleur = forme.getCouleur().toString();

                String expected = nom.substring(0, 1).toUpperCase() +
                        nom.substring(1) +
                        couleur.substring(0, 1).toUpperCase() +
                        couleur.substring(1);

                assertEquals(expected, jeu.getNomForme(x, y));
            }
        }
    }

    @Test
    public void testGetVecteur() {
        assertEquals(true, jeu.getVecteur() instanceof VecteurFormes);
    }

    @Test
    public void testJouerHumain() {
        // prendre un point dans la liste en avance et apres tester la methode

        // creer la liste de points
        jeu.jouerOrdi();

        // point a deviner de la liste
        Point point = jeu.getVecteurPoints().get(0);
        Point point2 = jeu.getVecteurPoints().get(1);
        Point point3 = jeu.getVecteurPoints().get(2);

        assertEquals(true, jeu.jouerHumain((int) point.getX(), (int) point.getY()));
        assertEquals(true, jeu.jouerHumain((int) point2.getX(), (int) point2.getY()));
        assertEquals(true, jeu.jouerHumain((int) point3.getX(), (int) point3.getY()));
    }

    @Test
    public void testJouerOrdi() {
        // Permet de comparer si la liste de point est une copie
        JeuMemoire compare = new JeuMemoire();

        // Creer la liste de points
        jeu.jouerOrdi();
        compare.jouerOrdi();

        assertEquals(false, jeu.getVecteurPoints().equals(compare.getVecteurPoints()));

        // Verifie si le nombre de points son les bons en fonction du niveau
        assertEquals(3, jeu.getVecteurPoints().size());

        jeu.setNiveauPlusUn();
        jeu.jouerOrdi();
        assertEquals(2, jeu.getNiveau());
        assertEquals(4, jeu.getVecteurPoints().size());

        jeu.setNiveauPlusUn();
        jeu.jouerOrdi();
        assertEquals(3, jeu.getNiveau());
        assertEquals(5, jeu.getVecteurPoints().size());

        jeu.setNiveauPlusUn();
        jeu.jouerOrdi();
        assertEquals(4, jeu.getNiveau());
        assertEquals(6, jeu.getVecteurPoints().size());

        jeu.setNiveauPlusUn();
        jeu.jouerOrdi();
        assertEquals(5, jeu.getNiveau());
        assertEquals(7, jeu.getVecteurPoints().size());

        jeu.setNiveauPlusUn();
        jeu.jouerOrdi();
        assertEquals(6, jeu.getNiveau());
        assertEquals(8, jeu.getVecteurPoints().size());

    }

    @Test
    public void testSetNiveauPlusUn() {
        jeu.setNiveauPlusUn();
        assertEquals(2, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(3, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(4, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(5, jeu.getNiveau());
        jeu.setNiveauPlusUn();
        assertEquals(6, jeu.getNiveau());

        jeu.setNiveauPlusUn();
        assertEquals(6, jeu.getNiveau());
    }

    @Test
    public void testToString() {
        /**
         * 1. Verifier le nombre de charactere
         * une ligne: (17 + 1) * 6 = 108 + 1 = 109
         * total: 109 * 6 = 654
         */
        assertEquals(654, jeu.toString().length());

    }
}
