package util.collection.list;

public class StringIterator {

    private StringNode current;

    public StringIterator(StringNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public StringNode next(){
        assert this.hasNext();

        StringNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
