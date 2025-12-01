package pracownia2.figury;

public class Prosta {
    public final double a;
    public final double b;
    public final double c;
    public Prosta(double a, double b, double c){
        if(zle_dane(a,b,c)){
            throw new IllegalArgumentException("2 punkty sa zerowe");
        }
        this.a=a;
        this.b=b;
        this.c=c;
    }
    private boolean zle_dane(double a, double b, double c){
        return a==0 && b==0;
    }
    public static Prosta przesun(Prosta l, Wektor p){
        return new Prosta(l.a,l.b ,l.c-l.a*p.dx-l.b*p.dy);
    }
    public static String sprawdzenie(Prosta l1, Prosta l2){
        if(l1.a*l2.b==l1.b*l2.a){
            return "Proste są rownolegle";
        }
        else{
            if(l1.a*l2.a+l1.b+l2.b==0){
                return "Proste są prostopadle i przecinaja się w punkcie: (" +
                (l1.c*l2.b-l2.c*l1.b)/(l2.a*l1.b-l1.a*l2.b) +"," 
                +((-l1.a/l1.b)*((l1.c*l2.b-l2.c*l1.b)/(l2.a*l1.b-l1.a*l2.b))-(l1.c/l1.b)) +")";
            }
            return "nie są ani prostopadle ani rownolegle i przecinają się w punkcie: ("+
            (l1.c*l2.b-l2.c*l1.b)/(l2.a*l1.b-l1.a*l2.b) +"," 
            +((-l1.a/l1.b)*((l1.c*l2.b-l2.c*l1.b)/(l2.a*l1.b-l1.a*l2.b))-(l1.c/l1.b)) +")";
        }
    }
    
}
