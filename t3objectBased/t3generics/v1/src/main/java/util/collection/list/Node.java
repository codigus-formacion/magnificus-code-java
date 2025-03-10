package util.collection.list;

public class Node<T> {

    private Node<T> previous;
    private T element;
    private Node<T> next;

    public Node(Node<T> previous, T element, Node<T> next) {
        this.previous = previous;
        this.element = element;
        this.next = next;
    }

    public Node(T element, Node<T> next) {
        this(null, element, next);
    }

    public Node(Node<T> previous, T element) {
        this(previous, element, null);
    }
    
    public void setNext(Node<T> next) {
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
