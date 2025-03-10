package util.collection.list;

import util.collection.list.iterator.IntegerIterator;
import util.collection.list.node.IntegerNode;
import util.values.IntegerInterval;

public class IntegerLinkedList {

    private IntegerNode head;
    private IntegerNode last;

    public IntegerLinkedList() {
        this.head = null;
        this.last = null;
    }

    public static IntegerLinkedList of(Integer... elements) {
        assert elements != null : "Elements cannot be null";

        IntegerLinkedList dateLinkedList = IntegerLinkedList.empty();
        for (Integer element : elements) {
            dateLinkedList.add(element);
        }
        return dateLinkedList;
    }

    public static IntegerLinkedList empty(){
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

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        IntegerIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public IntegerIterator iterator() {
        return new IntegerIterator(this.head);
    }

    public Integer get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        IntegerIterator iterator = this.iterator();
        int integer = iterator.next().element();
        while (position > 0) {
            integer = iterator.next().element();
            position--;
        }
        return integer;
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

}
