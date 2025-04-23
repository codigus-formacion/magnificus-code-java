package util.collection.list;

import util.collection.Collection;
import util.collection.Iterator;
import util.collection.Node;
import util.functional.Predicate;
import util.values.IntegerInterval;
import util.values.Optional;

public class LinkedList<T> implements Collection<T>{

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
            removed.previous().get().setNext(removed.next());
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
 
    public Collection<T> filter(Predicate<T> predicate) {
        LinkedList<T> filtered = new LinkedList<>();
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (predicate.test(element)) {
                filtered.add(element);
            }
        }
        return filtered;
    }

}
