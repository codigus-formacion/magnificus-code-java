package utils;

public class Interval {
    
    private double min;
    private double max;

    public Interval(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public static Interval parseInterval(String string) {
        assert string != null;
        if (!string.matches("\\[\\s*-?\\d+(\\.\\d+)?\\s*,\\s*-?\\d+(\\.\\d+)?\\s*\\]")) {
            return null;
        }
        String[] partes = string.replaceAll("[\\[\\]\\s]", "").split(",");
        return new Interval(Double.parseDouble(partes[0]), Double.parseDouble(partes[1]));
    }

    @Override
    public String toString() {
        return "[min=" + min + ", max=" + max + "]";
    }


}

