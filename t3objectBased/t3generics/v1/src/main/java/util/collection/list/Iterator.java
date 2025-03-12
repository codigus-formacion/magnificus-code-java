package util.collection.list;

public class Iterator<T> {

    private Node<T> current;

    public Iterator(Node<T> head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public T next(){
        assert this.hasNext();

        T element = this.current.element();
        if (this.current.isLast()){
            this.current = null;
        } else {
            this.current = this.current.next().get();
        }
        return element;
    }

}
