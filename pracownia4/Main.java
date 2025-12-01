package pracownia4;


public class Main {
    public static void main(String[] args) {
        ArraySetVar a = new ArraySetVar(10);
        a.set("x", 1.0);
        a.set("y", 2.5);
        a.set("z", -3.0);
        System.out.println("A: " + a);


        a.set("y", 7.0);
        System.out.println("A (po set y=7): " + a);



        a.del("x");
        System.out.println("A (po del x): " + a);


        ArraySetVar b = a.clone();
        System.out.println("B (klon A): " + b);
        b.set("y", 100.0);
        System.out.println("A po zmianie B: " + a);
        System.out.println("B po zmianie B: " + b);


        PairProb p = new PairProb(0.3, "p");
        System.out.println("PairProb: " + p);
        try {
            p.set(1.5); 
        } 
        catch (IllegalArgumentException ex) {
            System.out.println("OK, wyjątek dla p=1.5: " + ex.getMessage());
        }


        for (String n : a.names()) {
            System.out.println(n + " -> " + a.get(n));
        }
    }
}
