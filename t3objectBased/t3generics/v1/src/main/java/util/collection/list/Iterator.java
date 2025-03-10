package util.collection.list;

public class Iterator<T> {

    private Node<T> current;

    public Iterator(Node<T> head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public Node<T> next(){
        assert this.hasNext();

        Node<T> element = this.current;
        this.current = this.current.next();
        return element;
    }

}
