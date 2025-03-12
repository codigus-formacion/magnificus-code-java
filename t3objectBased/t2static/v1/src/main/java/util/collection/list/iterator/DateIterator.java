package util.collection.list.iterator;

import util.collection.list.node.DateNode;
import util.values.Date;

public class DateIterator {

    private DateNode current;

    public DateIterator(DateNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public Date next(){
        assert this.hasNext();

        Date element = this.current.element();
        this.current = this.current.next();
        return element;
    }

}
