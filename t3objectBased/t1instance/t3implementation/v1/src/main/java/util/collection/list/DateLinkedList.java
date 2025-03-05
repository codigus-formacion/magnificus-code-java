package util.collection.list;

import util.values.time.Date;
import util.values.interval.IntegerInterval;

public class DateLinkedList {

    protected DateNode head;
    protected DateNode last;

    public DateLinkedList() {
        this.head = null;
        this.last = null;
    }

    public DateLinkedList(Date... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (Date element : elements) {
            this.add(element);
        }
    }

    public static DateLinkedList of(Date... elements) {
        return new DateLinkedList(elements);
    }

    public static DateLinkedList empty() {
        return new DateLinkedList();
    }

    public boolean add(Date element) {
        assert element != null : "Element cannot be null";

        DateNode last = new DateNode(this.last, element);
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

    public DateIterator iterator() {
        return new DateIterator(this.head);
    }

    public String toString() {
        String toString = "";
        DateIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public Date get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        DateNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        DateNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected DateNode head() {
        return this.head();
    }

}
