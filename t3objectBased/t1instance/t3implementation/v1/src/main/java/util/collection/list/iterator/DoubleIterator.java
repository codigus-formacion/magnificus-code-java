package util.collection.list.iterator;

import util.collection.list.node.DoubleNode;

public class DoubleIterator {

    private DoubleNode current;

    public DoubleIterator(DoubleNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public Double next(){
        assert this.hasNext();

        Double element = this.current.element();
        this.current = this.current.next();
        return element;
    }

}
