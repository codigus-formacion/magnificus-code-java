package util.collection.list.node;

public class DoubleNode {

    private DoubleNode previous;
    private double element;
    private DoubleNode next;

    public DoubleNode(DoubleNode previous, double element, DoubleNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public DoubleNode(double element, DoubleNode next) {
        this(null, element, next);
    }

    public DoubleNode(DoubleNode previous, double element) {
        this(previous, element, null);
    }
    
    public void setNext(DoubleNode next) {
        assert next != null;
        
        this.next = next;
    }

    public double element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public DoubleNode next(){
        return this.next;
    }

    public DoubleNode previous(){
        return this.previous;
    }

}
