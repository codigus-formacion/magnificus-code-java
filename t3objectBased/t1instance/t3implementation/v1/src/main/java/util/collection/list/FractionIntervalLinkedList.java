package util.collection.list;

import util.values.interval.FractionInterval;
import util.values.interval.IntegerInterval;

public class FractionIntervalLinkedList {

    protected FractionIntervalNode head;
    protected FractionIntervalNode last;

    public FractionIntervalLinkedList() {
        this.head = null;
        this.last = null;
    }

    public FractionIntervalLinkedList(FractionInterval... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (FractionInterval element : elements) {
            this.add(element);
        }
    }

    public static FractionIntervalLinkedList of(FractionInterval... elements) {
        return new FractionIntervalLinkedList(elements);
    }

    public static FractionIntervalLinkedList empty() {
        return new FractionIntervalLinkedList();
    }

    public boolean add(FractionInterval element) {
        assert element != null : "Element cannot be null";

        FractionIntervalNode last = new FractionIntervalNode(this.last, element);
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

    public FractionIntervalIterator iterator() {
        return new FractionIntervalIterator(this.head);
    }

    public String toString() {
        String toString = "";
        FractionIntervalIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public FractionInterval get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        FractionIntervalNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        FractionIntervalNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected FractionIntervalNode head() {
        return this.head();
    }

}
