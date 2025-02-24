package util.values.interval;

public class Interval {

    private final double min;
    private final double max;

    public static Interval parse(String string) {
        if (!string.matches("\\[\\s*-?\\d+(\\.\\d+)?\\s*,\\s*-?\\d+(\\.\\d+)?\\s*\\]")){
            return null;
        }
        String[] partes = string.replaceAll("[\\[\\]\\s]", "").split(",");
        return new Interval(Double.parseDouble(partes[0]), Double.parseDouble(partes[1]));
    }

    public Interval(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public Interval(double max) {
        this(0, max);
    }

    public Interval() {
        this(0);
    }

    public Interval(Interval interval) {
        this(interval.min, interval.max);
    }

    public Interval clone() {
        return new Interval(this.min, this.max);
    }

    public double length() {
        return this.max - this.min;
    }

    public double middlePoint() {
        return this.min + this.length() / 2;
    }

    public Interval shifted(double shiftment) {
        return new Interval(this.min + shiftment, this.max + shiftment);
    }

    public Interval scaled(double scale) {
        double newMiddelPoint = this.middlePoint();
        double newHalfLength = this.length() * scale / 2;
        return new Interval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }

    public Interval symetric() {
        return new Interval(-this.max, -this.min);
    }

    public boolean includes(double point) {
        return this.min <= point && point <= this.max;
    }

    public boolean includes(Interval interval) {
        assert this != null;

        return this.includes(interval.min) 
                && this.includes(interval.max);
    }

    public boolean isIntersected(Interval interval) {
        assert this != null;

        return this.includes(interval.min)
                || this.includes(interval.max)
                || interval.includes(this);
    }

    public Interval intersection(Interval interval) {
        assert this.isIntersected(interval);
  
        if (this.includes(interval)) {
            return interval.clone();
        }
        if (interval.includes(this)) {
            return this.clone();
        }
        if (this.includes(interval.min)) {
            return new Interval(interval.min, this.max);
        }
        return new Interval(this.min, interval.max);
    }

    public Interval union(Interval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return this.clone();
        }
        if (interval.includes(this)) {
            return interval.clone();
        }
        if (this.includes(interval.min)) {
            return new Interval(this.min, interval.max);
        }
        return new Interval(interval.min, this.max);
    }

    public Interval superInterval(Interval interval) {
        double min = this.min < interval.min ? this.min : interval.min;
        double max = this.max > interval.max ? this.max : interval.max;
        return new Interval(min, max);
    }

    public Interval[] split(int times) {
        assert times > 0;

        Interval[] intervals = new Interval[times];
        final double length = this.length() / times;
        intervals[0] = new Interval(this.min, this.min + length);
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }

    public double min() {
        return this.min;
    }

    public double max() {
        return this.max;
    }

    @Override
    public String toString() {
        return "Interval [min=" + this.min + ", max=" + this.max + "]";
    }

}

