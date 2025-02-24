package util.values.fraction;

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
}
