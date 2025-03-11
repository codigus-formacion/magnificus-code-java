package util.collection.list;

import util.values.IntegerInterval;

public class LinkedList<T> {

    public class Node<U> {

        private Node<U> previous;
        private U element;
        private Node<U> next;
    
        Node(Node<U> previous, U element, Node<U> next) {
            this.previous = previous;
            this.element = element;
            this.next = next;
        }
    
        Node(U element, Node<U> next) {
            this(null, element, next);
        }
    
        Node(Node<U> previous, U element) {
            this(previous, element, null);
        }
        
        void setNext(Node<U> next) {
            assert next != null;
            
            this.next = next;
        }
    
        public U element(){
            return this.element;
        }
    
        public boolean isLast(){
            return this.next == null;
        }
    
        public Node<U> next(){
            return this.next;
        }
    
        public Node<U> previous(){
            return this.previous;
        }
    
    }
    
    private Node<T> head;
    private Node<T> last;

    public LinkedList() {
        this.head = null;
        this.last = null;
    }

    public static <T> LinkedList<T> of(T... elements) {
        assert elements != null : "Elements cannot be null";

        LinkedList<T> dateLinkedList = LinkedList.empty();
        for (T element : elements) {
            dateLinkedList.add(element);
        }
        return dateLinkedList;
    }

    public static <T> LinkedList<T> empty(){
        return new LinkedList<T>();
    }

    public boolean add(T element) {
        assert element != null : "Element cannot be null";

        Node<T> last = new Node<T>(this.last, element);
        if (this.isEmpty()) {
            this.head = last;
        } else {
            this.last.setNext(last);
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
    
        public Node<U> next(){
            assert this.hasNext();
    
            Node<U> element = this.current;
            this.current = this.current.next();
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
        return new Iterator<T>(this.head);
    }

    public T get(int position) {
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "Position out of bounds";

        Iterator<T> iterator = this.iterator();
        T element = iterator.next().element();
        while (position > 0) {
            element = iterator.next().element();
            position--;
        }
        return element;
    }

    public String toString() {
        String toString = "";
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            toString += "," + iterator.next().element();
        }
        if (toString.length() > 0) {
            toString = "\n" + toString.substring(1);
        }
        return "LinkedList [" + toString + "]";
    }

}
