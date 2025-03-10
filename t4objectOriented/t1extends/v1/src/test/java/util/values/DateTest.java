package util.values;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DateTest {

    @Test
    public void testConstructorAndToString() {
        Date date = new Date(2023, 5, 15);
        assertEquals("Date [2023/5/15]", date.toString());
    }

    @Test
    public void testIsValidMonth() {
        assertTrue(Date.isValidMonth(1));
        assertTrue(Date.isValidMonth(12));
        assertFalse(Date.isValidMonth(0));
        assertFalse(Date.isValidMonth(13));
    }

    @Test
    public void testIsValidDay() {
        assertTrue(Date.isValidDay(1));
        assertTrue(Date.isValidDay(30));
        assertFalse(Date.isValidDay(0));
        assertFalse(Date.isValidDay(31));
    }

    @Test
    public void testEquals() {
        Date date1 = new Date(2023, 5, 15);
        Date date2 = new Date(2023, 5, 15);
        Date date3 = new Date(2022, 5, 15);
        assertTrue(date1.equals(date2));
        assertFalse(date1.equals(date3));
    }

    @Test
    public void testBefore() {
        Date date1 = new Date(2023, 5, 15);
        Date date2 = new Date(2023, 5, 16);
        assertTrue(date1.before(date2));
        assertFalse(date2.before(date1));
    }

    @Test
    public void testAfter() {
        Date date1 = new Date(2023, 5, 15);
        Date date2 = new Date(2023, 5, 14);
        assertTrue(date1.after(date2));
        assertFalse(date2.after(date1));
    }

    @Test
    public void testCompareTo() {
        Date date1 = new Date(2023, 5, 15);
        Date date2 = new Date(2023, 5, 16);
        Date date3 = new Date(2023, 5, 15);
        assertEquals(-1, date1.compareTo(date2));
        assertEquals(0, date1.compareTo(date3));
        assertEquals(1, date2.compareTo(date1));
    }

    @Test
    public void testNext() {
        Date date1 = new Date(2023, 5, 15);
        Date nextDate = date1.next();
        assertEquals(new Date(2023, 5, 16), nextDate);

        Date date2 = new Date(2023, 5, 30);
        Date nextDate2 = date2.next();
        assertEquals(new Date(2023, 6, 1), nextDate2);

        Date date3 = new Date(2023, 12, 30);
        Date nextDate3 = date3.next();
        assertEquals(new Date(2024, 1, 1), nextDate3);
    }
}
