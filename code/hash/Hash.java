package hash;

/* Brauchst du wenn du mit dem Hash arbeiten willst */
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Stertzing, Ronny
 */

public class Hash {

    /* MAIN-FKT --> ab hier geht es los */
    public static void main(String[] args) throws NoSuchAlgorithmException {
        /* Einstieg in das Main Programm */

        /* Das hier ist nur fuer die Ermitlung von D */
        SetFuncs func = new SetFuncs() {
        };

        /* Eingabe von P */
        do {
            Vars.setP(SetFuncs.eingabe("Bitte geben Sie ein P ein"));
        } while (SetFuncs.test_pq(0));

        /* Eingabe von Q */
        do {
            Vars.setQ(SetFuncs.eingabe("Bitte geben Sie ein Q ein"));
        } while (SetFuncs.test_pq(1));

        /* Eingabe von e */
        do {
            Vars.setQ(SetFuncs.eingabe("Bitte geben Sie ein e ein"));
        } while (SetFuncs.test_pq(2));

        /* Berechnung des privaten Schluessels */
        func.generate_d();

        /* Berechnung des oeffentlichen Schluessels. */
        Vars.setN(Vars.getP() * Vars.getQ());

        /* Eingeben der Nachricht */
        Vars.setM(SetFuncs.eingabe_chr("Bitte geben Sie ein Zeichen ein"));

        /* Umrechnen nach ASCII Tabelle */
        // System.out.println((int) Vars.getM());

        /* Verschluesseln */
        Vars.setC((Vars.getM() ^ Vars.getE()) % Vars.getN());

        /* SET HASH */
        System.out.println("Hash-Algo: MD5");
        System.out.println("Klartext: " + SetFuncs.getHash((String.valueOf(Vars.getM()))));
        System.out.println("Encrypt: " + SetFuncs.getHash((String.valueOf(Vars.getC()))));
    }
}
