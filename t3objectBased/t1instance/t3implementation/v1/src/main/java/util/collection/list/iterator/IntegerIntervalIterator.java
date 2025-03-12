package util.collection.list.iterator;

import util.collection.list.node.IntegerIntervalNode;
import util.values.IntegerInterval;

public class IntegerIntervalIterator {

    private IntegerIntervalNode current;

    public IntegerIntervalIterator(IntegerIntervalNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public IntegerInterval next(){
        assert this.hasNext();

        IntegerInterval element = this.current.element();
        this.current = this.current.next();
        return element;
    }

}
