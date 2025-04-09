package util.values;

public class FractionInterval extends Interval<Fraction> {

    public FractionInterval(Fraction min, Fraction max){
        super(min, max);
    }

    public FractionInterval(FractionInterval interval) {
        this(interval.min(), interval.max());
    }

    public FractionInterval(Fraction max) {
        this(new Fraction(), max);
    }

    public FractionInterval() {
        this(new Fraction());
    }

    public FractionInterval(Interval<Fraction> element) {
        super(element.min(), element.max());
    }

    public Fraction length() {
        return this.max().subtract(this.min());
    }

    public Fraction middlePoint() {
        return this.min().add(this.length().divide(2).get());
    }

    public FractionInterval shifted(Fraction shiftment) {
        return new FractionInterval(this.min().add(shiftment), this.max().add(shiftment));
    }

    public FractionInterval scaled(int scale) {
        Fraction newMiddelPoint = this.middlePoint();
        Fraction newHalfLength = this.length().multiply(scale / 2);
        return new FractionInterval(newMiddelPoint.subtract(newHalfLength), newMiddelPoint.add(newHalfLength));
    }

    public FractionInterval[] split(int times) {
        assert times > 0;

        FractionInterval[] intervals = new FractionInterval[times];
        final Fraction length = this.length().divide(times).get();
        intervals[0] = new FractionInterval(this.min(), this.min().add(length));
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }
    
}
