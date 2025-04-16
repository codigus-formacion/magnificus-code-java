package util.values.interval;

public class DoubleInterval {

    public static DoubleInterval parse(String string) {
        assert string.matches("\\[\\s*-?\\d+(\\.\\d+)?\\s*,\\s*-?\\d+(\\.\\d+)?\\s*\\]");
        
        String[] partes = string.replaceAll("[\\[\\]\\s]", "").split(",");
        return new DoubleInterval(Double.parseDouble(partes[0]), Double.parseDouble(partes[1]));
    }

    private final Interval<Double> delegated;
    
    public DoubleInterval(double min, double max){
        this.delegated = new Interval<Double>(min, max);
    }

    public DoubleInterval(double max) {
        this(0, max);
    }

    public DoubleInterval() {
        this(0);
    }

    public double length() {
        return this.delegated.max() - this.delegated.min();
    }

    public double middlePoint() {
        return this.delegated.min() + this.length() / 2;
    }

    public DoubleInterval shifted(double shiftment) {
        return new DoubleInterval(this.delegated.min() + shiftment, this.delegated.max() + shiftment);
    }

    public DoubleInterval scaled(double scale) {
        double newMiddelPoint = this.middlePoint();
        double newHalfLength = this.length() * scale / 2;
        return new DoubleInterval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }

    public DoubleInterval symetric() {
        return new DoubleInterval(-this.delegated.max(), -this.delegated.min());
    }

    public boolean includes(double point) {
        return this.delegated.min().compareTo(Double.valueOf(point)) <= 0 && Double.valueOf(point).compareTo(this.delegated.max()) <= 0;
    }

    public boolean includes(DoubleInterval interval) {
        assert this != null;

        return this.includes(interval.delegated.min()) 
                && this.includes(interval.delegated.max());
    }

    public boolean isIntersected(DoubleInterval interval) {
        assert this != null;

        return this.includes(interval.delegated.min())
                || this.includes(interval.delegated.max())
                || interval.includes(this);
    }

    public DoubleInterval intersection(DoubleInterval interval) {
        assert this.isIntersected(interval);
  
        if (this.includes(interval)) {
            return interval.clone();
        }
        if (interval.includes(this)) {
            return this.clone();
        }
        if (this.includes(interval.delegated.min())) {
            return new DoubleInterval(interval.delegated.min(), this.delegated.max());
        }
        return new DoubleInterval(this.delegated.min(), interval.delegated.max());
    }

    public DoubleInterval clone(){
        return new DoubleInterval();
    }

    public DoubleInterval union(DoubleInterval interval) {
        assert this.isIntersected(interval);

        if (this.includes(interval)) {
            return this.clone();
        }
        if (interval.includes(this)) {
            return interval.clone();
        }
        if (this.includes(interval.delegated.min())) {
            return new DoubleInterval(this.delegated.min(), interval.delegated.max());
        }
        return new DoubleInterval(interval.delegated.min(), this.delegated.max());
    }

    public DoubleInterval superInterval(DoubleInterval interval) {
        double min = this.delegated.min().compareTo(interval.delegated.min()) < 0 ? this.delegated.min() : interval.delegated.min();
        double max = this.delegated.max().compareTo(interval.delegated.max()) < 0 ? this.delegated.max() : interval.delegated.max();
        return new DoubleInterval(min, max);
    }

    public DoubleInterval[] split(int times) {
        assert times > 0;

        DoubleInterval[] intervals = new DoubleInterval[times];
        final double length = this.length() / times;
        intervals[0] = new DoubleInterval(this.delegated.min(), this.delegated.min() + length);
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i - 1].shifted(length);
        }
        return intervals;
    }

    public double min(){
        return this.delegated.min();
    }

    public double max(){
        return this.delegated.max();
    }

    public String toString() {
        return this.delegated.toString();
    }

}


