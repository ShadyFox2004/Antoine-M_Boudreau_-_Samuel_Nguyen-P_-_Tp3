package jeu;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Interface memorisable
 *
 * @author Samuel Nguyen-Phok
 * @version Hiver 2022
 */
public interface Memorisable
{
    /**
     * Le niveau maximum que le jeu peut atteindre
     */
    public static final int NIVEAU_MAX = 6;

    /**
     * Retourne le niveau courrant du jeu
     *
     * @return niveau
     */
    public abstract int getNiveau();

    /**
     * Retourne le nom de la forme en fonction de sa position
     *
     * @param x colonne
     * @param y ligne
     * @return nom de la forme
     */
    public abstract String getNomForme(int x, int y);

    /**
     * Valide si la position choisi par le joueur correspond a celui du jeu
     *
     * @param x colonne
     * @param y ligne
     * @return boolean
     */
    public abstract boolean jouerHumain(int x, int y);

    /**
     * Retourne une liste des positions que le jeu a choisi
     *
     * @return liste point
     */
    public abstract ArrayList<Point> jouerOrdi();

    /**
     * Augmente le niveau courant du jeu
     */
    public abstract void setNiveauPlusUn();
}
