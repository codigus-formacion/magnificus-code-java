package util.values;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TimeTest {

    @Test
    public void testConstructorAndToString() {
        Time time = new Time(12, 30, 45);
        assertEquals("Time [12:30:45]", time.toString());
    }

    @Test
    public void testIsValidHour() {
        assertTrue(Time.isValidHour(0));
        assertTrue(Time.isValidHour(23));
        assertFalse(Time.isValidHour(-1));
        assertFalse(Time.isValidHour(24));
    }

    @Test
    public void testIsValidMinute() {
        assertTrue(Time.isValidMinute(0));
        assertTrue(Time.isValidMinute(59));
        assertFalse(Time.isValidMinute(-1));
        assertFalse(Time.isValidMinute(60));
    }

    @Test
    public void testIsValidSeconds() {
        assertTrue(Time.isValidSeconds(0));
        assertTrue(Time.isValidSeconds(59));
        assertFalse(Time.isValidSeconds(-1));
        assertFalse(Time.isValidSeconds(60));
    }

    @Test
    public void testEquals() {
        Time time1 = new Time(12, 30, 45);
        Time time2 = new Time(12, 30, 45);
        Time time3 = new Time(11, 30, 45);
        assertTrue(time1.equals(time2));
        assertFalse(time1.equals(time3));
    }

    @Test
    public void testBefore() {
        Time time1 = new Time(12, 30, 45);
        Time time2 = new Time(12, 30, 46);
        assertTrue(time1.before(time2));
        assertFalse(time2.before(time1));
    }

    @Test
    public void testAfter() {
        Time time1 = new Time(12, 30, 45);
        Time time2 = new Time(12, 30, 44);
        assertTrue(time1.after(time2));
        assertFalse(time2.after(time1));
    }

    @Test
    public void testCompareTo() {
        Time time1 = new Time(12, 30, 45);
        Time time2 = new Time(12, 30, 46);
        Time time3 = new Time(12, 30, 45);
        assertEquals(-1, time1.compareTo(time2));
        assertEquals(0, time1.compareTo(time3));
        assertEquals(1, time2.compareTo(time1));
    }

    @Test
    public void testNext() {
        Time time1 = new Time(12, 30, 45);
        Time nextTime = time1.next();
        assertEquals(new Time(12, 30, 46), nextTime);

        Time time2 = new Time(12, 30, 59);
        Time nextTime2 = time2.next();
        assertEquals(new Time(12, 31, 0), nextTime2);

        Time time3 = new Time(23, 59, 59);
        Time nextTime3 = time3.next();
        assertEquals(new Time(0, 0, 0), nextTime3);
    }
}
