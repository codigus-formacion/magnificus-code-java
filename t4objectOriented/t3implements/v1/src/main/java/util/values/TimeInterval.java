package util.values;

public class TimeInterval extends Interval<Time> {

    public TimeInterval(Time min, Time max) {
        super(min, max);
    }
    
    public TimeInterval(Time max) {
        this(new Time(0, 0, 0), max);
    }

    public TimeInterval() {
        this(new Time(0, 0, 0));
    }

    public TimeInterval(Interval<Time> interval) {
        this(interval.min(), interval.max());
    }

    public Time length() {
        return this.max().subtract(this.min());
    }

    public Time middlePoint() {
        return this.min().add(this.length().divide(2));
    }

    public TimeInterval shifted(Time length) {
            return new TimeInterval(this.min().add(length), this.max().add(length));
    }

    public TimeInterval scaled(int scale) {
        Time newMiddelPoint = this.middlePoint();
        Time newHalfLength = this.length().multiply(scale / 2);
        return new TimeInterval(newMiddelPoint.subtract(newHalfLength), newMiddelPoint.add(newHalfLength));
    }

    public TimeInterval symetric() {
        return new TimeInterval(this.max().opposite(), this.min().opposite());
    }
    
    public boolean includes(Time point) {
        assert point != null;

        return this.min().compareTo(point) <= 0
                && point.compareTo(this.max()) <= 0;
    }

    public boolean includes(TimeInterval interval) {
        assert this != null;

        return this.includes(interval.min())
                && this.includes(interval.max());
    }

    public boolean isIntersected(TimeInterval interval) {
        assert interval != null;

        return this.includes(interval.min())
                || this.includes(interval.max())
                || interval.includes(this);
    }

    public TimeInterval intersection(TimeInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return new TimeInterval(interval);
        }
        if (interval.includes(this)) {
            return new TimeInterval(this);
        }
        if (this.includes(interval.min())) {
            return new TimeInterval(interval.min(), this.max());
        }
        return new TimeInterval(this.min(), interval.max());
    }

    public TimeInterval union(TimeInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return new TimeInterval(this);
        }
        if (interval.includes(this)) {
            return new TimeInterval(interval);
        }
        if (this.includes(interval.min())) {
            return new TimeInterval(this.min(), interval.max());
        }
        return new TimeInterval(interval.min(), this.max());
    }

    public TimeInterval superInterval(TimeInterval interval) {
        assert interval != null;

        Time min = this.min().compareTo(interval.min()) < 0 ? this.min()
                : interval.min();
        Time max = this.max().compareTo(interval.max()) > 0 ? this.max()
                : interval.max();
        return new TimeInterval(min, max);
    }

    public TimeInterval[] split(int times) {
        assert times > 0;

        TimeInterval[] intervals = new TimeInterval[times];
        final Time length = this.length().divide(times);
        intervals[0] = new TimeInterval(this.min(), this.min().add(length));
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }

}
