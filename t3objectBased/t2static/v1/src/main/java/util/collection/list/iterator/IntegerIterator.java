package util.collection.list.iterator;

import util.collection.list.node.IntegerNode;

public class IntegerIterator {

    private IntegerNode current;

    public IntegerIterator(IntegerNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public IntegerNode next(){
        assert this.hasNext();

        IntegerNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
