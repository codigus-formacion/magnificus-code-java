package util.collection.set;

import java.util.Map;

import util.collection.list.LinkedList;

public class LinkedSet<T> {
    
    private LinkedList<T> elements;

    public LinkedSet(){
        this.elements = new LinkedList<T>();
    }

    public static <T> LinkedSet<T> of(T... elements) {
        assert elements != null : "Elements cannot be null";
        LinkedSet<T> set = new LinkedSet<T>();
        for (T element : elements) {
            set.elements.add(element);
        }
        return set;
    }

    public static <T> LinkedSet<T> empty(){
        return new LinkedSet<T>();
    }

    public boolean add(T element) {
        assert element != null : "Element cannot be null";

        if (!this.elements.contains(element)){
            this.elements.add(element);
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public int size() {
        return this.elements.size();
    }

    public LinkedList<T>.Iterator<T> iterator() {
        return this.elements.iterator();
    }

    public T get(int position) {
        return this.elements.get(position);
    }

    public String toString() {
        return this.elements.toString();
    }

}
