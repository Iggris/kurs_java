package pracownia7.structures;

public interface SimpleSequence<T extends Comparable<T>> {
    public void  insert(T el, int pos);
    public void remove(T el);
    public void remove(int pos);
    public T max();
    public T min();
    public boolean search(T el);
    public T at(int pos);
    public int index(T el);
    public int size();
    public boolean empty();

}