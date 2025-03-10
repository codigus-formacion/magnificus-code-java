package util.collection.list.iterator;

import util.collection.list.node.FractionIntervalNode;

public class FractionIntervalIterator {

    private FractionIntervalNode current;

    public FractionIntervalIterator(FractionIntervalNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public FractionIntervalNode next(){
        assert this.hasNext();

        FractionIntervalNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
