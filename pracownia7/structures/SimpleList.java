package pracownia7.structures;

import java.util.Iterator;

public class SimpleList<T extends Comparable<T>> implements SimpleSequence<T>, Iterable<T> {
    private  class SimpleNode{
        private SimpleNode prev, next;
        T data;
        SimpleNode(T data) {
            if (data == null) {
                throw new NullPointerException("null values not allowed");
            }
            this.data = data;
        }
        private void remove(SimpleNode dummy){
            if (dummy.prev == null && dummy.next == null) 
                head = null;
            else if (dummy.prev == null) {
                head = dummy.next;
                head.prev = null;
            } 
            else if (dummy.next == null)
                dummy.prev.next = null;
            else{
                dummy.prev.next = dummy.next;
                dummy.next.prev = dummy.prev;
            }

        }
    }
    private class SimpleListIterator implements java.util.Iterator<T>{
        private SimpleNode dummy = head;
        private final int expectedModCount;

        SimpleListIterator() {
            this.expectedModCount = SimpleList.this.modCount;
        }    
        private void checkForModification() {
            if (expectedModCount != SimpleList.this.modCount) 
                throw new IllegalStateException("Kolekcja zostala zmodyfikowana podczas iteracji");
        }
        @Override
        public boolean hasNext() {
            checkForModification();
            return dummy != null;
        }
        @Override
        public T next() {
            checkForModification();
            if (dummy == null)
                throw new java.util.NoSuchElementException();
            
            T value = dummy.data;
            dummy = dummy.next;
            return value;
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    
    private SimpleNode head;
    // ... implementacja SimpleSequence<T>
    private int lnght=0;
    private int modCount = 0;
    @Override
    public String toString() { return ""; }
    @Override
    public void insert(T el, int pos) {
        if (head == null && pos!=0) {
            throw new IllegalStateException("lista jest pusta");
        }
        if(pos<0 || pos>=lnght+1){
            throw new IllegalStateException("bledny indeks");
        }
        SimpleNode newNode = new SimpleNode(el);
        if(pos==0){
            if (head == null) {
                head = newNode;
                lnght++;
                modCount++;
                return;
            }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            lnght++;
            modCount++;
            return;   
        }
        if (pos==lnght){
            SimpleNode dummy =head;
            while(dummy.next!=null){
                dummy=dummy.next;
            }
            dummy.next=newNode;
            newNode.prev=dummy;
            newNode.next=null;
            lnght++;
            modCount++;
            return;
        }
        SimpleNode dummy=head;
        for(int i=0;i<pos;i++){
            dummy=dummy.next;
        }
        SimpleNode before = dummy.prev;
        before.next = newNode;
        newNode.prev = before;
        newNode.next = dummy;
        dummy.prev = newNode;
        lnght++;
        modCount++;
    }
    @Override
    public void remove(T el) {
        if (head == null) {
            throw new IllegalStateException("lista jest pusta");
        }

        SimpleNode dummy = head;
        while (dummy != null && !dummy.data.equals(el)) {
            dummy = dummy.next;
        }

        if (dummy == null) {
            throw new IllegalStateException("Brak takiego elementu w liście");
        }
        head.remove(dummy);

        lnght--;
        modCount++;
    }

    @Override
    public void remove(int pos) {
        if (head == null) {
            throw new IllegalStateException("lista jest pusta");
        }
        if (pos>=lnght || pos<0){
            throw new IllegalStateException("nie ma takiego indeksu");
        }
        SimpleNode dummy = head;
        for (int i = 0; i < pos; i++) 
            dummy = dummy.next;

        head.remove(dummy);
        lnght--;
        modCount++;
    }
    @Override
    public T max() {
        if (head == null) {
            throw new IllegalStateException("lista jest pusta");
        }
        T best = head.data;
        SimpleNode current = head.next;
        while(current!=null){
            if (current.data.compareTo(best) > 0) {
                best = current.data;
            }
            current = current.next;
        }
        return best;
    }
    @Override
    public T min() {
        if (head == null) {
            throw new IllegalStateException("lista jest pusta");
        }
        T worst = head.data;
        SimpleNode current = head.next;
        while(current!=null){
            if (current.data.compareTo(worst) < 0) {
                worst = current.data;
            }
            current = current.next;
        }
        return worst;
    }
    @Override
    public boolean search(T el){
        if (head == null) {
            throw new IllegalStateException("lista jest pusta");
        }
        SimpleNode dummy =head;
        while(dummy!=null){
            if(dummy.data.equals(el))
                return true;
            dummy=dummy.next;
        }
        return false;
    }
    @Override
    public T at(int pos) {
        if (head == null) {
            throw new IllegalStateException("lista jest pusta");
        }
        if (pos < 0 || pos >= lnght) {
            throw new IllegalArgumentException("błędny indeks");
        }
        SimpleNode dummy = head;
        for (int i = 0; i < pos; i++) {
            dummy = dummy.next;
        }
        return dummy.data;
    }
    @Override
    public int index(T el) {
        if (head == null) {
            throw new IllegalStateException("lista jest pusta");
        }
        SimpleNode dummy=head;
        int start=0;
        while(dummy!=null){
            if(dummy.data.equals(el))
                return start;
            dummy=dummy.next;
            start++;
        }
        return -1;
        
    }
    @Override
    public int size() {

        return lnght;
    }
    @Override
    public boolean empty() {
        return size()==0;
    }
    @Override
    public Iterator<T> iterator() {
        return new SimpleListIterator();
    }
}

    

