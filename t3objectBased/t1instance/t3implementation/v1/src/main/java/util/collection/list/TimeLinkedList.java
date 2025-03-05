package util.collection.list;

import util.values.time.Time;
import util.values.interval.IntegerInterval;

public class TimeLinkedList {

    protected TimeNode head;
    protected TimeNode last;

    public TimeLinkedList() {
        this.head = null;
        this.last = null;
    }

    public TimeLinkedList(Time... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (Time element : elements) {
            this.add(element);
        }
    }

    public static TimeLinkedList of(Time... elements) {
        return new TimeLinkedList(elements);
    }

    public static TimeLinkedList empty() {
        return new TimeLinkedList();
    }

    public boolean add(Time element) {
        assert element != null : "Element cannot be null";

        TimeNode last = new TimeNode(this.last, element);
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

    public TimeIterator iterator() {
        return new TimeIterator(this.head);
    }

    public String toString() {
        String toString = "";
        TimeIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public Time get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        TimeNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        TimeNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected TimeNode head() {
        return this.head();
    }

}
