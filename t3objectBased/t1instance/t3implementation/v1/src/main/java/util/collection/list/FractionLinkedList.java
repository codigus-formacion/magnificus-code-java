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

    public FractionLinkedList(Fraction... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (Fraction element : elements) {
            this.add(element);
        }
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
        Fraction fraction = iterator.next().element();
        while (position > 0) {
            fraction = iterator.next().element();
            position--;
        }
        return fraction;
    }

    public String toString() {
        String toString = "";
        FractionIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

}
