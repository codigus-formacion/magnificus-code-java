package util.collection.list.iterator;

import util.collection.list.node.FractionNode;
import util.values.Fraction;

public class FractionIterator {

    private FractionNode current;

    public FractionIterator(FractionNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public Fraction next(){
        assert this.hasNext();

        Fraction element = this.current.element();
        this.current = this.current.next();
        return element;
    }

}
