package util.collection.list;

import util.values.fraction.Fraction;
import util.values.interval.IntegerInterval;

public class FractionLinkedList {

    protected FractionNode head;
    protected FractionNode last;

    public FractionLinkedList() {
        this.head = null;
        this.last = null;
    }

    public FractionLinkedList(Fraction... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (Fraction element : elements) {
            this.add(element);
        }
    }

    public static FractionLinkedList of(Fraction... elements) {
        return new FractionLinkedList(elements);
    }

    public static FractionLinkedList empty() {
        return new FractionLinkedList();
    }

    public boolean add(Fraction element) {
        assert element != null : "Element cannot be null";

        FractionNode last = new FractionNode(this.last, element);
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

    public FractionIterator iterator() {
        return new FractionIterator(this.head);
    }

    public String toString() {
        String toString = "";
        FractionIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public Fraction get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        FractionNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        FractionNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected FractionNode head() {
        return this.head();
    }

}
