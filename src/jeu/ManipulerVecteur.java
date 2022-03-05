package jeu;

import java.util.ArrayList;

/**
 * Interface manipulerVecteur
 *
 * @author Antoine-Matis Boudreau
 * @version Hiver 2022
 */
public interface ManipulerVecteur {
    /**
     * Permet d'obtenir une référence sur le vecteur
     *
     * @return vecteurForme
     */
    public abstract ArrayList getVecteur();

    /**
     * Mélange le vecteur selon un algorithme
     */
    public abstract void melanger();

    /**
     * Permet de remplir le vecteur selon le nombre d'objects donnée en paramêtre.
     *
     * @param nombre nombre d'objects données
     */
    public abstract void remplir(int nombre);

    /**
     * Trie le vecteur selon l'algorithme de trie a bulle par couleur et par forme.
     */
    public abstract void trier();
}
