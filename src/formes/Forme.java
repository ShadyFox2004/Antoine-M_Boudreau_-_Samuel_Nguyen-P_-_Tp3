package formes;

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
     * Accede la couleur
     *
     * @return couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * Change le nom
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
     * -1 si inferieur, 0 si egal, 1 si superieur.
     * @param o
     * @return
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
}
