package util.collection.list.iterator;

import util.collection.list.node.IntegerLinkedListNode;

public class IntegerLinkedListIterator {

    private IntegerLinkedListNode current;

    public IntegerLinkedListIterator(IntegerLinkedListNode head) {
        this.current = head;
    }

    public boolean hasNext() {
        return this.current != null;
    }

    public IntegerLinkedListNode next(){
        assert this.hasNext();

        IntegerLinkedListNode element = this.current;
        this.current = this.current.next();
        return element;
    }    

}
