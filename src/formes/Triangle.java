package formes;

import static formes.Forme.MAX_VAL;
import static formes.Forme.MIN_VAL;

/**
 * Un triangle est une forme à trois côtés.
 *
 * @author Antoine-Matis Boudreau
 */
public class Triangle {

    /**
     * attribut coteA, un entier entre 1 et 30 cm
     */
    private int coteA;

    /**
     * attribut coteB, un entier entre 1 et 30 cm
     */
    private int coteB;

    /**
     * attribut coteC, un entier entre 1 et 30 cm
     */
    private int coteC;

    /**
     * Accesseur de l'attribut coteA
     *
     * @return La valeur du coteA
     */
    public int getCoteA() {
        return coteA;
    }

    /**
     * Accesseur de l'attribut coteB
     *
     * @return La valeur du coteB
     */
    public int getCoteB() {
        return coteB;
    }

    /**
     * Accesseur de l'attribut coteC
     *
     * @return La valeur du coteC
     */
    public int getCoteC() {
        return coteC;
    }

    /**
     * Modifie la valeur du coteA si valide.
     *
     * @param coteA : la valeur est entre 1 et 30
     */
    public void setCoteA(int coteA) {
        if(validerCote(coteA)) {
            this.coteA = coteA;
        }
    }

    /**
     * Modifie la valeur du coteB si valide.
     *
     * @param coteB : la valeur est entre 1 et 30
     */
    public void setCoteB(int coteB) {
        if(validerCote(coteB)) {
            this.coteB = coteB;
        }
    }

    /**
     * Modifie la valeur du coteC si valide.
     *
     * @param coteC : la valeur est entre 1 et 30
     */
    public void setCoteC(int coteC) {
        if(validerCote(coteC)) {
            this.coteC = coteC;
        }
    }

    /**
     * Vérifie si un côté est valide.
     *
     * @param cote Le côté à valider
     * @return validitée du côté
     */
    private boolean validerCote(int cote) {
        return  cote >= MIN_VAL && cote <= MAX_VAL ;
    }
}
