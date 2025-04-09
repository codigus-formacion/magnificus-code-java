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
