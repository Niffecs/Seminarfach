package hash;

/**
 * @author Stertzing, Ronny
 */
// oeffentliche Klasse
public class Vars {

    // oeffentlicher nichtoeberladender Konstruktor
    public Vars() {
        Vars.p = 0;
        Vars.q = 0;
        Vars.N = 0;
        Vars.e = 0;
        Vars.a = 0;
        Vars.c = 0;
        Vars.trash = 0;
        Vars.d = 0;
        Vars.M = 'A'; // A = 65;
    }

    // Deklaration der Variabeln
    private static int trash;
    private static int p;
    private static int q;
    private static int N;
    private static int e;
    private static int a;
    private static int c;
    private static int d;
    private static char M;
    private static StringBuffer Hash;

    /* SETTER UND GETTER ALLER VARIABELN */

    public static StringBuffer getHash() {
        return Hash;
    }

    public static void setHash(StringBuffer Hash) {
        Vars.Hash = Hash;
    }

    public static int getTrash() {
        return trash;
    }

    public static void setTrash(int trash) {
        Vars.trash = trash;
    }

    public static int getP() {
        return p;
    }

    public static void setP(int p) {
        Vars.p = p;
    }

    public static int getQ() {
        return q;
    }

    public static void setQ(int q) {
        Vars.q = q;
    }

    public static int getN() {
        return N;
    }

    public static void setN(int N) {
        Vars.N = N;
    }

    public static int getE() {
        return e;
    }

    public static void setE(int e) {
        Vars.e = e;
    }

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        Vars.a = a;
    }

    public static int getC() {
        return c;
    }

    public static void setC(int c) {
        Vars.c = c;
    }

    public static int getD() {
        return d;
    }

    public static void setD(int d) {
        Vars.d = d;
    }

    public static char getM() {
        return M;
    }

    public static void setM(char M) {
        Vars.M = M;
    }

}
