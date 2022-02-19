package formes;

/**
 * Une forme est un objet fini.
 * Elle possède un nom et une couleur.
 *
 * @author Antoine-Matis Boudreau
 */
public abstract class Forme implements Comparable<Forme>{
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
    private String nom;

    /**
     * Cree une forme
     * @param nom Nom de la forme
     */
    public Forme(String nom) {
        setNom(nom);
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
     * Modifie le nom
     *
     * @param nom Nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Modifie la couleur
     *
     * @param couleur la nouvelle couleur
     */
    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * Compare deux Formes
     * // TODO Implementer pour vrai
     * @param o La forme a compare
     * @return -1 si inferieur, 0 si egal, 1 si superieur.
     */
    @Override
    public int compareTo(Forme o) {
        return 0;
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
     * Retourne l'obejet sous format texte.
     * @return Object
     */
    @Override
    public String toString() {
        return nom + " " + couleur;
    }
}
