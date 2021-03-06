package jeu;

import formes.Forme;
import formes.VecteurFormes;

import java.awt.Point;
import java.util.ArrayList;

import static utilitaires.Utilitaires.*;

/**
 * Cette classe represente la gestion du jeu
 *
 * @author Samuel Nguyen-Phok
 * @version Hiver 2022
 */
public class JeuMemoire implements Memorisable {
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
    public JeuMemoire() {
        preparerVecteurFormes();
        preparerGrilleDeJeu();
    }

    /**
     * Prepare la liste de Forme
     */
    private void preparerVecteurFormes() {
        vecteurFormes = new VecteurFormes();
        vecteurFormes.remplir(NBR_ELEMENTS_GRILLE);
        vecteurFormes.melanger();
    }

    /**
     * Prepare la grille de jeu
     */
    private void preparerGrilleDeJeu() {
        grilleDeJeu = new Forme[LIGNE][COLONNE];

        ArrayList<Forme> formes = getVecteur().getVecteur();

        int nextForme = 0;

        for (int i = 0; i < grilleDeJeu.length; i++) {
            for (int j = 0; j < grilleDeJeu[i].length; j++) {
                grilleDeJeu[i][j] = formes.get(nextForme++);
            }
        }
    }

    /**
     * Retourne la grille de jeu
     *
     * @return grille de jeu
     */
    public Forme[][] getGrille() {
        return grilleDeJeu;
    }

    /**
     * Retourne l'attribut vecteur forme de la classe
     *
     * @return vecteur
     */
    public VecteurFormes getVecteur() {
        return vecteurFormes;
    }

    /**
     * Retourne le niveau courrant du jeu
     *
     * @return niveau courrant
     */
    @Override
    public int getNiveau() {
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
    public String getNomForme(int x, int y) {
        Forme forme = (getGrille())[x][y];

        String nom = forme.getNom();
        String couleur = forme.getCouleur().toString();

        String expected = nom.substring(0, 1).toUpperCase() +
                nom.substring(1) +
                couleur.substring(0, 1).toUpperCase() +
                couleur.substring(1);

        return expected;
    }

    /**
     * Retourne le vecteur de point
     * Note: Utiliser juste pour le test
     *
     * @return liste de points
     */
    public ArrayList<Point> getVecteurPoints() {
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
    public boolean jouerHumain(int x, int y) {
        return getVecteurPoints().contains(new Point(x, y));
    }

    /**
     * Retourne une liste de point choisis par le jeu
     *
     * @return liste de points
     */
    @Override
    public ArrayList<Point> jouerOrdi() {
        // get Niveau courrant du jeu
        int pNiveau = getNiveau();

        // return value
        vecteurPoints = new ArrayList<>();

        for (int i = 0; i < 2 + pNiveau; i++) {
            vecteurPoints.add(choisirForme());
        }

        return vecteurPoints;
    }

    /**
     * Incremente le niveau courrant du jeu
     */
    @Override
    public void setNiveauPlusUn() {
        if (getNiveau() != 6) {
            niveau++;
        }
    }

    /**
     * Retourne la position d'une forme au hasard
     *
     * @return position d'une forme
     */
    private Point choisirForme() {
        return new Point(alea(0, 5), alea(0, 5));
    }

    /**
     * Ajouter des espaces a la fin d'un string recu,
     * en fonction du nombre recu en parametre
     *
     * @param nombre
     * @param message
     * @return
     */
    private String ajouterEspaces(int nombre, String message) {
        String espace = "";
        for (int i = 0; i < nombre; i++) {
            espace += " ";
        }
        return message + espace;
    }

    /**
     * Retourne le nombre d'espace requis pour atteindre la longueur de la chaine
     * requis
     * a utiliser avec la methode ajouterEspace()
     */
    private int getNbrEspace(String texte) {
        int nbr = texte.length();
        if (nbr != LONGUEUR_CHAINE) {
            nbr = Math.abs(nbr -= LONGUEUR_CHAINE);
        }
        return nbr;
    }

    /**
     * Retourne toutes les attributs de l'objet
     *
     * @return attributs
     */
    @Override
    public String toString() {
        String out = "";
        String formeStr = null;

        for (int i = 0; i < getGrille().length; i++) {
            for (int j = 0; j < getGrille()[i].length; j++) {
                formeStr = getGrille()[i][j].toStringCourt();
                out += ajouterEspaces(getNbrEspace(formeStr), formeStr) + "|";
            }
            out += "\n";
        }
        return out;
    }
}
