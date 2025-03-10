package util.collection.list;

import util.collection.list.iterator.IntegerLinkedListIterator;
import util.collection.list.node.IntegerLinkedListNode;
import util.values.IntegerInterval;

public class IntegerLinkedListLinkedList {

    private IntegerLinkedListNode head;
    private IntegerLinkedListNode last;

    public IntegerLinkedListLinkedList() {
        this.head = null;
        this.last = null;
    }

    public IntegerLinkedListLinkedList(IntegerLinkedList... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (IntegerLinkedList element : elements) {
            this.add(element);
        }
    }

    public boolean add(IntegerLinkedList element) {
        assert element != null : "Element cannot be null";

        IntegerLinkedListNode last = new IntegerLinkedListNode(this.last, element);
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
        IntegerLinkedListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public IntegerLinkedListIterator iterator() {
        return new IntegerLinkedListIterator(this.head);
    }

    public IntegerLinkedList get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        IntegerLinkedListIterator iterator = this.iterator();
        IntegerLinkedList integerLinkedList = iterator.next().element();
        while (position > 0) {
            integerLinkedList = iterator.next().element();
            position--;
        }
        return integerLinkedList;
    }

    public String toString() {
        String toString = "";
        IntegerLinkedListIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

}
