package util.values.interval;

public class DoubleInterval extends Interval<Double>{
    
    public static DoubleInterval parseInterval(String string) {
        assert string.matches("\\[\\s*-?\\d+(\\.\\d+)?\\s*,\\s*-?\\d+(\\.\\d+)?\\s*\\]");

        String[] partes = string.replaceAll("[\\[\\]\\s]", "").split(",");
        return new DoubleInterval(Double.parseDouble(partes[0]), Double.parseDouble(partes[1]));
    }

    public DoubleInterval(double min, double max){
        super(min, max);
    }
    
    public DoubleInterval(double max) {
        this(0, max);
    }

    public DoubleInterval() {
        this(0);
    }
    
    public double length() {
        return this.getMax() - this.getMin();
    }

    public double middlePoint() {
        return this.getMin() + this.length() / 2;
    }

    public DoubleInterval shifted(double shiftment) {
        return new DoubleInterval(this.getMin() + shiftment, this.getMax() + shiftment);
    }

    public DoubleInterval scaled(double scale) {
        double newMiddelPoint = this.middlePoint();
        double newHalfLength = this.length() * scale / 2;
        return new DoubleInterval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }

    public DoubleInterval symetric() {
        return new DoubleInterval(-this.getMax(), -this.getMin());
    }
    
}
