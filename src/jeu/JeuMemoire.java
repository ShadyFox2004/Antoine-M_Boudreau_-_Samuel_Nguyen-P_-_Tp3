package jeu;

import formes.Forme;
import formes.VecteurFormes;

import java.awt.*;
import java.util.ArrayList;

import static utilitaires.Utilitaires.alea;

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
     * La longueur de la chaine
     */
    private static final int LONGUEUR_CHAINE = 17;

    /**
     * Attributs vecteur forme
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
     * Prepare la liste de Forme
     */
    private void preparerVecteurFormes()
    {
        //TODO test preparerVecteurForme
        vecteurFormes = new VecteurFormes();
        vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
        vecteurFormes.melanger();
    }

    /**
     * Prepare la grille de jeu
     */
    private void preparerGrilleDeJeu()
    {
        //TODO test prepareGrilleDeJeu
        Forme[][] matrice = getGrille();
        matrice = new Forme[LIGNE - 1][COLONNE - 1];

        for (Forme forme : getVecteur().getVecteur())
        {
            for (int i = 0; i < matrice.length; i++)
            {
                for (int j = 0; j < matrice.length; j++)
                    matrice[i][j] = forme;
            }
        }
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
        //TODO test getNomForme

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
        return getVecteurPoints().contains(new java.awt.Point(x, y));
    }

    /**
     * Retourne une liste de point choisis par le jeu
     *
     * @return liste de points
     */
    @Override
    public ArrayList<java.awt.Point> jouerOrdi()
    {
        //TODO test jouerOrdi
        int pNiveau = getNiveau();
        ArrayList<Point> val = null;
        for (int i = 0; i < 2 + pNiveau; i++)
            val.add(choisirForme());

        return (ArrayList<java.awt.Point>) val;
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
        //TODO test choisirForme
        return (Point) new java.awt.Point(alea(0, 5), alea(0, 5));
    }

    /**
     * Ajouter des espaces a la fin d'un string recu,
     * en fonction du nombre recu en parametre
     *
     * @param nombre
     * @param message
     * @return
     */
    private String ajouterEspaces(int nombre, String message)
    {
        //TODO test ajouterEspaces
        String espace = null;
        for (int i = 0; i < nombre; i++)
        {
            espace = espace + " ";
        }
        return message + espace;
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
        String val = null;

        for (int i = 0; i < getGrille().length; i++)
        {
            for (int j = 0; j < getGrille().length; j++)
            {
                val = getGrille()[i][j].toStringCourt() + "|";
            }
            val = "\n";
        }
        return val;
    }
}
