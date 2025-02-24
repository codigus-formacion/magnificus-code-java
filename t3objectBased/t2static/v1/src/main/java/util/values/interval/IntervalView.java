package util.values.interval;

import util.Console;

public class IntervalView {

    private final String inputTitle;
    private final String outputTitle;

    public IntervalView(String inputTitle, String outputTitle) {
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
    }

    public Interval read() {
        double min;
        double max;
        boolean valid;
        Console.instance().writeln(this.inputTitle);
        do {
            min = Console.instance().readDouble("Min: ");
            max = Console.instance().readDouble("Max: ");
            valid = min <= max;
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.outputTitle);
            }
        } while (!valid);
        return new Interval(min, max);
    }

    public void write(Interval interval) {
        Console.instance().write(this.inputTitle + interval);
    }

    public void writeln(Interval interval){
        this.write(interval);
        Console.instance().writeln();
    }

    public void writeCharacteristics(Interval interval) {
        String string = "=============";
        string += "\ntoString: " + interval.toString();
        string += "\nmax: " + interval.min();
        string += "\nmax: " + interval.max();
        string += "\nlength: " + interval.length();
        string += "\nmiddlePoint: " + interval.middlePoint();
        string += "\nhashCode: " + interval.hashCode();

        string += "\nclone: " + interval.clone();
        string += "\nshifted 1: " + interval.shifted(1);
        string += "\nscaled 2: " + interval.scaled(2);
        string += "\nsymetric: " + interval.symetric();

        string += "\nincludes 0: " + interval.includes(new Interval(0));
        Interval pivot = new Interval(-1, 1);
        string += "\nincludes [-1,1]: " + interval.includes(pivot);
        string += "\nequals [-1,1]: " + interval.equals(pivot);
        string += "\nisIntersected [-1,1]: " + interval.isIntersected(pivot);
        if (interval.isIntersected(pivot)) {
            string += "\nintersection [-1,1]: " + interval.intersection(pivot);
            string += "\nunion [-1,1]: " + interval.union(pivot);
        }
        string += "\nsuperInterval [-1,1]: " + interval.superInterval(pivot);
        for (Interval splitedInterval : interval.split(3)) {
            string += "\nsplit: " + splitedInterval;
        }
        Console.instance().writeln(string + "\n");
    }

}
