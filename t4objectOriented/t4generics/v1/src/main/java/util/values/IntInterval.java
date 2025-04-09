package util.values;

public class IntInterval extends Interval<Integer> {

  public IntInterval(int min, int max) {
        super(min, max);
    }

  public IntInterval(Interval<Integer> interval) {
        this(interval.min(), interval.max());
    }

  public IntInterval(Integer max) {
        this(0, max);
    }

  public IntInterval() {
        this(0);
    }

  public Integer length() {
    return this.max() - this.min();
  }

  public Integer middlePoint() {
    return this.min() + this.length() / 2;
  }

  public IntInterval shifted(int shiftment) {
    return new IntInterval(this.min() + shiftment, this.max() + shiftment);
  }

  public IntInterval scaled(int scale) {
    Integer newMiddelPoint = this.middlePoint();
    Integer newHalfLength = this.length() * scale / 2;
    return new IntInterval(newMiddelPoint - newHalfLength, newMiddelPoint + newHalfLength);
  }

  public IntInterval symetric() {
    return new IntInterval(-this.max(), -this.min());
  }

  public boolean includes(Integer point) {
    assert point != null;

    return this.min() <= point && point <= this.max();
  }

  public boolean includes(IntInterval interval) {
    assert this != null;

    return this.includes(interval.min())
        && this.includes(interval.max());
  }

  public boolean isIntersected(IntInterval interval) {
    assert interval != null;

    return this.includes(interval.min())
        || this.includes(interval.max())
        || interval.includes(this);
  }

  public IntInterval intersection(IntInterval interval) {
    assert this.isIntersected(interval);

    if (this.includes(interval)) {
      return new IntInterval(interval);
    }
    if (interval.includes(this)) {
      return new IntInterval(this);
    }
    if (this.includes(interval.min())) {
      return new IntInterval(interval.min(), this.max());
    }
    return new IntInterval(this.min(), interval.max());
  }

  public IntInterval union(IntInterval interval) {
    assert this.isIntersected(interval);

    if (this.includes(interval)) {
      return new IntInterval(this);
    }
    if (interval.includes(this)) {
      return new IntInterval(interval);
    }
    if (this.includes(interval.min())) {
      return new IntInterval(this.min(), interval.max());
    }
    return new IntInterval(interval.min(), this.max());
  }

  public IntInterval superInterval(IntInterval interval) {
    assert interval != null;

    int min = this.min() < interval.min() ? this.min() : interval.min();
    int max = this.max() > interval.max() ? this.max() : interval.max();
    return new IntInterval(min, max);
  }

  public IntInterval[] split(int times) {
    assert times > 0;

    IntInterval[] intervals = new IntInterval[times];
    final int length = this.length() / times;
    intervals[0] = new IntInterval(this.min(), this.min() + length);
    for (int i = 1; i < intervals.length; i++) {
      intervals[i] = intervals[i - 1].shifted(length);
    }
    return intervals;
  }

}
