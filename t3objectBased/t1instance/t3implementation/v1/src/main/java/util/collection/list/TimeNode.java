package util.collection.list;

import util.values.time.Time;

public class TimeNode {

    private TimeNode previous;
    private Time element;
    private TimeNode next;

    private TimeNode(TimeNode previous, Time element, TimeNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public TimeNode(Time element, TimeNode next) {
        this(null, element, next);
    }

    public TimeNode(TimeNode previous, Time element) {
        this(previous, element, null);
    }
    
    public void setNext(TimeNode next) {
        assert next != null;
        
        this.next = next;
    }

    public Time element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public TimeNode next(){
        return this.next;
    }

    public TimeNode previous(){
        return this.previous;
    }

}
