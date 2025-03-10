package util.collection.list;

import util.values.IntegerInterval;
import util.values.Time;
import util.collection.list.iterator.TimeIterator;
import util.collection.list.node.TimeNode;

public class TimeLinkedList {

    private TimeNode head;
    private TimeNode last;

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

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        TimeIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public TimeIterator iterator() {
        return new TimeIterator(this.head);
    }

    public Time get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        TimeIterator iterator = this.iterator();
        Time time = iterator.next().element();
        while (position > 0) {
            time = iterator.next().element();
            position--;
        }
        return time;
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

}
