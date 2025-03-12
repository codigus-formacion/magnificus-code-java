package util.collection.list.iterator;

import util.collection.list.node.DoubleIntervalNode;
import util.values.DoubleInterval;

public class DoubleIntervalIterator {

    private DoubleIntervalNode current;

    public DoubleIntervalIterator(DoubleIntervalNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public DoubleInterval next(){
        assert this.hasNext();

        DoubleInterval element = this.current.element();
        this.current = this.current.next();
        return element;
    }

}
