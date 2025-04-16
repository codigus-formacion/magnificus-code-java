package util.values;

import java.util.stream.IntStream;

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

        final double length = this.length() / times;
        return IntStream.range(0, times)
            .mapToObj(index -> new DoubleInterval(this.min() + index * length, this.min() + (index + 1) * length))
            .toArray(DoubleInterval[]::new);
    }

    

}
