package formes;

import exceptions.FormeException;

/**
 * Une rectangle est une forme
 *
 * @author ambou
 */
public class Rectangle extends Forme  {
    /**
     * Un rectangle a une hauteur
     */
    private int hauteur;

    /**
     * Un rectangle a une largeur
     */
    private int largeur;

    /**
     * Cree un rectangle.
     *
     * @param hauteur hauteur
     * @param largeur largeur
     * @throws FormeException Lorsque les dimension depasse les bornes.
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
     * Accede la hauteur
     *
     * @return hauteur
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * Accede la largeur
     *
     * @return largeur
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * Set la hauteur
     *
     * @param hauteur La nouvelle hauteur
     */
    public void setHauteur(int hauteur) {
        if(validerHauteur(hauteur)) {
            this.hauteur = hauteur;
        }
    }

    /**
     * Set la largeur
     *
     * @param largeur La nouvelle largeur
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
        return getNom() + " " + getCouleur() + " " + getHauteur() + ", " + getLargeur();
    }
}
