package util.collection.list;

import util.values.IntegerInterval;
import util.values.Optional;

public class LinkedList<T> {

    class Node<U> {

        private Optional<Node<U>> previous;
        private U element;
        private Optional<Node<U>> next;
    
        private Node(Optional<Node<U>> previous, U element, Optional<Node<U>> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }
    
        public Node(U element, Optional<Node<U>> next) {
            this(Optional.empty(), element, next);
        }
    
        public Node(Optional<Node<U>> previous, U element) {
            this(previous, element, Optional.empty());
        }
        
        public void setNext(Optional<Node<U>> next) {
            assert next != null && next.isPresent();
            
            this.next = next;
        }
    
        public U element(){
            return this.element;
        }
    
        public boolean isLast(){
            return this.next.isEmpty();
        }
    
        public Optional<Node<U>> next(){
            return this.next;
        }
    
        public Optional<Node<U>> previous(){
            return this.previous;
        }
    
    }

    protected Optional<Node<T>> head;
    protected Optional<Node<T>> last;

    public LinkedList() {
        this.head = Optional.empty();
        this.last = Optional.empty();
    }

    public LinkedList(T... elements) {
        this();
        assert elements != null : "Elements cannot be null";

        for (T element : elements) {
            this.add(element);
        }
    }

    public static <T> LinkedList<T> of(T... elements) {
        return new LinkedList<T>(elements);
    }

    public static <T> LinkedList<T> empty() {
        return new LinkedList<>();
    }

    public boolean add(T element) {
        assert element != null : "Element cannot be null";

        Optional<Node<T>> last = Optional.of(new Node<>(this.last, element));
        if (this.head.isEmpty()) {
            this.head = last;
        } else {
            this.last.get().setNext(last);
        }
        this.last = last;
        return true;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public class Iterator<U> {

        private Node<U> current;
    
        public Iterator(Node<U> head) {
            this.current = head;
        }
    
        public boolean hasNext() {
            return this.current != null;
        }
    
        public U next(){
            assert this.hasNext();
    
            U element = this.current.element();
            if (this.current.isLast()){
                this.current = null;
            } else {
                this.current = this.current.next().get();
            }
            return element;
        }
    
    }
    

    public int size() {
        int size = 0;
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            size++;
            iterator.next();
        }
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>(this.head());
    }

    public boolean contains(T element) {
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() == element) {
                return true;
            }
        }
        return false;
    }

    public T get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        Iterator<T> iterator = this.iterator();
        while (position > 0) {
            position--;
            iterator.next();
        }
        return iterator.next();
    }

    protected Node<T> head() {
        if (this.head.isEmpty()) {
            return null;
        }
        return this.head.get();
    }

    public String toString() {
        String string = "";
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            string += ", " + iterator.next();
        }
        if (string.length() > 0) {
            string = string.substring(1);
        }
        return "{" + string + "}";
    }

}
