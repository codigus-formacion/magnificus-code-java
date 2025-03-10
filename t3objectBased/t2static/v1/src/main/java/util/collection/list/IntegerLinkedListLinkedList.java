package util.collection.list;

import util.collection.list.iterator.IntegerLinkedListIterator;
import util.collection.list.node.IntegerLinkedListNode;
import util.values.IntegerInterval;
import util.values.Math;

public class IntegerLinkedListLinkedList {

    private IntegerLinkedListNode head;
    private IntegerLinkedListNode last;

    public IntegerLinkedListLinkedList() {
        this.head = null;
        this.last = null;
    }

    public static IntegerLinkedListLinkedList of(IntegerLinkedList... elements) {
        assert elements != null : "Elements cannot be null";

        IntegerLinkedListLinkedList dateLinkedList = IntegerLinkedListLinkedList.empty();
        for (IntegerLinkedList element : elements) {
            dateLinkedList.add(element);
        }
        return dateLinkedList;
    }
    
    public static IntegerLinkedList getRandomIntList() {
        IntegerLinkedList randomIntList = new IntegerLinkedList();
        for (int i = 0; i < 10; i++) {
            randomIntList.add(0 + Math.randomInt(10));
        }
        return randomIntList;
    }

    public static IntegerLinkedList getRangeIntList() {
        IntegerLinkedList rangeIntList = new IntegerLinkedList();
        for (int i = 0; i < 10; i++) {
            rangeIntList.add(i);
        }
        return rangeIntList;
    }

    public static IntegerLinkedList getRangeClosedIntList() {
        IntegerLinkedList rangeClosedIntList = new IntegerLinkedList();
        for (int i = 0; i <= 10; i++) {
            rangeClosedIntList.add(i);
        }
        return rangeClosedIntList;
    }

    public static IntegerLinkedListLinkedList empty(){
        return new IntegerLinkedListLinkedList();
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
