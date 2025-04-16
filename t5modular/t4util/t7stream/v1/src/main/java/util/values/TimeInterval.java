package util.values;

import java.util.stream.IntStream;

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

        final Time length = this.length().divide(times);

        return IntStream.range(0, times)
                        .mapToObj(i -> new TimeInterval(this.min().add(length.multiply(i)), 
                                                        this.min().add(length.multiply(i + 1))))
                        .toArray(TimeInterval[]::new);
    }

}
