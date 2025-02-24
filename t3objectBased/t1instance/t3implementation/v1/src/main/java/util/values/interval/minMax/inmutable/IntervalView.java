package util.values.interval.minMax.inmutable;

import util.Console;

public class IntervalView {

    private final String inputTitle;
    private final String outputTitle;
    private final Console console;

    public IntervalView(String inputTitle, String outputTitle) {
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
        this.console = new Console();
    }

    public Interval read() {
        Console console = new Console();
        double min;
        double max;
        boolean valid;
        console.writeln(this.inputTitle);
        do {
            min = console.readDouble("Min: ");
            max = console.readDouble("Max: ");
            valid = min <= max;
            if (!valid) {
                console.writeln("Fallo!!!" + this.outputTitle);
            }
        } while (!valid);
        return new Interval(min, max);
    }

    public void write(Interval interval) {
        new Console().write(this.inputTitle + interval);
    }

    public void writeln(Interval interval){
        this.write(interval);
        new Console().writeln();
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
        this.console.writeln(string + "\n");
    }

}
