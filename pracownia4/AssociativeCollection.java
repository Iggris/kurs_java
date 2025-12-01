package pracownia4;

public interface AssociativeCollection extends Cloneable, AssocColl{
    void del(String k);
    int size();
    
    
    AssociativeCollection clone();
    @Override
    default String defaultToString(){
        return "Assoc[size=" + size() + "] " + AssocColl.super.defaultToString();
    }

    
}
