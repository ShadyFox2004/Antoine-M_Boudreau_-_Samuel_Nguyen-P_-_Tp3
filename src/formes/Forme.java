package formes;

/**
 * Une forme est un objet fini.
 * Elle possède un nom et une couleur.
 *
 * @author Antoine-Matis Boudreau
 */
public abstract class Forme implements Comparable<Forme> {
    /**
     * Valeur minimum.
     */
    public static final int MIN_VAL = 1;

    /**
     * Valeur maximum.
     */
    public static final int MAX_VAL = 30;

    /**
     * Couleur par defaut
     */
    public static final Couleur COULEUR_DEFAUT = Couleur.ROUGE;

    /**
     * Couleur de la forme
     */
    private Couleur couleur;

    /**
     * Nom de la forme
     */
    private final String nom;

    /**
     * Cree une forme
     *
     * @param nom Nom de la forme
     */
    public Forme(String nom) {
        this.nom = nom;
        setCouleur(COULEUR_DEFAUT);
    }

    /**
     * Accede le nom
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Accesseur de l'attribut couleur
     *
     * @return La valeur de la couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Modifie la couleur
     *
     * @param couleur la nouvelle couleur
     */
    public void setCouleur(Couleur couleur) {
        if (couleur != null)
            this.couleur = couleur;
    }

    /**
     * Compare deux Formes
     *
     * @param o La forme a compare
     * @return -1 si inferieur, 0 si egal, 1 si superieur.
     * @throws NullPointerException si l'objet est null.
     */
    @Override
    public int compareTo(Forme o) throws NullPointerException {
        int result = 0;

        if (o != null) {
            result = getNom().compareTo(o.getNom());
            if (result == 0) {
                result = (getCouleur().toString()).compareTo(o.getCouleur().toString());
            }
        } else {
            throw new NullPointerException();
        }

        if (result < -1) {
            result = -1;
        } else if (result > 1) {
            result = 1;
        }

        return result;
    }

    /**
     * Compare l'object avec celui en argument.
     *
     * @param o Objet a comparer
     * @return le resultat
     */
    @Override
    public boolean equals(Object o) {
        return o instanceof Forme &&
                ((Forme) o).getNom().equals(getNom()) &&
                ((Forme) o).calculerSurface() == calculerSurface() &&
                ((Forme) o).getCouleur().equals(getCouleur());
    }

    /**
     * Calcul la surface.
     *
     * @return surface ou air.
     */
    public abstract int calculerSurface();

    /**
     * Calcul le perimetre.
     *
     * @return Perimetre.
     */
    public abstract int calculerPerimetre();

    /**
     * Retourne l'objet sous format texte.
     *
     * @return Object
     */
    @Override
    public String toString() {
        return nom + " " + couleur;
    }

    /**
     * Retourne l'objet sous format texte.
     *
     * @return Object
     */
    public String toStringCourt() {
        return nom + " " + couleur;
    }
}
