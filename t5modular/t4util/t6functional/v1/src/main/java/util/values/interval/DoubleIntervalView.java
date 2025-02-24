package util.values.interval;

import util.Console;

public class DoubleIntervalView {

    private final String inputTitle;
    private final String outputTitle;

    public DoubleIntervalView(String inputTitle, String outputTitle) {
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
    }

    public DoubleInterval read() {
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
        return new DoubleInterval(min, max);
    }

    public void write(DoubleInterval interval) {
        Console.instance().write(this.outputTitle + interval);
    }

    public void writeCharacteristics(DoubleInterval interval){
        String string = "\n=============";
        string += "\ntoString: " + interval.toString();
        string += "\ngetMin: " + interval.min();
        string += "\ngetMax: " + interval.max();
        string += "\nlength: " + interval.length();
        string += "\nmiddlePoint: " + interval.middlePoint();
        string += "\nhashCode: " + interval.hashCode();

        string += "\nclone: " + interval.clone();
        string += "\nshifted 1: " + interval.shifted(1);
        string += "\nscaled 2: " + interval.scaled(2);
        string += "\nsymetric: " + interval.symetric();

        string += "\nincludes 0: " + interval.includes(0);
        DoubleInterval pivot = new DoubleInterval(-1,1);
        string += "\nincludes [-1,1]: " + interval.includes(pivot);
        string += "\nequals [-1,1]: " + interval.equals(pivot);
        string += "\nisIntersected [-1,1]: " + interval.isIntersected(pivot);
        if (interval.isIntersected(pivot)){
            string += "\nintersection [-1,1]: " + interval.intersection(pivot);
            string += "\nunion [-1,1]: " + interval.union(pivot);
        }
        string += "\nsuperInterval [-1,1]: " + interval.superInterval(pivot);
        for(DoubleInterval splitedInterval : interval.split(3)){
            string += "\nsplit: " + splitedInterval;
        }
        Console.instance().writeln(string + "\n");
    }

}
