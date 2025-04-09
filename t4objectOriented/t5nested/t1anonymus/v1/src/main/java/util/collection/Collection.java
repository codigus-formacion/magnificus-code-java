package util.collection;

import util.functional.Consumer;
import util.functional.Predicate;

public interface Collection<T> {
  
    boolean add(T element) ;
    boolean remove(T element);
    void clear();
    boolean isEmpty();
    int size();
    T get(int position);
    boolean contains(T element);
    Iterator<T> iterator();
    String toString();
    Collection<T> filter(Predicate<T> predicate);
    default void forEach(Consumer<T> consumer){
        Iterator<T> iterator = this.iterator();
        while (iterator.hasNext()){
            consumer.accept(iterator.next());
        }
    }
}
