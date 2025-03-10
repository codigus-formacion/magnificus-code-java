package util.values;

import java.util.Random;

public class Math {

    public int gcd(int x, int y) {
        assert x > 0;
        assert y > 0;

        if (x == y)
            return x;
        if (x > y)
            return gcd(x - y, y);
        return gcd(x, y - x);
    }

    public int randomInt(int bound) {
        return new Random().nextInt(bound);
    }

    public double nextDouble(double bound) {
        return new Random().nextDouble() * bound;
    }

}
