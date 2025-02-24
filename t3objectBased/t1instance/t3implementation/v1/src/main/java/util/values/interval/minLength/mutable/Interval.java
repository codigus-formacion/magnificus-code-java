package util.values.interval.minLength.mutable;

public class Interval {
    
    private double min;
    private double length;

    public Interval(double min, double max) {
        this.min = min;
        this.length = max - min;
    }

    public Interval(double max) {
        this(0, max);
    }
  
    public Interval() {
        this(0);
    }
  
    public Interval(Interval interval) {
        this(interval.min(), interval.max());
    }

    public Interval clone() {
        return new Interval(this.min(), this.max());
    }
  
    public double length() {
        return this.max() - this.min();
    }
  
    public double middlePoint() {
        return this.min() + this.length() / 2;
    }
  
    public Interval shifted(double shiftment) {
        return new Interval(this.min() + shiftment, this.max() + shiftment);
    }
  
    public Interval scaled(double scale) {
      double newMiddelPoint = this.middlePoint();
      double newHalfLength = this.length() * scale / 2;
        return new Interval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
    }
  
    public Interval symetric() {
        return new Interval(-this.max(), -this.min());
    }
  
    public boolean includes(double point) {
        return this.min() <= point && point <= this.max();
    }
  
    public boolean includes(Interval interval) {
        assert this != null;
  
        return this.includes(interval.min())
                && this.includes(interval.max());
    }
  
    public boolean isIntersected(Interval interval) {
        assert this != null;
  
        return this.includes(interval.min())
                || this.includes(interval.max())
                || interval.includes(this);
    }
  
    public Interval intersection(Interval intervalo) {
        assert this.isIntersected(intervalo);
  
        if (this.includes(intervalo)) {
            return intervalo.clone();
        }
        if (intervalo.includes(this)) {
            return this.clone();
        }
        if (this.includes(intervalo.min())) {
            return new Interval(intervalo.min(), this.max());
        }
        return new Interval(this.min(), intervalo.max());
    }
  
    public Interval union(Interval intervalo) {
        assert this.isIntersected(intervalo);
  
        if (this.includes(intervalo)) {
            return this.clone();
        }
        if (intervalo.includes(this)) {
            return intervalo.clone();
        }
        if (this.includes(intervalo.min())) {
            return new Interval(this.min(), intervalo.max());
        }
        return new Interval(intervalo.min(), this.max());
    }

    public Interval superInterval(Interval interval){
        double min = this.min() < interval.min() ? this.min() : interval.min();
        double max = this.max() < interval.max() ? this.max() : interval.max();
        return new Interval(min, max);
    }
  
    public Interval[] split(int times) {
        assert times > 0;
        
        Interval[] intervals = new Interval[times];
        final double length = this.length() / times;
        intervals[0] = new Interval(this.min(), this.min() + length);
        for (int i = 1; i < intervals.length; i++) {
            intervals[i] = intervals[i-1].shifted(length);
        }
        return intervals;
    }
  
    public double min() {
        return this.min;
    }
  
    public double max() {
        return this.min() + this.length;
    }
    
    @Override
    public String toString() {
        return "Interval [min=" + this.min() + ", max=" + this.max() + "]";
    }

}

