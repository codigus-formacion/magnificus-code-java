package util.collection.list.iterator;

import util.collection.list.IntegerLinkedList;
import util.collection.list.node.IntegerLinkedListNode;

public class IntegerLinkedListIterator {

    private IntegerLinkedListNode current;

    public IntegerLinkedListIterator(IntegerLinkedListNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public IntegerLinkedList next(){
        assert this.hasNext();

        IntegerLinkedList element = this.current.element();
        this.current = this.current.next();
        return element;
    }    

}
