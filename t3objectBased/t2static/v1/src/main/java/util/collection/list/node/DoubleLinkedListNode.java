package util.collection.list.node;

import util.collection.list.DoubleLinkedList;

public class DoubleLinkedListNode {

    private DoubleLinkedListNode previous;
    private DoubleLinkedList element;
    private DoubleLinkedListNode next;

    public DoubleLinkedListNode(DoubleLinkedListNode previous, DoubleLinkedList element, DoubleLinkedListNode next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public DoubleLinkedListNode(DoubleLinkedList element, DoubleLinkedListNode next) {
        this(null, element, next);
    }

    public DoubleLinkedListNode(DoubleLinkedListNode previous, DoubleLinkedList element) {
        this(previous, element, null);
    }
    
    public void setNext(DoubleLinkedListNode next) {
        assert next != null;
        
        this.next = next;
    }

    public DoubleLinkedList element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public DoubleLinkedListNode next(){
        return this.next;
    }

    public DoubleLinkedListNode previous(){
        return this.previous;
    }

}
