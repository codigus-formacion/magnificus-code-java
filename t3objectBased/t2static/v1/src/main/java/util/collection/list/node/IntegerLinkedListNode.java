package util.collection.list.node;

import util.collection.list.IntegerLinkedList;

public class IntegerLinkedListNode {

    private IntegerLinkedListNode previous;
    private IntegerLinkedList element;
    private IntegerLinkedListNode next;

    public IntegerLinkedListNode(IntegerLinkedListNode previous, IntegerLinkedList element, IntegerLinkedListNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public IntegerLinkedListNode(IntegerLinkedList element, IntegerLinkedListNode next) {
        this(null, element, next);
    }

    public IntegerLinkedListNode(IntegerLinkedListNode previous, IntegerLinkedList element) {
        this(previous, element, null);
    }
    
    public void setNext(IntegerLinkedListNode next) {
        assert next != null;
        
        this.next = next;
    }

    public IntegerLinkedList element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public IntegerLinkedListNode next(){
        return this.next;
    }

    public IntegerLinkedListNode previous(){
        return this.previous;
    }
    
}
