package util.values;

import java.util.stream.IntStream;

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

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        return IntStream.rangeClosed(2, (int) java.lang.Math.sqrt(number))
                .noneMatch(i -> number % i == 0);
    }
}
