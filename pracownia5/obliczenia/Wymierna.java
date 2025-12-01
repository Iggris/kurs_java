package obliczenia;

/**
 * Klasa {@code Wymierna} reprezentuje liczbę wymierną w postaci
 * ułamka całkowitego {@code licznik/mianownik}.
 * Ułamek jest przechowywany w postaci nieskracalnej
 * (licznik i mianownik dzielone są przez ich największy wspólny dzielnik).
 * Mianownik nie może być równy zero, a znak ewentualnej liczby ujemnej
 * przenoszony jest do licznika.
 */
public class Wymierna implements Comparable<Wymierna> {

    /** Licznik ułamka. */
    private int licznik;

    /** Mianownik ułamka (nigdy nie jest równy zero). */
    private int mianownik;

    /**
     * Tworzy nową liczbę wymierną o wartości {@code licznik/mianownik}.
     * 
     * W konstruktorze:
     * 
     * sprawdzany jest mianownik (nie może być równy zero),
     * ułamek jest skracany przez podzielenie obu argumentów
     * przez ich największy wspólny dzielnik,
     * jeżeli mianownik jest ujemny, znak minus przenoszony jest
     * do licznika.
     * 
     *
     * @param licznik   licznik ułamka
     * @param mianownik mianownik ułamka; nie może być równy {@code 0}
     * @throws IllegalArgumentException jeżeli {@code mianownik == 0}
     */
    public Wymierna(int licznik, int mianownik) {
        if (denominator(mianownik)) {
            int divide = NWD(Math.abs(licznik), Math.abs(mianownik));
            if (mianownik < 0) {
                licznik = -licznik;
                mianownik = -mianownik;
            }
            this.licznik = licznik / divide;
            this.mianownik = mianownik / divide;
        }
    }

    /**
     * Tworzy liczbę całkowitą w postaci liczby wymiernej {@code licznik/1}.
     *
     * @param licznik wartość liczby całkowitej
     */
    public Wymierna(int licznik) {
        this(licznik, 1);
    }

    /**
     * Tworzy liczbę {@code 0} w postaci ułamka {@code 0/1}.
     */
    public Wymierna() {
        this(0, 1);
    }

    /**
     * Sprawdza poprawność mianownika.
     *
     * @param x wartość mianownika
     * @return zawsze {@code true}, jeżeli {@code x != 0}
     * @throws IllegalArgumentException jeżeli {@code x == 0}
     */
    private static boolean denominator(int x) {
        if (x == 0) {
            throw new IllegalArgumentException("Nie wolno dzielic przez 0");
        }
        return true;
    }

    /**
     * Zwraca mianownik ułamka.
     *
     * @return mianownik ułamka
     */
    public int getDen() {
        return mianownik;
    }

    /**
     * Zwraca licznik ułamka.
     *
     * @return licznik ułamka
     */
    public int getNum() {
        return licznik;
    }

    /**
     * Zwraca reprezentację tekstową liczby wymiernej.
     * Wynik ma postać {@code "Ulamek{licznik/mianownik}"}.
     *
     * @return łańcuch znakowy opisujący ułamek
     */
    @Override
    public String toString() {
        return "Ulamek{" + licznik + "/" + mianownik + "}";
    }

    /**
     * Sprawdza równość dwóch liczb wymiernych.
     * Dwie liczby są równe, jeżeli mają ten sam licznik i mianownik.
     *
     * @param o obiekt, z którym porównujemy tę liczbę
     * @return {@code true}, jeżeli obiekty reprezentują tę samą liczbę wymierną,
     *         w przeciwnym razie {@code false}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wymierna)) return false;
        Wymierna other = (Wymierna) o;
        return mianownik == other.mianownik && this.licznik == other.licznik;
    }

    /**
     * Zwraca sumę dwóch liczb wymiernych.
     *
     * @param x pierwsza liczba wymierna
     * @param y druga liczba wymierna
     * @return nowy obiekt {@code Wymierna} równy {@code x + y}
     */
    public static Wymierna add(Wymierna x, Wymierna y) {
        return new Wymierna(
                x.licznik * y.mianownik + y.licznik * x.mianownik,
                x.mianownik * y.mianownik
        );
    }

    /**
     * Zwraca różnicę dwóch liczb wymiernych.
     *
     * @param x pierwsza liczba wymierna
     * @param y druga liczba wymierna
     * @return nowy obiekt {@code Wymierna} równy {@code x - y}
     */
    public static Wymierna sub(Wymierna x, Wymierna y) {
        return new Wymierna(
                x.licznik * y.mianownik - y.licznik * x.mianownik,
                x.mianownik * y.mianownik
        );
    }

    /**
     * Zwraca iloczyn dwóch liczb wymiernych.
     *
     * @param x pierwsza liczba wymierna
     * @param y druga liczba wymierna
     * @return nowy obiekt {@code Wymierna} równy {@code x * y}
     */
    public static Wymierna mult(Wymierna x, Wymierna y) {
        return new Wymierna(
                x.licznik * y.licznik,
                x.mianownik * y.mianownik
        );
    }

    /**
     * Zwraca iloraz dwóch liczb wymiernych.
     *
     * @param x dzielna
     * @param y dzielnik; jego licznik nie może być równy {@code 0}
     * @return nowy obiekt {@code Wymierna} równy {@code x / y}
     * @throws ArithmeticException jeżeli {@code y.licznik == 0}
     */
    public static Wymierna div(Wymierna x, Wymierna y) {
        if (y.licznik == 0)
            throw new ArithmeticException("dzielenie przez 0");
        return new Wymierna(
                x.licznik * y.mianownik,
                x.mianownik * y.licznik
        );
    }

    /**
     * Oblicza największy wspólny dzielnik (NWD) dwóch liczb całkowitych
     * metodą Euklidesa.
     *
     * @param a pierwsza liczba (nieujemna)
     * @param b druga liczba (nieujemna)
     * @return największy wspólny dzielnik {@code a} i {@code b}
     */
    private static int NWD(int a, int b) {
        if (b == 0) return a;
        if (a==0) return b;
        return NWD(b, a % b);
    }

    /**
     * Porównuje tę liczbę wymierną z inną liczbą.
     *
     * @param arg0 obiekt {@code Wymierna}, z którym porównujemy
     * @return wartość dodatnią, jeżeli {@code this > arg0},
     *         wartość ujemną, jeżeli {@code this < arg0},
     *         {@code 0}, jeżeli liczby są równe
     */
    @Override
    public int compareTo(Wymierna arg0) {
        if (arg0.licznik * mianownik > licznik * arg0.mianownik) return 1;
        if (arg0.licznik * mianownik < licznik * arg0.mianownik) return -1;
        return 0;
    }
}
