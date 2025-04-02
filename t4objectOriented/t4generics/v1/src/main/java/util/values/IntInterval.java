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
