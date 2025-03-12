package util.collection.list.iterator;

import util.collection.list.node.StringNode;

public class StringIterator {

    private StringNode current;

    public StringIterator(StringNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public String next(){
        assert this.hasNext();

        String element = this.current.element();
        this.current = this.current.next();
        return element;
    }

}
