package util.values;

import util.collection.list.LinkedList;
import util.view.dialog.collection.list.TimeLinkedListDialog;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.TimeDialog;

public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public Pair(Pair<K,V> pair){
        this.key = pair.key;
        this.value = pair.value;
    }

    public K getKey() {
        return this.key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return this.value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public String toString() {
        return "Pair[" + this.key + " - " + this.value + "]";
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Pair))
            return false;
        Pair<K,V> other = (Pair<K,V>) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    public static void main(String[] args){
        LinkedList<Time> times = new LinkedList<Time>();
        for(Time time : new Time[]{
            new TimeDialog().create("1:1:1"),
            new TimeDialog().create("2:2:52"),
            new TimeDialog().create("3:3:53")
        }) {
            times.add(time);
        };
        Pair<DoubleInterval, LinkedList<Time>> pair = 
            new Pair<DoubleInterval, LinkedList<Time>>(
                new DoubleIntervalDialog().create("[1.1,2.2]"), 
                times);
        new DoubleIntervalDialog("Intervalo de decimales")
            .writeDetails(pair.getKey());
        new TimeLinkedListDialog("Listado de horas")
            .writeDetails(pair.getValue());
    }

}

