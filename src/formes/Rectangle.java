package formes;

import exceptions.FormeException;

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

    /**
     * Cree un rectangle.
     * 
     * @param hauteur hauteur
     * @param largeur largeur
     * @throws FormeException Lorsque les dimension depasse les bornes.
     */
    public Rectangle(int hauteur, int largeur) throws FormeException
    {
        if(validerHauteur(hauteur) && validerLargeur(largeur))
        {
            setHauteur(hauteur);
            setLargeur(largeur);
            setCouleur(COULEUR_DEFAUT);
        }
        else
        {
            throw new FormeException("Les dimension sont invalide");
        }
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

    /**
     * Accede la hauteur
     *
     * @return hauteur
     */
    public int getHauteur()
    {
        return hauteur;
    }

    /**
     * Accede la largeur
     *
     * @return largeur
     */
    public int getLargeur()
    {
        return largeur;
    }

     /**
     * Accede le nom
     *
     * @return nom
     */
    public static String getNom()
    {
        return nom;
    }

    /**
     * Accede la couleur
     *
     * @return nom
     */
    public String getCouleur()
    {
        return couleur;
    }

    /**
     * Set la hauteur
     * 
     * @param hauteur La nouvelle hauteur
     */
    public void setHauteur(int hauteur)
    {
        this.hauteur = hauteur;
    }

     /**
     * Set la largeur
     * 
     * @param hauteur La nouvelle largeur
     */
    public void setLargeur(int largeur)
    {
        this.largeur = largeur;
    }

    /**
     * Set la couleur
     *
     * @param couleur La nouvelle couleur
     */
    public void setCouleur(String couleur)
    {
        if (validerCouleur(couleur))
        {
            couleur = couleur.trim().toLowerCase();
        }
        else
        {
            couleur = COULEUR_DEFAUT;
        }

        this.couleur = couleur;
    }

    /**
     * Valide la couleur.
     *
     * @param couleur couleur a valider.
     * @return validiter de la couleur.
     */
    private boolean validerCouleur(String couleur)
    {
        boolean estValide = false;

        if (couleur != null)
        {
            couleur = couleur.trim().toLowerCase();     // Netois la valeur en entrer.
            for (String couleurAValider : LES_COULEURS)
            {
                if (couleur.equals(couleurAValider))
                {
                    estValide = true;
                    break;
                }
            }
        }

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
        return hauteur <= MAX_VAL && hauteur >= MIN_VAL;
    }

    /**
     * Valide la largeur.
     *
     * @param largeur largeur a valider.
     * @return validiter de la largeur.
     */
    private static boolean validerLargeur(int largeur)
    {
        return largeur <= MAX_VAL && largeur >= MIN_VAL;
    }

    @Override
    public boolean equals(Object o)
    {
        return o instanceof Rectangle
            && couleur.equals(((Rectangle) o).getCouleur())
            && calculerSurface() == ((Rectangle) o).calculerSurface();
    }
}