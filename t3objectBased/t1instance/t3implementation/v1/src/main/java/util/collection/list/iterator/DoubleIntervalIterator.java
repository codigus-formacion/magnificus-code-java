package util.collection.list.iterator;

import util.collection.list.node.DoubleIntervalNode;

public class DoubleIntervalIterator {

    private DoubleIntervalNode current;

    public DoubleIntervalIterator(DoubleIntervalNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public DoubleIntervalNode next(){
        assert this.hasNext();

        DoubleIntervalNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
