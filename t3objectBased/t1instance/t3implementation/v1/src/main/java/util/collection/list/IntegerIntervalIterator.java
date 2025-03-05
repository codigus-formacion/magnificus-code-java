package util.collection.list;

public class IntegerIntervalIterator {

    private IntegerIntervalNode current;

    public IntegerIntervalIterator(IntegerIntervalNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public IntegerIntervalNode next(){
        assert this.hasNext();

        IntegerIntervalNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
