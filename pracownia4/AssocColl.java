package pracownia4;


public interface AssocColl {
    void set(String k, double v);
    double get(String k);
    boolean search(String k);
    String[] names();


    default String defaultToString(){
        String[] ns = names();
        StringBuilder ans = new StringBuilder("{");
        for(int i=0;i<ns.length;i++){
            if (i>0)ans.append(", ");
            ans.append(ns[i]).append("=").append(get(ns[i]));
        }
        ans.append("}");
        return ans.toString();
    }
}
