package util.collection.list;

public class Iterator<T> {

    private LinkedList.Node<T> current;

    public Iterator(LinkedList.Node<T> head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public LinkedList.Node<T> next(){
        assert this.hasNext();

        LinkedList.Node<T> element = this.current;
        this.current = this.current.next();
        return element;
    }

}
