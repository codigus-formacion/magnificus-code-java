package util.values;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FractionTest {

    @Test
    public void testConstructorAndToString() {
        Fraction fraction = new Fraction(3, 4);
        assertEquals("Fraction (3/4)", fraction.toString());
    }

    @Test
    public void testAdd() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction result = fraction1.add(fraction2);
        assertEquals(new Fraction(5, 6), result);
    }

    @Test
    public void testSubtract() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction result = fraction1.subtract(fraction2);
        assertEquals(new Fraction(1, 6), result);
    }

    @Test
    public void testMultiply() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction result = fraction1.multiply(fraction2);
        assertEquals(new Fraction(1, 3), result);
    }

    @Test
    public void testDivide() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction result = fraction1.divide(fraction2);
        assertEquals(new Fraction(3, 4), result);
    }

    @Test
    public void testPower() {
        Fraction fraction = new Fraction(2, 3);
        Fraction result = fraction.power(2);
        assertEquals(new Fraction(4, 9), result);
    }

    @Test
    public void testEquals() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 2);
        Fraction fraction3 = new Fraction(2, 3);
        assertTrue(fraction1.equals(fraction2));
        assertFalse(fraction1.equals(fraction3));
    }

    @Test
    public void testCompareTo() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);
        Fraction fraction3 = new Fraction(1, 2);
        assertEquals(1, fraction1.compareTo(fraction2));
        assertEquals(0, fraction1.compareTo(fraction3));
        assertEquals(-1, fraction2.compareTo(fraction1));
    }

    @Test
    public void testValueOf() {
        Fraction fraction = new Fraction(1, 2);
        assertEquals(0.5, fraction.valueOf());
    }

    @Test
    public void testLesser() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        assertTrue(fraction1.lesser(fraction2));
        assertFalse(fraction2.lesser(fraction1));
    }

    @Test
    public void testGreater() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(1, 2);
        assertTrue(fraction1.greater(fraction2));
        assertFalse(fraction2.greater(fraction1));
    }

}