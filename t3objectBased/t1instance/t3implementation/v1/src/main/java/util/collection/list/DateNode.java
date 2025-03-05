package util.collection.list;

import util.values.time.Date;

public class DateNode {

    private DateNode previous;
    private Date element;
    private DateNode next;

    private DateNode(DateNode previous, Date element, DateNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public DateNode(Date element, DateNode next) {
        this(null, element, next);
    }

    public DateNode(DateNode previous, Date element) {
        this(previous, element, null);
    }
    
    public void setNext(DateNode next) {
        assert next != null;
        
        this.next = next;
    }

    public Date element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public DateNode next(){
        return this.next;
    }

    public DateNode previous(){
        return this.previous;
    }

}
