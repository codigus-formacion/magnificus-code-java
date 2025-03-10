package util.values;

public class DoubleInterval extends Interval<Double> {

    public DoubleInterval(Double min, Double max) {
        super(min, max);
    }

    public DoubleInterval(Double max) {
        this(0.0, max);
    }

    public DoubleInterval() {
        this(0.0);
    }

    public DoubleInterval(Interval<Double> interval) {
        this(interval.min(), interval.max());
    }

    public Double length() {
        return this.max() - this.min();
    }

    public Double middlePoint() {
        return this.min() + this.length() / 2;
    }

    public DoubleInterval shifted(Double shiftment) {
        return new DoubleInterval(this.min() + shiftment, this.max() + shiftment);
    }

    public DoubleInterval scaled(Double scale) {
        Double newMiddelPoint = this.middlePoint();
        Double newHalfLength = this.length() * scale / 2;
        return new DoubleInterval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }

    public DoubleInterval symetric() {
        return new DoubleInterval(-this.max(), -this.min());
    }

    protected DoubleInterval copyOf(Interval<Double> interval) {
        return new DoubleInterval(interval);
    }
    
    protected Interval<Double> create(Double min, Double max) {
        return new DoubleInterval(min, max);
    }

    public boolean includes(Double point) {
        assert point != null;

        return this.min() <= point && point <= this.max();
    }

    public Interval<Double> superInterval(Interval<Double> interval) {
        assert interval != null;

        Double min = this.min() < interval.min() ? this.min() : interval.min();
        Double max = this.max() > interval.max() ? this.max() : interval.max();
        return new DoubleInterval(min, max);
    }

    public DoubleInterval[] split(int times) {
        assert times > 0;

        DoubleInterval[] intervals = new DoubleInterval[times];
        final Double length = this.length() / times;
        intervals[0] = new DoubleInterval(this.min(), this.min() + length);
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }

}
