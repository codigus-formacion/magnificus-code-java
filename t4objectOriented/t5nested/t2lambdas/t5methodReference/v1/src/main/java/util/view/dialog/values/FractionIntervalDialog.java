package util.view.dialog.values;

import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.Fraction;
import util.values.FractionInterval;
import util.values.Interval;

public class FractionIntervalDialog extends IntervalDialog<Fraction> {
    
    public FractionIntervalDialog(String title) {
        super(title, new FractionDialog().regExp());
    }   
    
    public FractionIntervalDialog() {
        this("");
    }

    public boolean isSemanticValid(String string){
        LinkedList<Fraction> values = this.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    public Interval<Fraction> create(String string) {
        LinkedList<Fraction> values = this.values(string);
        return new Interval<Fraction>(values.get(0), values.get(1));
    }

    protected LinkedList<Fraction> values(String string) {
        LinkedList<Fraction> fractions = new LinkedList<Fraction>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            fractions.add(new FractionDialog().create(iterator.next()));
        }
        return fractions;
    }

    protected void addContent(Interval<Fraction> element) {
        FractionInterval interval = new FractionInterval(element);
        Fraction initial = new Fraction();
        FractionInterval pivot = new FractionInterval(new Fraction(1,2), new Fraction(3,4));

        this.addLine("toString: " + interval.toString());
        this.addLine("getMin: " + interval.min());
        this.addLine("getMax: " + interval.max());
        this.addLine("includes 0: " + interval.includes(initial));
        this.addLine("includes [-1,1]: " + interval.includes(pivot));
        this.addLine("equals [-1,1]: " + interval.equals(pivot));
        this.addLine("isIntersected [-1,1]: " + interval.isIntersected(pivot));
        if (interval.isIntersected(pivot)) {
            this.addLine("intersection [-1,1]: " + interval.intersection(pivot));
            this.addLine("union [-1,1]: " + interval.union(pivot));
        }
        this.addLine("superInterval [-1,1]: " + interval.superInterval(pivot));
        this.addLine("length: " + interval.length());
        this.addLine("middlePoint: " + interval.middlePoint());
        this.addLine("shifted 1: " + interval.shifted(new Fraction(1)));
        this.addLine("scaled 2: " + interval.scaled(2));
        for (FractionInterval splitedInterval : interval.split(3)) {
            this.addLine("split: " + splitedInterval);
        }
    }
    
}
