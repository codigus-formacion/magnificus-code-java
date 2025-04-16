package util.values.interval;

public class Interval {
    
    private double min;
    private double max;

    public Interval(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public static Interval parseInterval(String string) {
        assert string != null;
        
        if (!string.matches("\\[\\s*-?\\d+(\\.\\d+)?\\s*,\\s*-?\\d+(\\.\\d+)?\\s*\\]")){
            return null;
        }
        String[] partes = string.replaceAll("[\\[\\]\\s]", "").split(",");
        return new Interval(Double.parseDouble(partes[0]), Double.parseDouble(partes[1]));
    }

    public double length() {
        return this.max - this.min;
    }

    public Interval scale(double value){
        return null;
    }

    public Interval[] split(int times){
        return null;
    }

    public Interval symetric(){
        return null;
    }
    
    @Override
    public String toString() {
        return "[min=" + min + ", max=" + max + "]";
    }


}

