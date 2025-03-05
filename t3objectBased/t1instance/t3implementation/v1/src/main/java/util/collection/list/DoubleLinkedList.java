package util.collection.list;

import util.values.interval.IntegerInterval;

public class DoubleLinkedList {

    protected DoubleNode head;
    protected DoubleNode last;

    public DoubleLinkedList() {
        this.head = null;
        this.last = null;
    }

    public DoubleLinkedList(Double... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (Double element : elements) {
            this.add(element);
        }
    }

    public static DoubleLinkedList of(Double... elements) {
        return new DoubleLinkedList(elements);
    }

    public static DoubleLinkedList empty() {
        return new DoubleLinkedList();
    }

    public boolean add(Double element) {
        assert element != null : "Element cannot be null";

        DoubleNode last = new DoubleNode(this.last, element);
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

    public DoubleIterator iterator() {
        return new DoubleIterator(this.head);
    }

    public String toString() {
        String toString = "";
        DoubleIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public Double get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        DoubleNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        DoubleNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected DoubleNode head() {
        return this.head();
    }

}
