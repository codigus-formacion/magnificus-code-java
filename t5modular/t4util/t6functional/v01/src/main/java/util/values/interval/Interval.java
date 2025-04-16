package util.values.interval;

public class Interval<E> {

    private final E min;
    private final E max;

    public Interval(E min, E max){
        this.min = min;
        this.max = max;
    }

    public Interval(Interval<E> interval) {
        this(interval.min, interval.max);
    }

    public Interval<E> clone() {
        return new Interval<E>(this.min, this.max);
    }

    public E min() {
        return this.min;
    }

    public E max() {
        return this.max;
    }

    @Override
    public String toString() {
        return "Interval [min=" + this.min + ", max=" + this.max + "]";
    }
    
}


