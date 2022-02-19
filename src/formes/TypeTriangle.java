package formes;

/**
 * Un triangle est une forme à trois côtés.
 *
 * @author Antoine-Matis Boudreau
 */
public enum TypeTriangle {
    ISOCELE("isocèle"),
    EQUILATERAL("équilatéral"),
    RECTANGLE("rectangle"),
    SCALENE("scalène");

    private String type;

    TypeTriangle(String type) {
        setType(type);
    }

    /**
     * Accesseur de l'attribut type
     *
     * @return La valeur du type
     */
    public String getType() {
        return type;
    }

    /**
     * Modifie la valeur du type
     *
     * @param type : non null
     */
    private void setType(String type) {
        if(type != null) {
            this.type = type;
        }
    }

    /**
     * Retourne une chaîne avec les caractéristiques de l'enumeration
     *
     * @return String la chaîne de caractères représentant l'objet
     */
    @Override
    public String toString() {
        return type;
    }
}
