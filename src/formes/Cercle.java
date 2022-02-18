package formes;

import exceptions.FormeException;

/**
 * Un cercle est une forme à un côté.
 *
 * @author Antoine-Matis Boudreau
 */
public class Cercle extends Forme {
    /**
     * attribut rayon, un entier entre 1 et 30 cm
     */
    private int rayon;

    /**
     * Cree un cercle
     *
     * @param rayon rayon
     * @throws FormeException Lorsque le rayon depasse les bornes.
     */
    public Cercle(int rayon) throws FormeException {
        super("Cercle");
        if (validerRayon(rayon)) {
            setRayon(rayon);
        } else {
            throw new FormeException("Le rayon est invalide");
        }
    }

    /**
     * Accesseur de l'attribut rayon
     *
     * @return La valeur du rayon
     */
    public int getRayon() {
        return rayon;
    }

    /**
     * Set le rayon
     *
     * @param rayon Le nouveau rayon
     */
    public void setRayon(int rayon) {
        if (validerRayon(rayon)) {
            this.rayon = rayon;
        }
    }

    /**
     * Valide le rayon.
     *
     * @param rayon rayon a valider.
     * @return validiter du rayon.
     */
    private static boolean validerRayon(int rayon) {
        return rayon >= MIN_VAL && rayon <= MAX_VAL ;
    }

    /**
     * Calcul le perimêtre.
     *
     * @return Perimetre.
     */
    @Override
    public int calculerPerimetre() {
        // P = Pi*r*2
        return (int) (Math.PI * (double) rayon * 2.0);
    }

    /**
     * Calcul la surface.
     *
     * @return Surface ou air.
     */
    @Override
    public int calculerSurface() {
        // A = Pi*r^2
        return (int) (Math.PI * (double) rayon * (double) rayon);
    }

    /**
     * Retourne l’information de l’objet sous cette forme : nom couleur rayon
     * ex : Cercle vert 10
     *
     * @return information du cercle.
     */
    @Override
    public String toString() {
        return super.toString() + " " + rayon;
    }
}
 