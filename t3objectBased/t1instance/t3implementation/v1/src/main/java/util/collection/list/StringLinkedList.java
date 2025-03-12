package util.collection.list;

import util.collection.list.iterator.StringIterator;
import util.collection.list.node.StringNode;
import util.values.IntegerInterval;

public class StringLinkedList {

    private StringNode head;
    private StringNode last;

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

    public boolean isEmpty() {
        return this.head == null;
    }

    public int size() {
        int size = 0;
        StringIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public StringIterator iterator() {
        return new StringIterator(this.head);
    }

    public String get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        StringIterator iterator = this.iterator();
        String string = iterator.next();
        while (position > 0) {
            string = iterator.next();
            position--;
        }
        return string;
    }

    public String toString() {
        String toString = "";
        StringIterator iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next();
        }
        if (toString.length() > 0) {
            toString = toString.substring(1);
        }
        return "{" + toString + "}";
    }

}
