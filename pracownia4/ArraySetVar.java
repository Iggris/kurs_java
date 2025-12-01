package pracownia4;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArraySetVar extends SetVar {
    protected Pair[] vars;
    protected int siz;

    public ArraySetVar(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("capacity < 0");
        this.vars = new Pair[capacity];
        this.siz  = 0;
    }

    protected int findIndex(String k) {
        for (int i = 0; i < siz; i++) {
            if (vars[i].key.equals(k)) return i;
        }
        return -1;
    }

    @Override
    public void set(String k, double v) {
        int idx = findIndex(k);
        if (idx >= 0) {
            vars[idx].set(v);
        } else {
            if (siz == vars.length) {
                throw new IllegalStateException("No space left in ArraySetVar");
            }
            vars[siz++] = new Pair(v,k);
        }
    }

    @Override
    public double get(String k) {
        int idx = findIndex(k);
        if (idx < 0) throw new NoSuchElementException("Variable not found: " + k);
        return vars[idx].get();
    }

    @Override
    public boolean search(String k) {
        return findIndex(k) >= 0;
    }

    @Override
    public String[] names() {
        String[] out = new String[siz];
        for (int i = 0; i < siz; i++) out[i] = vars[i].key;
        return out;
    }

    @Override
    public void del(String k) {
        int idx = findIndex(k);
        if (idx >= 0) {
            int numToMove = siz - idx - 1;
            if (numToMove > 0) {
                System.arraycopy(vars, idx + 1, vars, idx, numToMove);
            }
            vars[--siz] = null; 
        }
    }

    @Override
    public int size() {
        return siz;
    }

    @Override
    public void clear() {
        Arrays.fill(vars, 0, siz, null);
        siz = 0;
    }

    @Override
    public ArraySetVar clone() {
        ArraySetVar copy = (ArraySetVar) super.clone(); 
        copy.vars = vars.clone();
        for (int i = 0; i < this.siz; i++) {
            copy.vars[i] = this.vars[i].clone();
        }
        
        return copy;
    }

    @Override
    public String toString() {
        return defaultToString();
    }
}
