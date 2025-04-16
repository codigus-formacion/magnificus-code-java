package util.values;

public class IntegerInterval extends Interval<Integer> {

    public IntegerInterval(int min, int max) {
        super(min, max);
    }

    public IntegerInterval(int max) {
        this(0, max);
    }

    public IntegerInterval(Interval<Integer> interval) {
        this(interval.min(), interval.max());
    }

    public IntegerInterval() {
        this(0);
    }

    public Integer length() {
        return this.max() - this.min();
    }

    public Integer middlePoint() {
        return this.min() + this.length() / 2;
    }

    public IntegerInterval shifted(int shiftment) {
        return new IntegerInterval(this.min() + shiftment, this.max() + shiftment);
    }

    public IntegerInterval scaled(int scale) {
        int newMiddelPoint = this.middlePoint();
        int newHalfLength = this.length() * scale / 2;
        return new IntegerInterval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }

    public IntegerInterval symetric() {
        return new IntegerInterval(-this.max(), -this.min());
    }

    public IntegerInterval[] split(int times) {
        assert times > 0;

        final Integer length = this.length() / times;
        return java.util.stream.IntStream.range(0, times)
            .mapToObj(i -> new IntegerInterval(this.min() + i * length, this.min() + (i + 1) * length))
            .toArray(IntegerInterval[]::new);
    }

}
