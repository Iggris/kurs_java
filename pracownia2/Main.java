package pracownia2;

import pracownia2.figury.*;

public class Main {
    public static void main(String[] args) {
        Punkt p = new Punkt(1, 2);
        Wektor v = new Wektor(3, -1);
        Punkt p2 = p.przesun(v);
        System.out.println("Punkt przesuniety o wektor (3,-1): (" + p2.getX() + ", " + p2.getY() + ")");

        Punkt srodek = new Punkt(0, 0);
        Punkt p3 = p.obroc(srodek, Math.PI / 2);
        System.out.println("Punkt (1,2) obrocony o 90 stopni wokol (0,0): (" + 
                           String.format("%.3f", p3.getX()) + ", " + String.format("%.3f", p3.getY()) + ")");

        Prosta oX = new Prosta(0, 1, 0); // y=0
        Punkt p4 = p.odbij(oX);
        System.out.println("Punkt (1,2) odbity wzgledem osi X: (" + p4.getX() + ", " + p4.getY() + ")");

        System.out.println("Wektor");
        Wektor w1 = new Wektor(1, 2);
        Wektor w2 = new Wektor(3, 4);
        Wektor w3 = Wektor.skladanie(w1, w2);
        System.out.println("Skladanie wektorow (1,2) i (3,4): (" + w3.dx + ", " + w3.dy + ")");

        System.out.println("Odcinek");
        Punkt a = new Punkt(0, 0);
        Punkt b = new Punkt(2, 0);
        Odcinek odc = new Odcinek(a, b);
        Odcinek odcPrzes = odc.przesun(new Wektor(1, 1));
        System.out.println("Odcinek po przesunieciu o (1,1): A(" + odcPrzes.getPOCZATEK().getX() + "," + odcPrzes.getPOCZATEK().getY() +
        "), B(" + odcPrzes.getKONIEC().getX() + "," + odcPrzes.getKONIEC().getY() + ")");

        Odcinek odcObr = odc.obroc(new Punkt(0, 0), Math.PI / 2);
        System.out.println("Odcinek obrocony o 90 stopni wokol (0,0): A(" + odcObr.getPOCZATEK().getX() + "," + odcObr.getPOCZATEK().getY() +
        "), B(" + odcObr.getKONIEC().getX() + "," + odcObr.getKONIEC().getY() + ")");

        Odcinek odcOdb = odc.odbij(oX);
        System.out.println("Odcinek odbity wzgledem osi X: A(" + odcOdb.getPOCZATEK().getX() + "," + odcOdb.getPOCZATEK().getY() +
        "), B(" + odcOdb.getKONIEC().getX() + "," + odcOdb.getKONIEC().getY() + ")");

        System.out.println("Trojkat");
        Trojkat t = new Trojkat(new Punkt(0, 0), new Punkt(1, 0), new Punkt(0, 1));
        Trojkat t2 = t.przesun(new Wektor(2, 3));
        System.out.println("Trojkat po przesunieciu o (2,3):");
        wypiszTrojkat(t2);

        Trojkat t3 = t.obroc(new Punkt(0, 0), Math.PI / 2);
        System.out.println("Trojkat obrocony o 90 stopni wokol (0,0):");
        wypiszTrojkat(t3);

        Trojkat t4 = t.odbij(oX);
        System.out.println("Trojkat odbity wzgledem osi X:");
        wypiszTrojkat(t4);

        System.out.println("Prosta");
        Prosta l1 = new Prosta(1, 1, -2); // x + y - 2 = 0
        Prosta l2 = new Prosta(1, -1, 0); // x - y = 0

        System.out.println(Prosta.sprawdzenie(l1, l2));
        Prosta l3 = Prosta.przesun(l1, new Wektor(1, 1));
        System.out.println("Prosta p1 po przesunieciu o (1,1): " + l3.a + "x + " + l3.b + "y + " + l3.c + " = 0");
    }

    private static void wypiszTrojkat(Trojkat t) {
        System.out.println("  A(" + t.getPUNKT1().getX() + "," + t.getPUNKT1().getY() + ")");
        System.out.println("  B(" + t.getPUNKT2().getX() + "," + t.getPUNKT2().getY() + ")");
        System.out.println("  C(" + t.getPUNKT3().getX() + "," + t.getPUNKT3().getY() + ")");
    }
}
