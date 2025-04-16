package util.values;

public class Interval<T extends Comparable<T>> {

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

    public boolean includes(T point) {
        assert point != null;

        return this.min().compareTo(point) <= 0 && point.compareTo(this.max()) <= 0;
    }
    
    public boolean includes(Interval<T> interval) {
        assert this != null;

        return this.includes(interval.min())
                && this.includes(interval.max());
    }

    public boolean isIntersected(Interval<T> interval) {
        assert interval != null;

        return this.includes(interval.min())
                || this.includes(interval.max())
                || interval.includes(this);
    }

    public Interval<T> intersection(Interval<T> interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return new Interval<T>(interval);
        }
        if (interval.includes(this)) {
            return new Interval<T>(this);
        }
        if (this.includes(interval.min())) {
            return new Interval<T>(interval.min(), this.max());
        }
        return new Interval<T>(this.min(), interval.max());
    }

    public Interval<T> union(Interval<T> interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return new Interval<T>(this);
        }
        if (interval.includes(this)) {
            return new Interval<T>(interval);
        }
        if (this.includes(interval.min())) {
            return new Interval<T>(this.min(), interval.max());
        }
        return new Interval<T>(interval.min(), this.max());
    }

    public Interval<T> superInterval(Interval<T> interval) {
        assert interval != null;

        T min = this.min().compareTo(interval.min()) < 0 ? this.min() : interval.min();
        T max = this.max().compareTo(interval.max()) > 0 ? this.max() : interval.max();
        return new Interval<T>(min, max);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((min == null) ? 0 : min.hashCode());
        result = prime * result + ((max == null) ? 0 : max.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Interval))
            return false;
        Interval<T> other = (Interval<T>) obj;
        if (min == null) {
            if (other.min != null)
                return false;
        } else if (!min.equals(other.min))
            return false;
        if (max == null) {
            if (other.max != null)
                return false;
        } else if (!max.equals(other.max))
            return false;
        return true;
    }

    

}
