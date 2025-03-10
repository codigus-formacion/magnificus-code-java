package util.collection.list;

import util.collection.list.iterator.FractionIntervalIterator;
import util.collection.list.node.FractionIntervalNode;
import util.values.FractionInterval;
import util.values.IntegerInterval;

public class FractionIntervalLinkedList {

    private FractionIntervalNode head;
    private FractionIntervalNode last;

    public FractionIntervalLinkedList() {
        this.head = null;
        this.last = null;
    }

    public static FractionIntervalLinkedList of(FractionInterval... elements) {
        assert elements != null : "Elements cannot be null";

        FractionIntervalLinkedList dateLinkedList = FractionIntervalLinkedList.empty();
        for (FractionInterval element : elements) {
            dateLinkedList.add(element);
        }
        return dateLinkedList;
    }

    public static FractionIntervalLinkedList empty(){
        return new FractionIntervalLinkedList();
    }

    public boolean add(FractionInterval element) {
        assert element != null : "Element cannot be null";

        FractionIntervalNode last = new FractionIntervalNode(this.last, element);
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
        FractionIntervalIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public FractionIntervalIterator iterator() {
        return new FractionIntervalIterator(this.head);
    }

    public FractionInterval get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        FractionIntervalIterator iterator = this.iterator();
        FractionInterval fractionInterval = iterator.next().element();
        while (position > 0) {
            fractionInterval = iterator.next().element();
            position--;
        }
        return fractionInterval;
    }

    public String toString() {
        String toString = "";
        FractionIntervalIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

}
