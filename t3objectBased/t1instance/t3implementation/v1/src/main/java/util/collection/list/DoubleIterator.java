package util.collection.list;

public class DoubleIterator {

    private DoubleNode current;

    public DoubleIterator(DoubleNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public DoubleNode next(){
        assert this.hasNext();

        DoubleNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
