package util.values;

public abstract class Interval<T> {

    private final T min;
    private final T max;

    public Interval(T min, T max) {
        this.min = min;
        this.max = max;
    }

    public Interval(Interval<T> interval) {
        this(interval.min, interval.max);
    }

    public abstract T length();

    public abstract T middlePoint();

    public abstract Interval<T> shifted(T shiftment);

    public abstract Interval<T> scaled(T scale);

    public abstract Interval<T> symetric();

    public abstract boolean includes(T point);
    
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
            return this.create(interval.min, interval.max);
        }
        if (interval.includes(this)) {
            return this.create(this.min, this.max);
        }
        if (this.includes(interval.min())) {
            return this.create(interval.min(), this.max());
        }
        return this.create(this.min(), interval.max());
    }

    protected abstract Interval<T> copyOf(Interval<T> interval);

    protected abstract Interval<T> create(T min, T max);

    public Interval<T> union(Interval<T> interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return this.create(this.min, this.max);
        }
        if (interval.includes(this)) {
            return this.create(interval.min, interval.max);
        }
        if (this.includes(interval.min())) {
            return this.create(this.min(), interval.max());
        }
        return this.create(interval.min(), this.max());
    }

    public abstract Interval<T> superInterval(Interval<T> interval);

    public abstract Interval<T>[] split(int times);

    public T min() {
        return this.min;
    }

    public T max() {
        return this.max;
    }

    public boolean equals(Interval<T> interval){
        assert interval != null;

        return this.min().equals(interval.min()) 
            && this.max().equals(interval.max());
    }

    public String toString() {
        return "Interval [min=" + this.min + ", max=" + this.max + "]";
    }

}
