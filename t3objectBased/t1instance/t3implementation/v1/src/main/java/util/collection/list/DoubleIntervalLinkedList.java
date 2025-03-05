package util.collection.list;

import util.values.interval.DoubleInterval;
import util.values.interval.IntegerInterval;

public class DoubleIntervalLinkedList {

    protected DoubleIntervalNode head;
    protected DoubleIntervalNode last;

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

    public static DoubleIntervalLinkedList of(DoubleInterval... elements) {
        return new DoubleIntervalLinkedList(elements);
    }

    public static DoubleIntervalLinkedList empty() {
        return new DoubleIntervalLinkedList();
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

    private boolean isEmpty() {
        return this.head == null;
    }

    public DoubleIntervalIterator iterator() {
        return new DoubleIntervalIterator(this.head);
    }

    public String toString() {
        String toString = "";
        DoubleIntervalIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public DoubleInterval get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        DoubleIntervalNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        DoubleIntervalNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected DoubleIntervalNode head() {
        return this.head();
    }

}
