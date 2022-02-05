package formes;

import exceptions.FormeException;

public class Cercle {
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 30;

    private static final int RAYON_DEFAUT = 10;
    private static final String[] LES_COULEURS = {"rouge", "vert", "bleu", "jaune", "noir", "orange"};

    public static final String COULEUR_DEFAUT = LES_COULEURS[1];

    private int rayon;
    private static String nom = "Cercle";
    private String couleur;

    /**
     * Cree un cercle par defaut.
     */
    public Cercle() {
        this(RAYON_DEFAUT); // C'est impossible que ca plante.
    }

    /**
     * Cree un cercle
     *
     * @param rayon rayon
     * @throws FormeException Lorsque le rayon depasse les bornes.
     */
    public Cercle(int rayon) throws FormeException {
        if (validerRayon(rayon)) {
            setRayon(rayon);
            setCouleur(COULEUR_DEFAUT);
        } else {
            throw new FormeException("Le rayon est invalide");
        }
    }

    /**
     * Calcul le perimetre.
     *
     * @return Perimetre.
     */
    public int calculerPerimetre() {
        // P = Pi*r*2
        return (int) (Math.PI * (double) rayon * 2.0);
    }

    /**
     * Calcul la surface.
     *
     * @return Surface ou air.
     */
    public int calculerSurface() {
        // A = Pi*r^2
        return (int) (Math.PI * (double) rayon * (double) rayon);
    }

    /**
     * Compare l'object avec celui en argument.
     *
     * @param o Objet a comparer
     * @return le resultat
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Cercle &&
                ((Cercle) o).calculerSurface() == calculerSurface() &&
                ((Cercle) o).couleur.equals(couleur);
    }

    /**
     * Accede la couleur.
     *
     * @return couleur.
     */
    public String getCouleur() {
        return this.couleur;
    }

    /**
     * Accede le nom
     *
     * @return nom
     */
    public static String getNom() {
        return nom;
    }

    /**
     * Accede le rayon
     *
     * @return rayon
     */
    public int getRayon() {
        return rayon;
    }

    public static void main(String[] args) {

    }

    /**
     * Set la couleur
     *
     * @param couleur La nouvelle couleur
     */
    public void setCouleur(String couleur) {
        if (validerCouleur(couleur)) {
            couleur = couleur.trim().toLowerCase();
        } else {
            couleur = COULEUR_DEFAUT;
        }

        this.couleur = couleur;
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
     * Retourne l’information de l’objet sous cette forme : nom couleur rayon
     * ex : Cercle vert 10
     *
     * @return information du cerlce.
     */
    @Override
    public String toString() {
        return nom + " " + couleur + " " + rayon;
    }

    /**
     * Valide la couleur.
     *
     * @param couleur couleur a valider.
     * @return validiter de la couleur.
     */
    private boolean validerCouleur(String couleur) {
        boolean estValide = false;

        if (couleur != null) {
            couleur = couleur.trim().toLowerCase();     // Netois la valeur en entrer.
            for (String couleurAValider : LES_COULEURS) {
                if (couleur.equals(couleurAValider)) {
                    estValide = true;
                    break;
                }
            }
        }

        return estValide;
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
}
 