package pracownia7;

import pracownia7.structures.SimpleList;

public class SimpleListTest {

    public static void main(String[] args) {
        testIntegers();
        testStrings();
    }

    private static void testIntegers() {
        System.out.println("SimpleList<Integer>");
        SimpleList<Integer> list = new SimpleList<>();

        list.insert(10, 0);   // [10]
        list.insert(30, 1);   // [10, 30]
        list.insert(20, 1);   // [10, 20, 30]

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
}
