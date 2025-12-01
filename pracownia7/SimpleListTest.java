package pracownia7;

import pracownia7.structures.SimpleList;
import java.util.Date;

import javax.xml.crypto.Data;
public class SimpleListTest {

    public static void main(String[] args) {
        testIntegers();
        testStrings();
        testDate();
    }

    private static void testIntegers() {
        System.out.println("SimpleList<Integer>");
        SimpleList<Integer> list = new SimpleList<>();

        list.insert(10, 0);
        list.insert(30, 1);
        list.insert(20, 1);

        System.out.println("Zawartosc (for-each):");
        for (Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("size = " + list.size());
        System.out.println("empty = " + list.empty());

        System.out.println("at(1) = " + list.at(1));
        System.out.println("index(30) = " + list.index(30));
        System.out.println("search(15) = " + list.search(15));

        System.out.println("max = " + list.max());
        System.out.println("min = " + list.min());

        list.remove((Integer) 20);
        list.remove(0);

        System.out.println("Po usunieciach (for-each):");
        for (Integer x : list) {
            System.out.print(x + " ");
        }
        System.out.println("\n");
    }

    private static void testStrings() {
        System.out.println("SimpleList<String>");
        SimpleList<String> list = new SimpleList<>();

        list.insert("Ala", 0);
        list.insert("Ola", 1);
        list.insert("Ela", 1);

        System.out.println("Zawartosc (for-each):");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println();

        System.out.println("max = " + list.max());
        System.out.println("min = " + list.min());

        list.remove("Ela");
        list.remove(0);

        System.out.println("Po usunieciach (for-each):");
        for (String s : list) {
            System.out.print(s + " ");
        }
        System.out.println("\n");
    }
    private static void testDate() {
        System.out.println("SimpleList<Date>");
        SimpleList<Date> list = new SimpleList<>();
        Date d1 = new Date(2025, 11, 01); //LocalDate
        Date d2 = new Date();  
        Date d3 = new Date(2004, 2, 19); //LocalDate

        list.insert(d1, 0);
        list.insert(d2, 1);
        list.insert(d3, 1);

        System.out.println("Zawartosc (for-each):");
        for (Date x : list) {
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println("size = " + list.size());
        System.out.println("empty = " + list.empty());

        System.out.println("at(1) = " + list.at(1));
        System.out.println("max = " + list.max());
        System.out.println("min = " + list.min());

        list.remove((Date) d1);
        list.remove(0);

        System.out.println("Po usunieciach (for-each):");
        for (Date x : list) {
            System.out.print(x + " ");
        }
        System.out.println("\n");
    }
}
