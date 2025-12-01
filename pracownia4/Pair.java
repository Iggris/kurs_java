package pracownia4;

import java.util.Objects;

public class Pair implements Cloneable {
    public final String key;
    private double value;
    
    public Pair(double value, String key){
        if(key==null || key.isEmpty() ||"abcdefghijklmnoprstowzgyz".indexOf(key) == -1){
            throw new IllegalArgumentException();
        }
        this.key=key;
        this.value=value;
    }
    public double get() {
        return value;
    }

    public void set(double val) {
        this.value = val;
    }


    @Override
    public String toString() {
        return "Pair{key='" + key + "', value=" + value + "}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair)) return false; 
        Pair other = (Pair) o;
        return Objects.equals(this.key, other.key);
    }
    @Override
    public Pair clone() {
        try {
            return (Pair) super.clone(); 
        } 
        catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

}
