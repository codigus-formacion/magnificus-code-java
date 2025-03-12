package util.collection.list;

// public class Node<T> {

//     private Node<T> previous;
//     private T element;
//     private Node<T> next;

//     Node(Node<T> previous, T element, Node<T> next) {
//         this.previous = previous;
//         this.element = element;
//         this.next = next;
//     }

//     Node(T element, Node<T> next) {
//         this(null, element, next);
//     }

//     Node(Node<T> previous, T element) {
//         this(previous, element, null);
//     }
    
//     void setNext(Node<T> next) {
//         assert next != null;
        
//         this.next = next;
//     }

//     public T element(){
//         return this.element;
//     }

//     public boolean isLast(){
//         return this.next == null;
//     }

//     public Node<T> next(){
//         return this.next;
//     }

//     public Node<T> previous(){
//         return this.previous;
//     }

// }

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

