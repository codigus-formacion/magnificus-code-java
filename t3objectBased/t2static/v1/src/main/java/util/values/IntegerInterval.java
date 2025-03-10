package util.values;

public class IntegerInterval {

    private final int min;
    private final int max;

    public IntegerInterval(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public IntegerInterval(IntegerInterval interval) {
        this(interval.min, interval.max);
    }

    public IntegerInterval clone() {
        return new IntegerInterval(this.min, this.max);
    }

    public boolean includes(int point) {
        return this.min() <= point && point <= this.max();
    }

    public boolean isIntersected(IntegerInterval interval) {
        assert interval != null;

        return this.includes(interval.min())
                || this.includes(interval.max())
                || interval.includes(this);
    }

    public IntegerInterval intersection(IntegerInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return interval.clone();
        }
        if (interval.includes(this)) {
            return this.clone();
        }
        if (this.includes(interval.min())) {
            return new IntegerInterval(interval.min(), this.max());
        }
        return new IntegerInterval(this.min(), interval.max());
    }

    public IntegerInterval union(IntegerInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return this.clone();
        }
        if (interval.includes(this)) {
            return interval.clone();
        }
        if (this.includes(interval.min())) {
            return new IntegerInterval(this.min(), interval.max());
        }
        return new IntegerInterval(interval.min(), this.max());
    }

    public IntegerInterval superInterval(IntegerInterval interval) {
        assert interval != null;

        Integer min = this.min() < interval.min() ? this.min() : interval.min();
        Integer max = this.max() > interval.max() ? this.max() : interval.max();
        return new IntegerInterval(min, max);
    }

    public String toString() {
        return "Interval [min=" + this.min + ", max=" + this.max + "]";
    }

    public Integer min() {
        return this.min;
    }

    public Integer max() {
        return this.max;
    }

    public IntegerInterval(int max) {
        this(0, max);
    }

    public IntegerInterval() {
        this(0);
    }

    public Integer length() {
        return this.max() - this.min();
    }

    public Integer middlePoint() {
        return this.min() + this.length() / 2;
    }

    public IntegerInterval shifted(int shiftment) {
        return new IntegerInterval(this.min() + shiftment, this.max() + shiftment);
    }

    public IntegerInterval scaled(int scale) {
        int newMiddelPoint = this.middlePoint();
        int newHalfLength = this.length() * scale / 2;
        return new IntegerInterval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }

    public IntegerInterval symetric() {
        return new IntegerInterval(-this.max(), -this.min());
    }

    public boolean includes(IntegerInterval interval) {
        assert this != null;

        return this.includes(interval.min())
                && this.includes(interval.max());
    }

    public IntegerInterval[] split(int times) {
        assert times > 0;

        IntegerInterval[] intervals = new IntegerInterval[times];
        final Integer length = this.length() / times;
        intervals[0] = new IntegerInterval(this.min(), this.min() + length);
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }

}
