package util.collection.list.iterator;

import util.collection.list.node.FractionIntervalNode;
import util.values.FractionInterval;

public class FractionIntervalIterator {

    private FractionIntervalNode current;

    public FractionIntervalIterator(FractionIntervalNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public FractionInterval next(){
        assert this.hasNext();

        FractionInterval element = this.current.element();
        this.current = this.current.next();
        return element;
    }

}
