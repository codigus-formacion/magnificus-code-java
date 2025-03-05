package util.collection.list;

public class TimeIterator {

    private TimeNode current;

    public TimeIterator(TimeNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public TimeNode next(){
        assert this.hasNext();

        TimeNode element = this.current;
        this.current = this.current.next();
        return element;
    }

}
