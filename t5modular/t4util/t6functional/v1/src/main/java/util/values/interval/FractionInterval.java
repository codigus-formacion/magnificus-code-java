package util.values.interval;

import util.values.fraction.Fraction;

public class FractionInterval {

    private final Interval<Fraction> delegated;

    public FractionInterval(Fraction min, Fraction max) {
        this.delegated = new Interval<Fraction>(min, max);
    }

    public FractionInterval(Fraction max) {
        this(new Fraction(), max);
    }

    public FractionInterval() {
        this(new Fraction());
    }

    public Fraction length() {
        return this.delegated.max().subtract(this.delegated.min());
    }

    public Fraction middlePoint() {
        return this.delegated.min().add(this.length().divide(2));
    }

    public FractionInterval shifted(Fraction shiftment) {
        return new FractionInterval(this.delegated.min().add(shiftment), this.delegated.max().add(shiftment));
    }

    public FractionInterval scaled(int scale) {
        Fraction newMiddelPoint = this.middlePoint();
        Fraction newHalfLength = this.length().multiply(scale / 2);
        return new FractionInterval(newMiddelPoint.subtract(newHalfLength), newMiddelPoint.add(newHalfLength));
    }

    public FractionInterval symetric() {
        return new FractionInterval(this.delegated.max().opposite(), this.delegated.min().opposite());
    }

    public boolean includes(Fraction point) {
        return this.delegated.min().lesser(point)
                && point.lesser(this.delegated.max());
    }

    public boolean includes(FractionInterval interval) {
        assert this != null;

        return this.includes(interval.delegated.min())
                && this.includes(interval.delegated.max());
    }

    public boolean isIntersected(FractionInterval interval) {
        assert this != null;

        return this.includes(interval.delegated.min())
                || this.includes(interval.delegated.max())
                || interval.includes(this);
    }

    public FractionInterval intersection(FractionInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return interval.clone();
        }
        if (interval.includes(this)) {
            return this.clone();
        }
        if (this.includes(interval.delegated.min())) {
            return new FractionInterval(interval.delegated.min(), this.delegated.max());
        }
        return new FractionInterval(this.delegated.min(), interval.delegated.max());
    }

    public FractionInterval clone() {
        return new FractionInterval();
    }

    public FractionInterval union(FractionInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return this.clone();
        }
        if (interval.includes(this)) {
            return interval.clone();
        }
        if (this.includes(interval.delegated.min())) {
            return new FractionInterval(this.delegated.min(), interval.delegated.max());
        }
        return new FractionInterval(interval.delegated.min(), this.delegated.max());
    }

    public FractionInterval superInterval(FractionInterval interval) {
        Fraction min = this.delegated.min().lesser(interval.delegated.min()) ? this.delegated.min()
                : interval.delegated.min();
        Fraction max = this.delegated.max().lesser(interval.delegated.max()) ? this.delegated.max()
                : interval.delegated.max();
        return new FractionInterval(min, max);
    }

    public FractionInterval[] split(int times) {
        assert times > 0;

        FractionInterval[] intervals = new FractionInterval[times];
        final Fraction length = this.length().divide(times);
        intervals[0] = new FractionInterval(this.delegated.min(), this.delegated.min().add(length));
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }

    public Fraction min() {
        return this.delegated.min();
    }

    public Fraction max() {
        return this.delegated.max();
    }

    public String toString() {
        return this.delegated.toString();
    }

}
