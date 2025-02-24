package util.collections.list;

public class Iterator<T> {
    
    private Node<T> current;

    public Iterator(Node<T> first){
        this.current = first;
    }

    public boolean hasNext() {
        return this.current.isLast();
    }

    public T next() {
        T next = this.current.get();
        this.current = this.current.getNext();
        return next;
    }
}

