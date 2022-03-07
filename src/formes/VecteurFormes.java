package formes;

import java.util.ArrayList;

import static utilitaires.Utilitaires.alea;

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
        ArrayList<Forme> newVecteur = new ArrayList<Forme>();

        while (!vecteur.isEmpty()) {
            newVecteur.add(vecteur.remove(alea(0,vecteur.size()-1)));
        }

        vecteur = newVecteur;
    }

    /**
     * Permute deux element.
     *
     * @param place1 place que tu veux le deuxième.
     * @param place2 place que tu veux le premier.
     */
    private void permuter(int place1, int place2) {
        vecteur.set(place1, vecteur.set(place2,vecteur.get(place1)));
    }

    /**
     * Permet de remplir le vecteur selon le nombre d'objects donnée en paramêtre.
     *
     * @param nombre nombre d'objects données
     * @throws ArrayIndexOutOfBoundsException si le nombre est plus petit que 0 inclus
     */
    @Override
    public void remplir(int nombre) {
        if (validerNbrFormes(nombre)) {
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
        for (int i = 1; i < vecteur.size(); i++) {
            for (int j = 0; j < vecteur.size() -1; j++) { // - 1 pour eviter le debordement
                int position  = vecteur.get(j).compareTo(vecteur.get(j+1));

                if (position > 0)
                    permuter(j+1, j);
            }
        }
    }

    /**
     * Valide si le nombre de formes est valide
     *
     * @param nombreDeForme le nombre de forme
     * @return si le nombre de forme est valide ou non
     */
    private static boolean validerNbrFormes(int nombreDeForme) {
        return nombreDeForme > 0;
    }
}