package util.collection.list.node;

import util.values.DoubleInterval;

public class DoubleIntervalNode {

    private DoubleIntervalNode previous;
    private DoubleInterval element;
    private DoubleIntervalNode next;

    public DoubleIntervalNode(DoubleIntervalNode previous, DoubleInterval element, DoubleIntervalNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public DoubleIntervalNode(DoubleInterval element, DoubleIntervalNode next) {
        this(null, element, next);
    }

    public DoubleIntervalNode(DoubleIntervalNode previous, DoubleInterval element) {
        this(previous, element, null);
    }
    
    public void setNext(DoubleIntervalNode next) {
        assert next != null;
        
        this.next = next;
    }

    public DoubleInterval element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public DoubleIntervalNode next(){
        return this.next;
    }

    public DoubleIntervalNode previous(){
        return this.previous;
    }

}
