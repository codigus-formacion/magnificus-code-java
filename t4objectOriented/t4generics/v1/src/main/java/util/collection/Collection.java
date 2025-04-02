package util.collection;

import util.functional.Predicate;

public interface Collection<T> {
  
    public boolean add(T element) ;
    public boolean remove(T element);
    public void clear();
    public boolean isEmpty();
    public int size();
    public T get(int position);
    public boolean contains(T element);
    public Iterator<T> iterator();
    public String toString();
    public Collection<T> filter(Predicate<T> predicate);
}
