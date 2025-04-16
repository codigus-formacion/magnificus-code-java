package util.values;

public class DoubleInterval extends Interval<Double> {

    public DoubleInterval(double min, double max) {
        super(min, max);
    }

    public DoubleInterval(Interval<Double> interval) {
        this(interval.min(), interval.max());
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
