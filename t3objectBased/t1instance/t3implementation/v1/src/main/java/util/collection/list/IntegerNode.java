package util.collection.list;

public class IntegerNode {

    private IntegerNode previous;
    private Integer element;
    private IntegerNode next;

    private IntegerNode(IntegerNode previous, Integer element, IntegerNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public IntegerNode(Integer element, IntegerNode next) {
        this(null, element, next);
    }

    public IntegerNode(IntegerNode previous, Integer element) {
        this(previous, element, null);
    }
    
    public void setNext(IntegerNode next) {
        assert next != null;
        
        this.next = next;
    }

    public Integer element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public IntegerNode next(){
        return this.next;
    }

    public IntegerNode previous(){
        return this.previous;
    }

}
