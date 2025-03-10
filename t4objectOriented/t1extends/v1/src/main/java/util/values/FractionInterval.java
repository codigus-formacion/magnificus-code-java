package util.values;

public class FractionInterval extends Interval<Fraction> {

    public FractionInterval(Fraction min, Fraction max){
        super(min, max);
    }

    public FractionInterval(Fraction max) {
        this(new Fraction(), max);
    }

    public FractionInterval() {
        this(new Fraction());
    }

    public FractionInterval(Interval<Fraction> interval) {
        this(interval.min(), interval.max());
    }

    public Fraction length() {
        return this.max().subtract(this.min());
    }

    public Fraction middlePoint() {
        return this.min().add(this.length().divide(2));
    }

    public FractionInterval shifted(Fraction shiftment) {
        return new FractionInterval(this.min().add(shiftment), this.max().add(shiftment));
    }

    public FractionInterval scaled(Fraction scale) {
        Fraction newMiddelPoint = this.middlePoint();
        Fraction newHalfLength = this.length().multiply(scale.divide(2));
        return new FractionInterval(newMiddelPoint.subtract(newHalfLength), newMiddelPoint.add(newHalfLength));
    }

    public FractionInterval symetric() {
        return new FractionInterval(this.max().opposite(), this.min().opposite());
    }

    protected FractionInterval copyOf(Interval<Fraction> interval) {
        return new FractionInterval(interval);
    }

    protected Interval<Fraction> create(Fraction min, Fraction max) {
        return new FractionInterval(min, max);
    }

    public boolean includes(Fraction point) {
        assert point != null;

        return this.min().compareTo(point) <= 0
                && point.compareTo(this.max()) <= 0;
    }

    public FractionInterval superInterval(Interval<Fraction> interval) {
        assert interval != null;

        Fraction min = this.min().compareTo(interval.min()) < 0 ? this.min()
                : interval.min();
                Fraction max = this.max().compareTo(interval.max()) > 0 ? this.max()
                : interval.max();
        return new FractionInterval(min, max);
    }

    public FractionInterval[] split(int times) {
        assert times > 0;

        FractionInterval[] intervals = new FractionInterval[times];
        final Fraction length = this.length().divide(times);
        intervals[0] = new FractionInterval(this.min(), this.min().add(length));
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }
    
}
