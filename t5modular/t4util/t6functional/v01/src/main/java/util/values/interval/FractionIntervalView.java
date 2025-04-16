package util.values.interval;

import util.Console;
import util.values.fraction.Fraction;
import util.values.fraction.FractionView;

public class FractionIntervalView {

    private final String inputTitle;
    private final String outputTitle;

    public FractionIntervalView(String inputTitle, String outputTitle) {
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
    }

    public Interval<Fraction> read() {
        FractionView fractionView = new FractionView("Intervalo: ", "Formato incorrecto");
        Fraction min;
        Fraction max;
        boolean valid;
        Console.instance().writeln(this.inputTitle);
        do {
            min = fractionView.read();
            max = fractionView.read();
            valid = min.lesser(max);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.outputTitle);
            }
        } while (!valid);
        return new Interval<Fraction>(min, max);
    }

    public void write(FractionInterval interval) {
        Console.instance().write(this.outputTitle + interval);
    }

    public void writeCharacteristics(Interval<Fraction> interval){
        String string = "\n=============";
        string += "\ntoString: " + interval.toString();
        string += "\ngetMin: " + interval.min();
        string += "\ngetMax: " + interval.max();
        string += "\nlength: " + interval.length();
        string += "\nmiddlePoint: " + interval.middlePoint();
        string += "\nhashCode: " + interval.hashCode();

        string += "\nclone: " + interval.clone();
        string += "\nshifted 1: " + interval.shifted(new Fraction(1));
        string += "\nscaled 2: " + interval.scaled(2);
        string += "\nsymetric: " + interval.symetric();

        string += "\nincludes 0: " + interval.includes(new Fraction());
        FractionInterval pivot = new FractionInterval(new Fraction(-1),new Fraction(1));
        string += "\nincludes [-1,1]: " + interval.includes(pivot);
        string += "\nequals [-1,1]: " + interval.equals(pivot);
        string += "\nisIntersected [-1,1]: " + interval.isIntersected(pivot);
        if (interval.isIntersected(pivot)){
            string += "\nintersection [-1,1]: " + interval.intersection(pivot);
            string += "\nunion [-1,1]: " + interval.union(pivot);
        }
        string += "\nsuperInterval [-1,1]: " + interval.superInterval(pivot);
        for(FractionInterval splitedInterval : interval.split(3)){
            string += "\nsplit: " + splitedInterval;
        }
        Console.instance().writeln(string + "\n");
    }

    public static Interval<Fraction> parse(String string) {
        if (!string.matches("\\[(-?\\d+/\\d+), (-?\\d+/\\d+)\\]")){
            return null;
        }
        String[] splitedStrings = string.replaceAll("[\\[\\]\\s]", "").split(",");
        return new Interval<Fraction>(FractionView.parse(splitedStrings[0]), FractionView.parse(splitedStrings[1]));
    }

}
