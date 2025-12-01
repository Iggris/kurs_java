package pracownia4;

public abstract class SetVar implements AssociativeCollection {
    public abstract void clear();
    @Override
    public SetVar clone() {
        try {
            return (SetVar) super.clone(); 
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return defaultToString();
    }
    
}
