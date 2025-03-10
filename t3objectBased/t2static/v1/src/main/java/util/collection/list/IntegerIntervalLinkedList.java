package util.collection.list;

import util.collection.list.iterator.IntegerIntervalIterator;
import util.collection.list.node.IntegerIntervalNode;
import util.values.IntegerInterval;

public class IntegerIntervalLinkedList {

    private IntegerIntervalNode head;
    private IntegerIntervalNode last;

    public IntegerIntervalLinkedList() {
        this.head = null;
        this.last = null;
    }

    public static IntegerIntervalLinkedList of(IntegerInterval... elements) {
        assert elements != null : "Elements cannot be null";

        IntegerIntervalLinkedList dateLinkedList = IntegerIntervalLinkedList.empty();
        for (IntegerInterval element : elements) {
            dateLinkedList.add(element);
        }
        return dateLinkedList;
    }

    public static IntegerIntervalLinkedList empty(){
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

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        IntegerIntervalIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public IntegerIntervalIterator iterator() {
        return new IntegerIntervalIterator(this.head);
    }

    public IntegerInterval get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        IntegerIntervalIterator iterator = this.iterator();
        IntegerInterval intergerInterval = iterator.next().element();
        while (position > 0) {
            intergerInterval = iterator.next().element();
            position--;
        }
        return intergerInterval;
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

}
