package formes;

import exceptions.FormeException;

/**
 * Un rectangle est une forme
 *
 * @author Antoine-Matis Boudreau
 */
public class Rectangle extends Forme  {

    /**
     * attribut hauteur, un entier entre 1 et 30 cm
     */
    private int hauteur;

    /**
     * attribut largeur, un entier entre 1 et 30 cm
     */
    private int largeur;

    /**
     * Crée un rectangle.
     *
     * @param hauteur hauteur
     * @param largeur largeur
     *
     * @throws FormeException Lorsque les dimensions dépassent les bornes.
     */
    public Rectangle(int hauteur, int largeur) throws FormeException {
        super("Rectangle");
        if (validerHauteur(hauteur) && validerLargeur(largeur)) {
            setHauteur(hauteur);
            setLargeur(largeur);
        } else {
            throw new FormeException("Les dimension sont invalide");
        }
    }

    /**
     * Accesseur de l'attribut hauteur
     *
     * @return La valeur de la hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Accesseur de l'attribut largeur
     *
     * @return La valeur de la largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Modifie la valeur de la hauteur si valide.
     *
     * @param hauteur : la valeur est entre 1 et 30
     */
    public void setHauteur(int hauteur) {
        if(validerHauteur(hauteur)) {
            this.hauteur = hauteur;
        }
    }

    /**
     * Modifie la valeur de la largeur si valide.
     *
     * @param largeur : la valeur est entre 1 et 30
     */
    public void setLargeur(int largeur) {
        if(validerLargeur(largeur)) {
            this.largeur = largeur;
        }
    }


    /**
     * Valide la hauteur.
     *
     * @param hauteur hauteur a valider.
     * @return validiter de la hauteur.
     */
    private static boolean validerHauteur(int hauteur) {
        return hauteur <= MAX_VAL && hauteur >= MIN_VAL;
    }

    /**
     * Valide la largeur.
     *
     * @param largeur largeur a valider.
     * @return validiter de la largeur.
     */
    private static boolean validerLargeur(int largeur) {
        return largeur <= MAX_VAL && largeur >= MIN_VAL;
    }

    /**
     * Calcul le perimetre du rectangle.
     *
     * @return perimetre.
     */
    @Override
    public int calculerPerimetre() {
        return hauteur * 2 + largeur * 2;
    }

    /**
     * Calcul la surface du rectangle.
     *
     * @return surface ou air.
     */
    @Override
    public int calculerSurface() {
        return hauteur * largeur;
    }

    /**
     * Retourne l’information de l’objet sous cette forme : nom couleur hauteur, largeur (dans l’ordre) :
     * ex : Rectangle rouge 3, 4
     *
     * @return information du rectangle.
     */
    @Override
    public String toString() {
        return super.toString() + " " + getHauteur() + ", " + getLargeur();
    }
}
