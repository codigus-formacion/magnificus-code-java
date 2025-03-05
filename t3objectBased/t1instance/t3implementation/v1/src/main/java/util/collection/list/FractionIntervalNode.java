package util.collection.list;

import util.values.interval.FractionInterval;

public class FractionIntervalNode {

    private FractionIntervalNode previous;
    private FractionInterval element;
    private FractionIntervalNode next;

    private FractionIntervalNode(FractionIntervalNode previous, FractionInterval element, FractionIntervalNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public FractionIntervalNode(FractionInterval element, FractionIntervalNode next) {
        this(null, element, next);
    }

    public FractionIntervalNode(FractionIntervalNode previous, FractionInterval element) {
        this(previous, element, null);
    }
    
    public void setNext(FractionIntervalNode next) {
        assert next != null;
        
        this.next = next;
    }

    public FractionInterval element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public FractionIntervalNode next(){
        return this.next;
    }

    public FractionIntervalNode previous(){
        return this.previous;
    }

}
