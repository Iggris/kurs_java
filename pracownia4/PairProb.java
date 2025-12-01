package pracownia4;

public class PairProb extends Pair {

    public PairProb(double value, String key) {
        super(valueInRange(value), key);
    }
    @Override
    public void set(double val) {
        super.set(valueInRange(val));
    }
    private static double valueInRange(double v) {
        if (v < 0.0 || v > 1.0) {
            throw new IllegalArgumentException("przedzial musi byc [0,1]");
        }
        return v;
    }
}
