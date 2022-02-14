package formes;

import exceptions.FormeException;

/**
 * Un cercle est une forme.
 *
 * @author ambou
 */
public class Cercle extends Forme {
    /**
     * Un cercle comporte un rayon
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
     * Accede le rayon
     *
     * @return rayon
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
        return rayon <= MAX_VAL && rayon >= MIN_VAL;
    }

    /**
     * Calcul le perimetre.
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
     * @return information du cerlce.
     */
    @Override
    public String toString() {
        return super.toString() + " " + rayon;
    }
}
 