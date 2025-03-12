package util.collection.list;

import util.collection.list.iterator.FractionIterator;
import util.collection.list.node.FractionNode;
import util.values.Fraction;
import util.values.IntegerInterval;

public class FractionLinkedList {

    private FractionNode head;
    private FractionNode last;

    public FractionLinkedList() {
        this.head = null;
        this.last = null;
    }

    public static FractionLinkedList of(Fraction... elements) {
        assert elements != null : "Elements cannot be null";

        FractionLinkedList dateLinkedList = FractionLinkedList.empty();
        for (Fraction element : elements) {
            dateLinkedList.add(element);
        }
        return dateLinkedList;
    }

    public static FractionLinkedList empty(){
        return new FractionLinkedList();
    }

    public boolean add(Fraction element) {
        assert element != null : "Element cannot be null";

        FractionNode last = new FractionNode(this.last, element);
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
        FractionIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public FractionIterator iterator() {
        return new FractionIterator(this.head);
    }

    public Fraction get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        FractionIterator iterator = this.iterator();
        Fraction fraction = iterator.next();
        while (position > 0) {
            fraction = iterator.next();
            position--;
        }
        return fraction;
    }

    public String toString() {
        String toString = "";
        FractionIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

}
