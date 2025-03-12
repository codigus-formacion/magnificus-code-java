package util.collection.list.iterator;

import util.collection.list.node.TimeNode;
import util.values.Time;

public class TimeIterator {

    private TimeNode current;

    public TimeIterator(TimeNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public Time next(){
        assert this.hasNext();

        Time element = this.current.element();
        this.current = this.current.next();
        return element;
    }

}
