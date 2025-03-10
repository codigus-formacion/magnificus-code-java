package util.values;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathTest {

    @Test
    public void testGcd() {
        assertEquals(6, Math.gcd(54, 24));
        assertEquals(1, Math.gcd(17, 13));
        assertEquals(10, Math.gcd(100, 10));
    }

    @Test
    public void testRandomInt() {
        int bound = 10;
        int randomValue = Math.randomInt(bound);
        assertTrue(randomValue >= 0 && randomValue < bound);
    }

    @Test
    public void testNextDouble() {
        double bound = 10.0;
        double randomValue = Math.nextDouble(bound);
        assertTrue(randomValue >= 0.0 && randomValue < bound);
    }
    
}