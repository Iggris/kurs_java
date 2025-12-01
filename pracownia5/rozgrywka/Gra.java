package rozgrywka;

import obliczenia.Wymierna;

import java.util.Scanner;
import java.util.logging.Logger;

public class Gra {
    private static final Logger logger = Logger.getLogger(Gra.class.getName());

    private int zakres;
    private Wymierna liczba;
    private int maksIlośćPrób;
    private int licznikProb;

    public void start(int z) {
        if (z < 5 || z > 20) {
            throw new IllegalArgumentException("Liczba musi byc w zakresie 5–20, podano: " + z);
        }

        zakres = z;

        int licz, mian;
        //do {
            licz = (int) (Math.random() * zakres) + 1;
            mian = (int) (Math.random() * zakres) + 1;
//        } while (licz >= mian);

        liczba = new Wymierna(licz, mian);
        licznikProb = 0;
        maksIlośćPrób = (int) Math.ceil(3 * Math.log(zakres));

        assert liczba.getNum() > 0 && liczba.getNum() < liczba.getDen();
    }

    private Wymierna wczytajStrzal(String tekst)
        throws WymiernaInputException {

            tekst = tekst.trim();
            String[] parts = tekst.split("/");

            if (parts.length != 2) {
                throw new WymiernaFormatException("Oczekiwano formatu a/b");
            }

            int a, b;
            try {
                a = Integer.parseInt(parts[0].trim());
                b = Integer.parseInt(parts[1].trim());
            } 
            catch (NumberFormatException e) {
                throw new WymiernaFormatException("Licznik i mianownik muszą być liczbami calkowitymi", e);
            }

            if (b <= 0) {
                throw new WymiernaOutOfRangeException("Mianownik musi byc dodatni.");
            }

            if (b > zakres) {
                throw new WymiernaDenominatorTooBigException("Mianownik nie moze byc wiekszy niz " + zakres);
            }

            Wymierna w = new Wymierna(a, b);

            if (!(w.getNum() > 0 && w.getNum() < w.getDen())) {
                throw new WymiernaOutOfRangeException("Liczba musi byc z przedzialu (0,1)");
            }

            return w;
        }

    public void graj() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj swoje imie: ");
        String imie = sc.nextLine().trim();
        logger.info("Nowa rozgrywka, gracz: " + imie);

        long startCzas = System.currentTimeMillis();

        System.out.println("Zgadnij liczbe wymierna z przedzialu (0,1)");
        System.out.println("Zakres mianownika: 1.." + zakres);
        System.out.println("Masz maksymalnie " + maksIlośćPrób + " prob.");
        System.out.println("Podawaj liczby w formacie a/b, np. 1/3. Wpisz 'q', aby się poddac.\n");

        while (licznikProb < maksIlośćPrób) {
            System.out.println("Proba " + (licznikProb + 1) + " z " + maksIlośćPrób);
            System.out.print("Twoj strzal (a/b lub q): ");
            String linia = sc.nextLine().trim();

            if (linia.equalsIgnoreCase("q")) {
                logger.info("Gracz " + imie + " poddal sie.");
                System.out.println("Poddajesz sie. Przegrales.");
                System.out.println("Szukana liczba to: " + liczba);
                break;
            }

            try {
                Wymierna strzal = wczytajStrzal(linia);
                logger.info("Gracz " + imie + " podal: " + strzal);

                licznikProb++;

                int cmp = strzal.compareTo(liczba);

                if (cmp == 0) {
                    logger.info("Gracz " + imie + " wygral. Trafiona liczba: " + liczba+ " w " + licznikProb + " probach.");
                    System.out.println("Brawo, zgadłes liczbe: " + liczba);
                    break;
                } else if (cmp > 0) {
                    System.out.println("Za malo.");
                } else {
                    System.out.println("Za duzo.");
                }

                System.out.println("Pozostalo prob: " + (maksIlośćPrób - licznikProb));
                System.out.println();

            } catch (WymiernaInputException e) {
                logger.warning("Bledne dane od gracza " + imie + ": " + e.getMessage());
                System.out.println("Blad: " + e.getMessage());

                licznikProb++;
                System.out.println("Ta proba zostala wykorzystana. Pozostalo prob: "+ (maksIlośćPrób - licznikProb));
                System.out.println();
            }
        }

        long czasTrwania = System.currentTimeMillis() - startCzas;
        logger.info("Czas trwania rozgrywki: " + czasTrwania + " ms");

        if (licznikProb >= maksIlośćPrób && liczba != null) {
            logger.info("Gracz " + imie + " przegral. Szukana liczba: " + liczba);
            System.out.println("Koniec prob. Przegrales.");
            System.out.println("Szukana liczba to: " + liczba);
        }
    }
}
