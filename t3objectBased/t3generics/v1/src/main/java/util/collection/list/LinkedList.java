package util.collection.list;

import util.values.IntegerInterval;
import util.values.Optional;

public class LinkedList<T> {

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
