package util.collection.list;

import util.collection.list.iterator.DoubleLinkedListIterator;
import util.collection.list.node.DoubleLinkedListNode;
import util.values.IntegerInterval;

public class DoubleLinkedListLinkedList {

    private DoubleLinkedListNode head;
    private DoubleLinkedListNode last;

    public DoubleLinkedListLinkedList() {
        this.head = null;
        this.last = null;
    }

    public DoubleLinkedListLinkedList(DoubleLinkedList... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (DoubleLinkedList element : elements) {
            this.add(element);
        }
    }

    public boolean add(DoubleLinkedList element) {
        assert element != null : "Element cannot be null";

        DoubleLinkedListNode last = new DoubleLinkedListNode(this.last, element);
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
        DoubleLinkedListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public DoubleLinkedListIterator iterator() {
        return new DoubleLinkedListIterator(this.head);
    }

    public DoubleLinkedList get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        DoubleLinkedListIterator iterator = this.iterator();
        DoubleLinkedList doubleLinkedList = iterator.next();
        while (position > 0) {
            doubleLinkedList = iterator.next();
            position--;
        }
        return doubleLinkedList;
    }

    public String toString() {
        String toString = "";
        DoubleLinkedListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

}
