package util.collection.list;

public class StringNode {

    private StringNode previous;
    private String element;
    private StringNode next;

    private StringNode(StringNode previous, String element, StringNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public StringNode(String element, StringNode next) {
        this(null, element, next);
    }

    public StringNode(StringNode previous, String element) {
        this(previous, element, null);
    }
    
    public void setNext(StringNode next) {
        assert next != null;
        
        this.next = next;
    }

    public String element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public StringNode next(){
        return this.next;
    }

    public StringNode previous(){
        return this.previous;
    }

}
