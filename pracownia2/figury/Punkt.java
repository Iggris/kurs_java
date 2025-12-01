package pracownia2.figury;

public class Punkt {
    private double x;
    private double y;
    public Punkt(double x, double y){
        this.x=x;
        this.y=y;
    }
    public double getX() { return x; }
    public double getY() { return y; }
    public Punkt przesun(Wektor v){
        return new Punkt(this.x+v.dx, this.y+v.dy);
    }
    public Punkt obroc(Punkt p, double kąt){
        double cos = Math.cos(kąt);
        double sin = Math.sin(kąt);

        double xPrim = this.x + (p.x - this.x) * cos - (p.y - this.y) * sin;
        double yPrim = this.y + (p.x - this.x) * sin + (p.y - this.y) * cos;

        return new Punkt(xPrim, yPrim); 
    }
    public Punkt odbij(Prosta p){

        double xPrim= this.x -(2*p.a*(p.a*this.x+p.b*this.y+p.c)/(p.a*p.a+p.b*p.b));
        double yPrim= this.y -(2*p.b*(p.a*this.x+p.b*this.y+p.c)/(p.a*p.a+p.b*p.b));
        return new Punkt(xPrim,yPrim);
    }
    
}
