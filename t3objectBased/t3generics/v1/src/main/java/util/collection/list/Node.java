package util.collection.list;

import util.values.Optional;

public class Node<T> {

    private Optional<Node<T>> previous;
    private T element;
    private Optional<Node<T>> next;

    private Node(Optional<Node<T>> previous, T element, Optional<Node<T>> next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public Node(T element, Optional<Node<T>> next) {
        this(Optional.empty(), element, next);
    }

    public Node(Optional<Node<T>> previous, T element) {
        this(previous, element, Optional.empty());
    }
    
    public void setNext(Optional<Node<T>> next) {
        assert next != null && next.isPresent();
        
        this.next = next;
    }

    public T element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next.isEmpty();
    }

    public Optional<Node<T>> next(){
        return this.next;
    }

    public Optional<Node<T>> previous(){
        return this.previous;
    }

}

