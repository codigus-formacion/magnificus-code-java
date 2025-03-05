package util.collection.list;

import util.values.interval.IntegerInterval;

public class IntegerIntervalLinkedList {

    protected IntegerIntervalNode head;
    protected IntegerIntervalNode last;

    public IntegerIntervalLinkedList() {
        this.head = null;
        this.last = null;
    }

    public IntegerIntervalLinkedList(IntegerInterval... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (IntegerInterval element : elements) {
            this.add(element);
        }
    }

    public static IntegerIntervalLinkedList of(IntegerInterval... elements) {
        return new IntegerIntervalLinkedList(elements);
    }

    public static IntegerIntervalLinkedList empty() {
        return new IntegerIntervalLinkedList();
    }

    public boolean add(IntegerInterval element) {
        assert element != null : "Element cannot be null";

        IntegerIntervalNode last = new IntegerIntervalNode(this.last, element);
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

    public IntegerIntervalIterator iterator() {
        return new IntegerIntervalIterator(this.head);
    }

    public String toString() {
        String toString = "";
        IntegerIntervalIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public IntegerInterval get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        IntegerIntervalNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        IntegerIntervalNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected IntegerIntervalNode head() {
        return this.head();
    }

}
