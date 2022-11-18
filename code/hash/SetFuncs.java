package hash;

/* importiert den Fehler "NoSuchAlgorithmException" */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* importiert die aus javax die Swing Klasse */
import javax.swing.JOptionPane;

/**
 * @author Stertzing, Ronny
 */
public abstract class SetFuncs {

    /* Das bekannte Objekt */
    Vars var = new Vars();

    /**
     * Liefert dir den Hash
     *
     * @param s
     * @return sb
     * @throws NoSuchAlgorithmException
     */
    protected static String getHash(String s) throws NoSuchAlgorithmException {
        /* lege das Objekt als md id fest. Also den Algo */
        MessageDigest md = MessageDigest.getInstance("MD5");

        /* selbsterklaerend */
        md.update(s.getBytes());

        /* erstelle Digitales Verfahren */
        byte byteData[] = md.digest();

        /* konvertiere byte nach hex */
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            /* haenge an die String Liste etwas ran ;) */
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }

    /**
     * Eingabe der Zahlen
     *
     * @return int
     * @exception none
     * @param String text
     */
    public static Integer eingabe(String text) {
        int zahl = Integer.parseInt(JOptionPane.showInputDialog(text));
        return zahl;
    }

    /**
     * Berechne das GGT zweier Zahlen
     *
     * @param f1
     * @param f2
     * @return int ggt
     */
    public static Integer ggT(int f1, int f2) {
        int h = (f1 > f2) ? f2 : f1;
        for (int i = h; i > 1; i--) {
            if ((f1 % i) == 0 && (f2 % i) == 0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * Teste das E nach Rindal Bedingungen
     *
     * @param e
     * @param p
     * @param q
     * @return bool test_e
     */
    public static boolean test_e(int e, int p, int q) {
        return ggT(e, (p - 1) * (q - 1)) == 1;
    }

    /**
     * Legt ein D entsprechend Rindal fest
     *
     * @param
     * @return
     */
    public void generate_d() {
        for (int d = 0; d >= 20; d++) {
            if (1 == (var.getE() * d) % (var.getP() - 1) * (var.getQ() - 1)) {
                var.setD(d);
            }
            if (var.getD() == 0) {
                System.err.println("Kein D Gefunden");
                System.exit(8);
                /* Bricht mit Fehlermeldung ab */
            }
        }

    }

    /**
     * Eingabe eines Chars
     *
     * @param text
     * @return
     */
    public static char eingabe_chr(String text) {
        return (char) JOptionPane.showInputDialog(text).charAt(0);
    }

    /**
     * ueberprueft, ob es eine Primzahl ist
     *
     * @param value
     * @return boolean
     */
    static boolean isPrime(int value) {
        if (value < 2) {
            return false;
        }
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= value; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * Testet P,Q und alles andere;
     *
     * @param a
     * @return
     */
    public static boolean test_pq(int a) {
        boolean gamma = true;
        switch (a) {
            case 0:
                /* fuer p */
                if (Vars.getP() != 0) {
                } else {
                    gamma = false;
                }
                if (!isPrime(Vars.getP())) {
                } else {
                    gamma = false;
                }
                break;
            case 1:
                /* fuer q */
                if (Vars.getQ() != 0) {
                } else {
                    gamma = false;
                }
                if (!isPrime(Vars.getQ())) {
                } else {
                    gamma = false;
                }
                if (Vars.getP() == Vars.getQ()) {
                    gamma = false;
                }
                break;
            case 2:
                /* fuer e */
                if (Vars.getE() != 0) {
                } else {
                    gamma = false;
                }
                if (!isPrime(Vars.getE())) {
                } else {
                    gamma = false;
                }
                break;
            default:
                System.err.println("Du bist dumm!");
                System.exit(8);
        }
        return gamma;
    }
}
