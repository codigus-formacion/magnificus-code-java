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
