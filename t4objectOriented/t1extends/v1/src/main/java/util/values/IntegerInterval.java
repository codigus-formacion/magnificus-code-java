package util.values;

public class IntegerInterval extends Interval<Integer> {

    public IntegerInterval(Integer min, Integer max) {
        super(min, max);
    }
    
    public IntegerInterval(Integer max) {
        this(0, max);
    }

    public IntegerInterval() {
        this(0);
    }

    public IntegerInterval(Interval<Integer> interval) {
        this(interval.min(), interval.max());
    }

    public Integer length() {
        return this.max() - this.min();
    }

    public Integer middlePoint() {
        return this.min() + this.length() / 2;
    }

    public IntegerInterval shifted(Integer shiftment) {
        return new IntegerInterval(this.min() + shiftment, this.max() + shiftment);
    }

    public IntegerInterval scaled(Integer scale) {
        int newMiddelPoint = this.middlePoint();
        int newHalfLength = this.length() * scale / 2;
        return new IntegerInterval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }

    public IntegerInterval symetric() {
        return new IntegerInterval(-this.max(), -this.min());
    }

    protected IntegerInterval copyOf(Interval<Integer> interval) {
        return new IntegerInterval(interval);
    }
    
    protected Interval<Integer> create(Integer min, Integer max) {
        return new IntegerInterval(min, max);
    }

    public boolean includes(Integer point) {
        return this.min() <= point && point <= this.max();
    }

    public IntegerInterval superInterval(Interval<Integer> interval) {
        assert interval != null;

        Integer min = this.min() < interval.min() ? this.min() : interval.min();
        Integer max = this.max() > interval.max() ? this.max() : interval.max();
        return new IntegerInterval(min, max);
    }

    public Interval<Integer>[] split(int times) {
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
