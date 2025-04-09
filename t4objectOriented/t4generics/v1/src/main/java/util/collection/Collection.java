package util.collection;

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
}
