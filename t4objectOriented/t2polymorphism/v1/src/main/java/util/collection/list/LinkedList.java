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
            this.next = next;
            if (next.isPresent()){
                next.get().previous = Optional.of(this);
            }
        }

        public U element() {
            return this.element;
        }

        public boolean isFirst() {
            return this.previous.isEmpty();
        }

        public boolean isLast() {
            return this.next.isEmpty();
        }

        public Optional<Node<U>> next() {
            return this.next;
        }

        public Optional<Node<U>> previous() {
            return this.previous;
        }

    }

    protected Optional<Node<T>> head;
    protected Optional<Node<T>> last;

    public LinkedList() {
        this.head = Optional.empty();
        this.last = Optional.empty();
    }

    public static <T> LinkedList<T> of(T... elements) {
        assert elements != null : "Elements cannot be null";
        
        LinkedList<T> list = new LinkedList<T>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
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

    public boolean remove(T element) {
        Node<T> removed = this.find(element);
        if (removed == null){
            return false;
        }
        if (removed.isFirst()){
            this.head = Optional.empty();
            this.last = Optional.empty();
        } else {
            removed.previous.get().setNext(removed.next);
        }
        return true;
    }

    public void clear(){
        while (!this.isEmpty()){
            this.remove(this.get(0));
        }
    }

    private Node<T> find(T element) {
        if (this.head.isEmpty()) {
            return null;
        }
        Optional<Node<T>> current = this.head;
        while (!current.get().element().equals(element) && !current.get().isLast()) {
            current = current.get().next();
        }
        if (current.get().element().equals(element)){
            return current.get();
        }
        return null;
    }

    public boolean isEmpty() {
        return this.head.isEmpty();
    }

    public class Iterator<U> {

        private Node<U> current;

        public Iterator(Node<U> head) {
            this.current = head;
        }

        public boolean hasNext() {
            return this.current != null;
        }

        public U next() {
            assert this.hasNext();

            U element = this.current.element();
            if (this.current.isLast()) {
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
        assert new IntegerInterval(0, this.size() - 1).includes(position) : "[" + 0 + " - " + (this.size()-1) + "] with" + position;

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
