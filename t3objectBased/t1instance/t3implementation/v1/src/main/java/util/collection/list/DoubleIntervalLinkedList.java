package util.collection.list;

import util.collection.list.iterator.DoubleIntervalIterator;
import util.collection.list.node.DoubleIntervalNode;
import util.values.DoubleInterval;
import util.values.IntegerInterval;

public class DoubleIntervalLinkedList {

    private DoubleIntervalNode head;
    private DoubleIntervalNode last;

    public DoubleIntervalLinkedList() {
        this.head = null;
        this.last = null;
    }

    public DoubleIntervalLinkedList(DoubleInterval... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (DoubleInterval element : elements) {
            this.add(element);
        }
    }

    public boolean add(DoubleInterval element) {
        assert element != null : "Element cannot be null";

        DoubleIntervalNode last = new DoubleIntervalNode(this.last, element);
        if (this.isEmpty()) {
            this.head = last;
        } else {
            this.last.setNext(last);
        }
        this.last = last;
        return true;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        DoubleIntervalIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public DoubleIntervalIterator iterator() {
        return new DoubleIntervalIterator(this.head);
    }

    public DoubleInterval get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        DoubleIntervalIterator iterator = this.iterator();
        DoubleInterval doubleInterval = iterator.next();
        while (position > 0) {
            doubleInterval = iterator.next();
            position--;
        }
        return doubleInterval;
    }

    public String toString() {
        String toString = "";
        DoubleIntervalIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

}
