package util.collection.list.iterator;

import util.collection.list.node.DoubleLinkedListNode;

public class DoubleLinkedListIterator {

    private DoubleLinkedListNode current;

    public DoubleLinkedListIterator(DoubleLinkedListNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public DoubleLinkedListNode next(){
        assert this.hasNext();

        DoubleLinkedListNode element = this.current;
        this.current = this.current.next();
        return element;
    }    

}
