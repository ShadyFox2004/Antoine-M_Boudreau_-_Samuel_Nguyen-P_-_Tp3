package formes;

import exceptions.FormeException;

import java.util.Arrays;

/**
 * Un triangle est une forme à trois côtés.
 *
 * @author Antoine-Matis Boudreau
 */
public class Triangle extends Forme{
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
     * Constructeur de triangle
     *
     * @param coteA la grandeur du côté A est entre 1 et 30
     * @param coteB la grandeur du côté B est entre 1 et 30
     * @param coteC la grandeur du côté C est entre 1 et 30
     *
     * @throws FormeException si le triangle est invalide ou impossible
     */
    public Triangle(int coteA, int coteB, int coteC) throws FormeException {
        super("Triangle");

        if (validerCote(coteA) && validerCote(coteB) && validerCote(coteC) && estTriangle(coteA, coteB, coteC)) {
            this.coteA = coteA;
            this.coteB = coteB;
            this.coteC = coteC;
        } else {
            throw new FormeException("Triangle invalide ou impossible");
        }
    }

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
     * Vérifie si un côté est valide.
     *
     * @param cote Le côté à valider
     * @return validitée du côté
     */
    private static boolean validerCote(int cote) {
        return cote >= MIN_VAL && cote <= MAX_VAL;
    }

    /**
     * Vérifie si nous sommes en présence d'un vrai triangle selon la longueur de ses côtés
     *
     * @return vrai si le triangle est possible
     */
    private static boolean estTriangle(int coteA, int coteB, int coteC) {
        return !(coteA + coteB < coteC ||
                coteB + coteC < coteA ||
                coteA + coteC < coteB);
    }

    /**
     * Vérifie si le triangle est rectangle.
     *
     * @return vrai si c'est le triangle est rectangle
     */
    private boolean estRectangle() {
        boolean estRectangle = false;


        int[] cotes = getCotesTries();

        return (int)(Math.pow(cotes[2], 2)) == (int)(Math.pow(cotes[0], 2) + Math.pow(cotes[1], 2));
    }

    /**
     * Tries les côtés par grandeur du plus petit au plus grand.
     *
     * @return côtés triés.
     */
    private int[] getCotesTries() {
        int[] cotes = {getCoteA(), getCoteB(), getCoteC()};

        Arrays.sort(cotes);

        return cotes;
    }

    /**
     * Calcule le nombre de côtés égaux.
     *
     * @return nombre de côtés égaux
     */
    private int getNbrCoteEgaux() {
        int nbrCoteEgaux = 0;


        // TODO Valider la methode.

        if(getCoteA() == getCoteB() && getCoteA() == getCoteC())
            nbrCoteEgaux = 3;
        else if(getCoteA() == getCoteB() || getCoteA() == getCoteC() || getCoteB() == getCoteC())
            nbrCoteEgaux = 2;

        return nbrCoteEgaux;
    }

    /**
     * Donne le type de triangle
     *
     * @return Type de triangle
     */
    public TypeTriangle getType() {
        TypeTriangle type;

        int nbrCoteEgaux = getNbrCoteEgaux();
        
        if(nbrCoteEgaux == 3) {
            type = TypeTriangle.EQUILATERAL;
        } else if (nbrCoteEgaux == 2) {
            type = TypeTriangle.ISOCELE;
        } else if (estRectangle()) {
            type = TypeTriangle.RECTANGLE;
        } else {
            type = TypeTriangle.SCALENE;
        }

        return type;
    }


    /**
     * Calcul la surface.
     *
     * @return surface ou air.
     */
    @Override
    public int calculerSurface() {
        // Formule de heron
        int s = calculerPerimetre()/2;
        return (int) Math.sqrt(s*(s-getCoteA())*(s-getCoteB())*(s-getCoteC()));
    }

    /**
     * Calcul le perimetre.
     *
     * @return Perimetre.
     */
    @Override
    public int calculerPerimetre() {
        return getCoteA()+getCoteB()+getCoteC(); // Simplement la somme de tous les côtés
    }

    /**
     * Retourne l'objet sous format texte.
     * @return Object
     */
    @Override
    public String toString() {
        return super.toString() + " " + getType() + " " + getCoteA() + ", " + getCoteB() + ", " + getCoteC();
    }
}
