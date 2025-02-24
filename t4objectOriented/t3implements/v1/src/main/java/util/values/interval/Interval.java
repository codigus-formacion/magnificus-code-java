package util.values.interval;

public class Interval<E extends Comparable<E>> {

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

    public boolean includes(E point) {
        return this.min.compareTo(point) <= 0 && point.compareTo(this.max) <= 0;
    }

    public boolean includes(Interval<E> interval) {
        assert this != null;

        return this.includes(interval.min) 
                && this.includes(interval.max);
    }

    public boolean isIntersected(Interval<E> interval) {
        assert this != null;

        return this.includes(interval.min)
                || this.includes(interval.max)
                || interval.includes(this);
    }

    public Interval<E> intersection(Interval<E> interval) {
        assert this.isIntersected(interval);
  
        if (this.includes(interval)) {
            return interval.clone();
        }
        if (interval.includes(this)) {
            return this.clone();
        }
        if (this.includes(interval.min)) {
            return new Interval<E>(interval.min, this.max);
        }
        return new Interval<E>(this.min, interval.max);
    }

    public Interval<E> union(Interval<E> interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return this.clone();
        }
        if (interval.includes(this)) {
            return interval.clone();
        }
        if (this.includes(interval.min)) {
            return new Interval<E>(this.min, interval.max);
        }
        return new Interval<E>(interval.min, this.max);
    }

    public Interval<E> superInterval(Interval<E> interval) {
        E min = this.min.compareTo(interval.min) < 0 ? this.min : interval.min;
        E max = this.max.compareTo(interval.max) < 0 ? this.max : interval.max;
        return new Interval<E>(min, max);
    }

    public E getMin() {
        return this.min;
    }

    public E getMax() {
        return this.max;
    }

    @Override
    public String toString() {
        return "Interval [min=" + this.min + ", max=" + this.max + "]";
    }
    
}


