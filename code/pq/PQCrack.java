package pq_crack;

/**
 *
 * @author Stertzing, Ronny
 */
public class PQCrack {

    public static final int size = 0x7fffffff; // 4 Bit for int

    public static void main(String[] args) {
        /* loeschen aller Steuerelemente */
        if (args.length != 0) {
            args = null;
        }

        /* MAIN-FKT --> ab hier geht es los */

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

        /* main */
        for (int x = 0; x <= size; x++) {
            for (int y = 0; y <= size; y++) {
                if (Vars.getP() == x && y == Vars.getQ()) {
                    System.out.println("pq ist richtig");
                    System.out.println("q: " + y + "\n" + "p: " + x);
                    System.exit(0);
                }
            }
        }
    }
}
