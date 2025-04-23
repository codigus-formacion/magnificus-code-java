package util.collection.map;

import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.collection.set.LinkedSet;
import util.values.Pair;

public class LinkedMap<K,V> {
    
    private LinkedList<Pair<K,V>> pairs;

    public LinkedMap(){
        this.pairs = new LinkedList<>();
    }

    public void put(K key, V value) {
        Iterator<Pair<K,V>> iterator = this.pairs.iterator();
        while (iterator.hasNext()) {
            Pair<K,V> pair = iterator.next();
            if (pair.getKey().equals(key)) {
                pair.setValue(value); 
                return;
            }
        }
        this.pairs.add(new Pair<>(key, value)); 
    }

    public void remove(K key) {
        Iterator<Pair<K,V>> iterator = this.pairs.iterator();
        while (iterator.hasNext()) {
            Pair<K,V> pair = iterator.next();
            if (pair.getKey().equals(key)) {
                this.pairs.remove(pair);
                return;
            }
        }
    }

    public V get(K key) {
        Iterator<Pair<K,V>> iterator = this.pairs.iterator();
        while (iterator.hasNext()){
            Pair<K,V> pair = iterator.next();
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        return null;
    }

    public LinkedSet<K> keySet() {
        LinkedSet<K> set = new LinkedSet<K>();
        Iterator<Pair<K,V>> iterator = this.pairs.iterator();
        while (iterator.hasNext()){
            set.add(iterator.next().getKey());
        }
        return set;
    }

}
