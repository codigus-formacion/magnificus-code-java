package util.collection.list;

import util.values.fraction.Fraction;

public class FractionNode {

    private FractionNode previous;
    private Fraction element;
    private FractionNode next;

    private FractionNode(FractionNode previous, Fraction element, FractionNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public FractionNode(Fraction element, FractionNode next) {
        this(null, element, next);
    }

    public FractionNode(FractionNode previous, Fraction element) {
        this(previous, element, null);
    }
    
    public void setNext(FractionNode next) {
        assert next != null;
        
        this.next = next;
    }

    public Fraction element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public FractionNode next(){
        return this.next;
    }

    public FractionNode previous(){
        return this.previous;
    }

}
