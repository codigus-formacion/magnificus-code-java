package util.collection.list;

import util.values.Date;
import util.values.IntegerInterval;
import util.collection.list.iterator.DateIterator;
import util.collection.list.node.DateNode;

public class DateLinkedList {

    private DateNode head;
    private DateNode last;

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
    
    public void add(Date element) {
        assert element != null : "Element cannot be null";

        DateNode last = new DateNode(this.last, element);
        if (this.isEmpty()) {
            this.head = last;
        } else {
            this.last.setNext(last);
        }
        this.last = last;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        DateIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public DateIterator iterator() {
        return new DateIterator(this.head);
    }

    public Date get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        DateIterator iterator = this.iterator();
        Date date = iterator.next().element();
        while (position > 0) {
            date = iterator.next().element();
            position--;
        }
        return date;
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

}
