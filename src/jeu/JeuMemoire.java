package jeu;

import formes.Forme;
import formes.VecteurFormes;

import java.awt.*;
import java.util.ArrayList;

/**
 * Cette classe represente la gestion du jeu
 *
 * @author Samuel Nguyen-Phok
 * @version Hiver 2022
 */
public class JeuMemoire<Point> implements Memorisable
{
    /**
     * Nombre de ligne dans la grille de jeu
     */
    public static final int LIGNE = 6;

    /**
     * Nombre de colonne dans la grille de jeu
     */
    public static final int COLONNE = 6;

    /**
     * Nombre d'elements dans la grille
     */
    public static final int NBR_ELEMENTS_GRILLE = LIGNE * COLONNE;

    /**
     * TODO
     * La longueur de la chaine
     */
    private static final int LONGUEUR_CHAINE = 0;

    /**
     * Vecteur Forme
     */
    private VecteurFormes vecteurFormes = null;

    /**
     * La grille de jeu
     */
    private Forme[][] grilleDeJeu = null;

    /**
     * Liste de point choisi par le jeu
     */
    private ArrayList<Point> vecteurPoints = null;

    /**
     * Le niveau courrant du jeu
     */
    private int niveau = 1;

    /**
     * Constructeur de la classe
     */
    public JeuMemoire()
    {
        preparerVecteurFormes();
        preparerGrilleDeJeu();
    }

    /**
     * Todo
     * Prepare la grille de jeu
     */
    private void preparerGrilleDeJeu()
    {
        Forme[][] matrice = getGrille();



    }

    /**
     * Prepare la liste de Forme
     */
    private void preparerVecteurFormes()
    {
        vecteurFormes = new VecteurFormes();
        vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
        vecteurFormes.melanger();
    }

    /**
     * Retourne la grille de jeu
     *
     * @return grille de jeu
     */
    public Forme[][] getGrille()
    {
        return grilleDeJeu;
    }

    /**
     * Retourne l'attribut vecteur forme de la classe
     *
     * @return vecteur
     */
    public VecteurFormes getVecteur()
    {
        return vecteurFormes;
    }

    /**
     * Retourne le niveau courrant du jeu
     *
     * @return niveau courrant
     */
    @Override
    public int getNiveau()
    {
        return niveau;
    }

    /**
     * Retourne le nom de la forme en fonction de la position
     *
     * @param x colonne
     * @param y ligne
     * @return Nom de la forme
     */
    @Override
    public String getNomForme(int x, int y)
    {
        // plus de memoire mais reduit la complexiter
        Forme[][] array = getGrille();
        Forme temp = array[x][y];
        return temp.getNom() + temp.getCouleur();

        // moins de memoire mais plus de complexiter
        // return array[x][y].getNom() + array[x][y].getCouleur();
    }

    public ArrayList<Point> getVecteurPoints()
    {
        return vecteurPoints;
    }

    /**
     * Valide si le joueur a deviner un des points que le jeu a choisis
     *
     * @param x colonne
     * @param y ligne
     * @return boolean
     */
    @Override
    public boolean jouerHumain(int x, int y)
    {
        // TODO test jouerHumain
        return getVecteurPoints().contains(new Point(x, y));
    }

    /**
     * Retourne une liste de point choisis par le jeu
     *
     * @return liste de points
     */
    @Override
    public ArrayList<Point> jouerOrdi()
    {
        int pNiveau = getNiveau();
        ArrayList<Point> val = null;
        for (int i = 0; i < 2 + pNiveau; i++)
            val.add(choisirForme());               
        
        return val;
    }

    /**
     * Incremente le niveau courrant du jeu
     */
    @Override
    public void setNiveauPlusUn()
    {
        if (getNiveau() != 6)
        {
            niveau++;
        }
    }

    /**
     * Retourne la position d'une forme au hasard
     *
     * @return position d'une forme
     */
    private Point choisirForme()
    {
        return new Point(alea(0, 6), alea(0, 6));
    }

    /**
     * 
     * @param nbr
     * @param espace
     * @return
     */
    private String ajouterEspaces(int nbr, String espace)
    {
         // TODO implementer le ajouterEspaces
    }
    
    /**
     * Retourne toutes les attributs de l'objet
     *
     * @return attributs
     */
    @Override
    public String toString()
    {
        // TODO implementer le toString
        return null;
    }
}
