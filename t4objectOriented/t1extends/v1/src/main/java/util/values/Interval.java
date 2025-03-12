package util.values;

public class Interval<T> {

    private final T min;
    private final T max;

    public Interval(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public Interval(Interval<T> interval) {
        this(interval.min(), interval.max());
    }

    public String toString() {
        return "Interval [min=" + this.min + ", max=" + this.max + "]";
    }

    public T min() {
        return this.min;
    }

    public T max() {
        return this.max;
    }

}
