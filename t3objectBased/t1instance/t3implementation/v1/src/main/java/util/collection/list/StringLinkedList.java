package util.collection.list;

import util.values.interval.IntegerInterval;

public class StringLinkedList {

    protected StringNode head;
    protected StringNode last;

    public StringLinkedList() {
        this.head = null;
        this.last = null;
    }

    public StringLinkedList(String... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (String element : elements) {
            this.add(element);
        }
    }

    public static StringLinkedList of(String... elements) {
        return new StringLinkedList(elements);
    }

    public static StringLinkedList empty() {
        return new StringLinkedList();
    }

    public boolean add(String element) {
        assert element != null : "Element cannot be null";

        StringNode last = new StringNode(this.last, element);
        if (this.isEmpty()) {
            this.head = last;
        } else {
            this.last.setNext(last);
        }
        this.last = last;
        return true;
    }

    private boolean isEmpty() {
        return this.head == null;
    }

    public StringIterator iterator() {
        return new StringIterator(this.head);
    }

    public String toString() {
        String toString = "";
        StringIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

    public String get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        StringNode current = this.head;
        while (position > 0) {
            position--;
            current = current.next();
        }
        return current.element();
    }

    public int size() {
        int size = 0;
        StringNode current = this.head;
        while (current != null) {
            size++;
            current = current.next();
        }
        return size;
    }

    protected StringNode head() {
        return this.head();
    }

}
