package util.view.dialog.values;

import util.collection.list.LinkedList;
import util.values.Fraction;
import util.values.FractionInterval;

public class FractionIntervalDialog extends IntervalDialog<FractionInterval, Fraction> {

    public FractionIntervalDialog(String title) {
        super(title);
    }

    public String regExp(){
        return this.regExp(new FractionDialog().regExp());
    }

    protected boolean isSemanticValid(String string) {
        LinkedList<Fraction> values = this.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    protected Fraction createElement(String element) {
        return new FractionDialog().create(element);
    }

    public FractionInterval create(String string) {
        assert this.isValid(string);

        LinkedList<Fraction> values = this.values(string);
        return new FractionInterval(values.get(0), values.get(1));
    }

    protected LinkedList<Fraction> values(String string) {
        assert this.isValid(string);

        LinkedList<Fraction> fractions = new LinkedList<Fraction>();
        LinkedList<String>.Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String fraction = iterator.next().element();
            fractions.add(new FractionDialog().create(fraction));
        }
        System.out.println(fractions.isEmpty());
        System.out.println(fractions.size());
        return fractions;
    }

    public void addContent(FractionInterval fractionInterval) {
        Fraction initial = new Fraction();
        FractionInterval pivot = new FractionInterval(new Fraction(1,2), new Fraction(3,4));

        this.addLine("getMin: " + fractionInterval.min());
        this.addLine("getMax: " + fractionInterval.max());
        this.addLine("includes 0: " + fractionInterval.includes(initial));
        this.addLine("includes [-1,1]: " + fractionInterval.includes(pivot));
        this.addLine("equals [-1,1]: " + fractionInterval.equals(pivot));
        this.addLine("isIntersected [-1,1]: " + fractionInterval.isIntersected(pivot));
        if (fractionInterval.isIntersected(pivot)) {
            this.addLine("intersection [-1,1]: " + fractionInterval.intersection(pivot));
            this.addLine("union [-1,1]: " + fractionInterval.union(pivot));
        }
        this.addLine("superInterval [-1,1]: " + fractionInterval.superInterval(pivot));

        this.addLine("length: " + fractionInterval.length());
        this.addLine("middlePoint: " + fractionInterval.middlePoint());
        this.addLine("shifted 1: " + fractionInterval.shifted(new Fraction(1)));
        this.addLine("scaled 2: " + fractionInterval.scaled(new Fraction(2)));
        this.addLine("symetric: " + fractionInterval.symetric());
        for (FractionInterval splitedInterval : fractionInterval.split(3)) {
            this.addLine("split: " + splitedInterval);
        }
    }
    
}
