package util.values;

import java.util.Random;

public class Math {

    public static int gcd(int x, int y) {
        assert x > 0;
        assert y > 0;

        if (x == y)
            return x;
        if (x > y)
            return gcd(x - y, y);
        return gcd(x, y - x);
    }

    public static int randomInt(int bound) {
        return new Random().nextInt(bound);
    }

    public static double nextDouble(double bound) {
        return new Random().nextDouble() * bound;
    }

    public static boolean isPositive(Double value) {
        return value > 0;
    }

    public static boolean isPrime(int number) {
        if (number < 2)
            return false;
        for (int i = 2; i <= java.lang.Math.sqrt(number); i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }

}
