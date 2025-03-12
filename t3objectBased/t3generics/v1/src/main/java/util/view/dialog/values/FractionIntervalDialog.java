package util.view.dialog.values;

import util.collection.list.Iterator;
import util.collection.list.LinkedList;
import util.values.Fraction;
import util.values.FractionInterval;

public class FractionIntervalDialog {
    
    private IntervalDialog<FractionInterval> delegated;

    public FractionIntervalDialog(String title) {
        this.delegated = new IntervalDialog<FractionInterval>(title, FractionDialog.regExp());
    }    
    
    public FractionInterval read() {
        return FractionIntervalDialog.create(this.delegated.read());
    }

    public static FractionInterval create(String string) {
        LinkedList<Fraction> values = FractionIntervalDialog.values(string);
        return new FractionInterval(values.get(0), values.get(1));
    }

    private static LinkedList<Fraction> values(String string) {
        LinkedList<Fraction> fractions = new LinkedList<Fraction>();
        Iterator<String> iterator = IntervalDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            fractions.add(FractionDialog.create(iterator.next()));
        }
        return fractions;
    }

    public void write(FractionInterval interval) {
        this.delegated.write(interval);
    }

    public void writeln(FractionInterval interval) {
        this.delegated.writeln(interval);
    }

    public void writeDetails(FractionInterval interval) {
        this.delegated.addHead(interval);
        this.addContent(interval);
        this.delegated.writeDetails();
    }

    private void addContent(FractionInterval fractionInterval) {
        Fraction initial = new Fraction();
        FractionInterval pivot = new FractionInterval(new Fraction(1,2), new Fraction(3,4));

        this.delegated.addLine("toString: " + fractionInterval.toString());
        this.delegated.addLine("getMin: " + fractionInterval.min());
        this.delegated.addLine("getMax: " + fractionInterval.max());
        this.delegated.addLine("includes 0: " + fractionInterval.includes(initial));
        this.delegated.addLine("includes [-1,1]: " + fractionInterval.includes(pivot));
        this.delegated.addLine("equals [-1,1]: " + fractionInterval.equals(pivot));
        this.delegated.addLine("isIntersected [-1,1]: " + fractionInterval.isIntersected(pivot));
        if (fractionInterval.isIntersected(pivot)) {
            this.delegated.addLine("intersection [-1,1]: " + fractionInterval.intersection(pivot));
            this.delegated.addLine("union [-1,1]: " + fractionInterval.union(pivot));
        }
        this.delegated.addLine("superInterval [-1,1]: " + fractionInterval.superInterval(pivot));
        this.delegated.addLine("length: " + fractionInterval.length());
        this.delegated.addLine("middlePoint: " + fractionInterval.middlePoint());
        this.delegated.addLine("shifted 1: " + fractionInterval.shifted(new Fraction(1)));
        this.delegated.addLine("scaled 2: " + fractionInterval.scaled(2));
        this.delegated.addLine("symetric: " + fractionInterval.symetric());
        for (FractionInterval splitedInterval : fractionInterval.split(3)) {
            this.delegated.addLine("split: " + splitedInterval);
        }
    }
    
}
