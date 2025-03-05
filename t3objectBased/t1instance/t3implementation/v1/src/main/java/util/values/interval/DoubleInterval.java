package util.values.interval;

public class DoubleInterval {

    private final double min;
    private final double max;

    public DoubleInterval(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public DoubleInterval(DoubleInterval interval) {
        this(interval.min, interval.max);
    }

    public DoubleInterval clone() {
        return new DoubleInterval(this.min, this.max);
    }

    public boolean includes(Double point) {
        assert point != null;

        return this.min() <= point && point <= this.max();
    }

    public boolean isIntersected(DoubleInterval interval) {
        assert interval != null;

        return this.includes(interval.min())
                || this.includes(interval.max())
                || interval.includes(this);
    }

    public DoubleInterval intersection(DoubleInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return interval.clone();
        }
        if (interval.includes(this)) {
            return this.clone();
        }
        if (this.includes(interval.min())) {
            return new DoubleInterval(interval.min(), this.max());
        }
        return new DoubleInterval(this.min(), interval.max());
    }

    public DoubleInterval union(DoubleInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return this.clone();
        }
        if (interval.includes(this)) {
            return interval.clone();
        }
        if (this.includes(interval.min())) {
            return new DoubleInterval(this.min(), interval.max());
        }
        return new DoubleInterval(interval.min(), this.max());
    }

    public DoubleInterval superInterval(DoubleInterval interval) {
        assert interval != null;

        double min = this.min() < interval.min() ? this.min() : interval.min();
        double max = this.max() > interval.max() ? this.max() : interval.max();
        return new DoubleInterval(min, max);
    }

    public String toString() {
        return "Interval [min=" + this.min + ", max=" + this.max + "]";
    }

    public double min() {
        return this.min;
    }

    public double max() {
        return this.max;
    }

    public DoubleInterval(Double max) {
        this(0.0, max);
    }

    public DoubleInterval() {
        this(0.0);
    }

    public Double length() {
        return this.max() - this.min();
    }

    public Double middlePoint() {
        return this.min() + this.length() / 2;
    }

    public DoubleInterval shifted(double shiftment) {
        return new DoubleInterval(this.min() + shiftment, this.max() + shiftment);
    }

    public DoubleInterval scaled(double scale) {
        Double newMiddelPoint = this.middlePoint();
        Double newHalfLength = this.length() * scale / 2;
        return new DoubleInterval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }

    public DoubleInterval symetric() {
        return new DoubleInterval(-this.max(), -this.min());
    }

    public boolean includes(DoubleInterval interval) {
        assert this != null;

        return this.includes(interval.min())
                && this.includes(interval.max());
    }

    public DoubleInterval[] split(int times) {
        assert times > 0;

        DoubleInterval[] intervals = new DoubleInterval[times];
        final double length = this.length() / times;
        intervals[0] = new DoubleInterval(this.min(), this.min() + length);
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }

}
