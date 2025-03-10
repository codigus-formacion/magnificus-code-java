package util.collection.list;

public class Node<T> {

    private Node<T> previous;
    private T element;
    private Node<T> next;

    Node(Node<T> previous, T element, Node<T> next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    Node(T element, Node<T> next) {
        this(null, element, next);
    }

    Node(Node<T> previous, T element) {
        this(previous, element, null);
    }
    
    void setNext(Node<T> next) {
        assert next != null;
        
        this.next = next;
    }

    public T element(){
        return this.element;
    }

    public boolean isLast(){
        return this.next == null;
    }

    public Node<T> next(){
        return this.next;
    }

    public Node<T> previous(){
        return this.previous;
    }

}
