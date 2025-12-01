package pracownia2.figury;

public class Trojkat {
    private Punkt punkt1;
    private Punkt punkt2;
    private Punkt punkt3;
    public Trojkat(Punkt punkt1, Punkt punkt2, Punkt punkt3){
        if(wspolliniowe(punkt1,punkt2,punkt3)){
            throw new IllegalArgumentException("3 punkty sa wspolliniowe");
        }
        this.punkt1=punkt1;
        this.punkt2=punkt2;
        this.punkt3=punkt3;

    }
    public Punkt getPUNKT1() { return punkt1; }
    public Punkt getPUNKT2() { return punkt2; }
    public Punkt getPUNKT3() { return punkt3; }

    private boolean wspolliniowe(Punkt x, Punkt y, Punkt z){
        double a = (x.getY()-y.getY())/(x.getX()-y.getX());
        double b = (x.getX()*y.getY()-x.getY()*y.getX())/(x.getX()-y.getX()); 
        return z.getY()==a*z.getX()+b;
    }
    public Trojkat przesun(Wektor v) {
        return new Trojkat(punkt1.przesun(v), punkt2.przesun(v), punkt3.przesun(v));
    }

    public Trojkat obroc(Punkt p, double kat) {
        return new Trojkat(punkt1.obroc(p, kat), punkt2.obroc(p, kat), punkt3.obroc(p, kat));
    }

    public Trojkat odbij(Prosta l) {
        return new Trojkat(punkt1.odbij(l), punkt2.odbij(l), punkt3.odbij(l));
    }
    
}
