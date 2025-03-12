package util.collection.list.iterator;

import util.collection.list.DoubleLinkedList;
import util.collection.list.node.DoubleLinkedListNode;

public class DoubleLinkedListIterator {

    private DoubleLinkedListNode current;

    public DoubleLinkedListIterator(DoubleLinkedListNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public DoubleLinkedList next(){
        assert this.hasNext();

        DoubleLinkedList element = this.current.element();
        this.current = this.current.next();
        return element;
    }    

}
