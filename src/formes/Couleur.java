package formes;

public enum Couleur {
    ROUGE("rouge"),
    VERT("vert"),
    BLEU("bleu"),
    JAUNE("jaune"),
    NOIR("noir"),
    ORANGE("orange");

    /**
     * Une couleur a un nom.
     */
    private String nom;

    /**
     * Cree une couleur.
     *
     * @param nom nom de la couleur
     */
    private Couleur(String nom){
        setNom(nom);
    }

    /**
     * Accede le nom.
     *
     * @return le nom.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom.
     *
     * @param nom le nouveau nom.
     */
    private void setNom(String nom) {
        if (nom != null) {
            this.nom = nom;
        }
    }

    /**
     * Retourne l'object sous forme de Texte.
     *
     * @return Texte
     */
    @Override
    public String toString() {
        return nom;
    }


}