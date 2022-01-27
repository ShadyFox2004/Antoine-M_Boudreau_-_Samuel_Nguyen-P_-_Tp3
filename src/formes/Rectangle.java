package formes;

public class Rectangle
{
    public static final int MIN_VAL = 1;
    public static final int MAX_VAL = 30;

    public static final String[] LES_COULEURS = {"rouge", "vert", "bleu", "jaune", "noir", "orange"};
    public static final String COULEUR_DEFAUT = LES_COULEURS[0];

    private int hauteur;

    private int largeur;

    private static String nom = "Rectangle";

    private String couleur;

    public Rectangle(int hauteur, int largeur)
    {
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    /**
     * Calcul le perimetre du rectangle.
     *
     * @return perimetre.
     */
    public int calculerPerimetre()
    {
        return hauteur*2 + largeur*2;
    }

    /**
     * Calcul la surface du rectangle.
     *
     * @return surface ou air.
     */
    public int calculerSurface()
    {
        return hauteur*largeur;
    }

    public int getHauteur()
    {
        return hauteur;
    }

    public int getLargeur()
    {
        return largeur;
    }

    public String getNom()
    {
        return nom;
    }

    public String getCouleur()
    {
        return couleur;
    }

    public void setHauteur(int hauteur)
    {
        this.hauteur = hauteur;
    }

    public void setLargeur(int largeur)
    {
        this.largeur = largeur;
    }

    public void setCouleur(String couleur)
    {
        if(validerCouleur(couleur))
        {

        }
        else
        {
            couleur = COULEUR_DEFAUT;
        }

        this.couleur = couleur;
    }


    private boolean validerCouleur(String couleur)
    {
        boolean estValide = false;
        return estValide;
    }

    /**
     * Retourne l’information de l’objet sous cette forme : nom couleur hauteur, largeur (dans l’ordre) :
     * ex : Rectangle rouge 3, 4
     *
     * @return information du rectangle.
     */
    @Override
    public String toString()
    {
        return nom + " " + couleur + " " + hauteur +", " +  largeur;
    }

    /**
     * Valide la hauteur.
     *
     * @param hauteur hauteur a valider.
     * @return validiter de la hauteur.
     */
    private static boolean validerHauteur(int hauteur)
    {
        boolean estValide = false;

        if (hauteur <= MAX_VAL && hauteur >= MIN_VAL)
        {
            estValide = true;
        }

        return estValide;
    }

    private static boolean validerLargeur(int largeur)
    {
        boolean estValide = false;
        return estValide;
    }

    public boolean equals(Object o)
    {
        return o instanceof Rectangle &&
            ((Rectangle)o).calculerSurface() == calculerSurface() &&
            ((Rectangle)o).couleur.equals(couleur);
    }
}