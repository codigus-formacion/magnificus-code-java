package util.collection.set;

import util.collection.Collection;
import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.functional.Predicate;

public class LinkedSet<T> implements Collection<T>{
    
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

    public boolean remove(T element){
        return this.elements.remove(element);
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public int size() {
        return this.elements.size();
    }

    public boolean contains(T element){
        return this.elements.contains(element);
    }

    public Iterator<T> iterator() {
        return this.elements.iterator();
    }

    public T get(int position) {
        return this.elements.get(position);
    }

    public void clear(){
        this.elements.clear();
    }

    public String toString() {
        return this.elements.toString();
    }

    public Collection<T> filter(Predicate<T> predicate) {
        LinkedSet<T> filtered = new LinkedSet<>();
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
