package pracownia2.figury;

public class Odcinek {
    private Punkt poczatek;
    private Punkt koniec;
    public Odcinek(Punkt poczatek, Punkt koniec){
        if(zle_dane(poczatek,koniec)){
            throw new IllegalArgumentException("2 punkty sa takie same");
        }
        this.poczatek=poczatek;
        this.koniec=koniec;
    }
    private boolean zle_dane(Punkt a, Punkt b){
        return a.getX()==b.getX() && b.getY()==a.getY();
    }
    public Punkt getPOCZATEK() { return poczatek; }
    public Punkt getKONIEC() { return koniec; }
    public Odcinek przesun(Wektor v) {
        return new Odcinek(poczatek.przesun(v), koniec.przesun(v));
    }

    public Odcinek obroc(Punkt p, double kat) {
        return new Odcinek(poczatek.obroc(p, kat), koniec.obroc(p, kat));
    }

    public Odcinek odbij(Prosta l) {
        return new Odcinek(poczatek.odbij(l), koniec.odbij(l));
    }    
}
