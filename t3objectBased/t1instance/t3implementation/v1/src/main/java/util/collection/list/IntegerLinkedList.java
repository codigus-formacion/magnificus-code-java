package util.collection.list;

import util.values.interval.IntegerInterval;

public class IntegerLinkedList {

    protected IntegerNode head;
    protected IntegerNode last;

    public IntegerLinkedList() {
        this.head = null;
        this.last = null;
    }

    public IntegerLinkedList(Integer... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (Integer element : elements) {
            this.add(element);
        }
    }

    public static IntegerLinkedList of(Integer... elements) {
        return new IntegerLinkedList(elements);
    }

    public static IntegerLinkedList empty() {
        return new IntegerLinkedList();
    }

    public boolean add(Integer element) {
        assert element != null : "Element cannot be null";

        IntegerNode last = new IntegerNode(this.last, element);
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

    public IntegerIterator iterator() {
        return new IntegerIterator(this.head);
    }

    public String toString() {
        String toString = "";
        IntegerIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public Integer get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        IntegerNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        IntegerNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected IntegerNode head() {
        return this.head();
    }

}
