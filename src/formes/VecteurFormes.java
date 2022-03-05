package formes;

import java.util.ArrayList;

/**
 * Classe VecteurFormes
 * @author Antoine-Matis Boudreau
 */
public class VecteurFormes implements ManipulerVecteur {
    /**
     * attribut vecteur  contiens les formes.
     */
    private ArrayList<Forme> vecteur;


    /**
     * Crée un VecteurFormes vide
     */
    public VecteurFormes() {
        vecteur = new ArrayList<Forme>();
    }

     /**
     * Permet d'obtenir une référence sur le vecteur
     *
     * @return vecteurForme
     */
    @Override
    public ArrayList<Forme> getVecteur() {
        return vecteur;
    }

    /**
     * Mélange le vecteur selon un algorithme
     */
    @Override
    public void melanger() {

    }

    /**
     * Permet de remplir le vecteur selon le nombre d'objects donnée en paramêtre.
     *
     * @param nombre nombre d'objects données
     * @throws ArrayIndexOutOfBoundsException si le nombre est plus petit que 0 inclus
     */
    @Override
    public void remplir(int nombre) {
        if (nombre > 0) {
            // Boucle si le nombre n'est pas encore attain
            while(nombre != 0) for (int type = 0; type < 3 && nombre > 0; type++) //
                for (int couleur = 0; couleur < Couleur.values().length && nombre > 0; couleur++) {
                    Forme forme = null;

                    if(type == 0)
                        forme = new Cercle(Forme.MIN_VAL);
                    else if(type == 1)
                        forme = new Rectangle(Forme.MIN_VAL, Forme.MIN_VAL);
                    else
                        forme = new Triangle(Forme.MIN_VAL,Forme.MIN_VAL,Forme.MIN_VAL);

                    forme.setCouleur(Couleur.values()[couleur]);

                    vecteur.add(forme);
                    nombre--;
                }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Trie le vecteur selon l'algorithme de trie a bulle par couleur et par forme.
     */
    @Override
    public void trier() {

    }

}
