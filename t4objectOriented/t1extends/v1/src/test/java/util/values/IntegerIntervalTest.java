package util.values;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IntegerIntervalTest {

    @Test
    public void testConstructorAndToString() {
        IntegerInterval interval = new IntegerInterval(1, 10);
        assertEquals("Interval [min=1, max=10]", interval.toString());
    }

    @Test
    public void testIncludesPoint() {
        IntegerInterval interval = new IntegerInterval(1, 10);
        assertTrue(interval.includes(5));
        assertFalse(interval.includes(0));
    }

    @Test
    public void testIncludesInterval() {
        IntegerInterval interval1 = new IntegerInterval(1, 10);
        IntegerInterval interval2 = new IntegerInterval(3, 7);
        assertTrue(interval1.includes(interval2));
        assertFalse(interval2.includes(interval1));
    }

    @Test
    public void testIsIntersected() {
        IntegerInterval interval1 = new IntegerInterval(1, 10);
        IntegerInterval interval2 = new IntegerInterval(5, 15);
        assertTrue(interval1.isIntersected(interval2));
        assertTrue(interval2.isIntersected(interval1));
    }

    @Test
    public void testIntersection() {
        IntegerInterval interval1 = new IntegerInterval(1, 10);
        IntegerInterval interval2 = new IntegerInterval(5, 15);
        IntegerInterval intersection = (IntegerInterval) interval1.intersection(interval2);
        assertEquals(new IntegerInterval(5, 10), intersection);
    }

    @Test
    public void testUnion() {
        IntegerInterval interval1 = new IntegerInterval(1, 10);
        IntegerInterval interval2 = new IntegerInterval(5, 15);
        IntegerInterval union = (IntegerInterval) interval1.union(interval2);
        assertEquals(new IntegerInterval(1, 15), union);
    }

    @Test
    public void testLength() {
        IntegerInterval interval = new IntegerInterval(1, 10);
        assertEquals(9, interval.length());
    }

    @Test
    public void testMiddlePoint() {
        IntegerInterval interval = new IntegerInterval(1, 10);
        assertEquals(5, interval.middlePoint());
    }

    @Test
    public void testShifted() {
        IntegerInterval interval = new IntegerInterval(1, 10);
        IntegerInterval shifted = interval.shifted(5);
        assertEquals(new IntegerInterval(6, 15), shifted);
    }

    @Test
    public void testScaled() {
        IntegerInterval interval = new IntegerInterval(1, 10);
        IntegerInterval scaled = interval.scaled(2);
        assertEquals(new IntegerInterval(-4, 14), scaled);
    }

    @Test
    public void testSymetric() {
        IntegerInterval interval = new IntegerInterval(1, 10);
        IntegerInterval symetric = interval.symetric();
        assertEquals(new IntegerInterval(-10, -1), symetric);
    }

    @Test
    public void testSplit() {
        IntegerInterval interval = new IntegerInterval(1, 10);
        Interval<Integer>[] splits = interval.split(3);
        assertEquals(new IntegerInterval(1, 4), splits[0]);
        assertEquals(new IntegerInterval(4, 7), splits[1]);
        assertEquals(new IntegerInterval(7, 10), splits[2]);
    }
}