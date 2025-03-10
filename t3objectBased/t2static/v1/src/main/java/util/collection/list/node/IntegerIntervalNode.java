package util.collection.list.node;

import util.values.IntegerInterval;

public class IntegerIntervalNode {

    private IntegerIntervalNode previous;
    private IntegerInterval element;
    private IntegerIntervalNode next;

    public IntegerIntervalNode(IntegerIntervalNode previous, IntegerInterval element, IntegerIntervalNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public IntegerIntervalNode(IntegerInterval element, IntegerIntervalNode next) {
        this(null, element, next);
    }

    public IntegerIntervalNode(IntegerIntervalNode previous, IntegerInterval element) {
        this(previous, element, null);
    }
    
    public void setNext(IntegerIntervalNode next) {
        assert next != null;
        
        this.next = next;
    }

    public IntegerInterval element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public IntegerIntervalNode next(){
        return this.next;
    }

    public IntegerIntervalNode previous(){
        return this.previous;
    }

}
