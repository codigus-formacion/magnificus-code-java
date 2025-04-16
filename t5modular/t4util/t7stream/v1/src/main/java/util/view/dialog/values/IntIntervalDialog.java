package util.view.dialog.values;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

import util.values.DoubleInterval;
import util.values.IntegerInterval;
import util.values.Interval;
import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

public class IntIntervalDialog extends IntervalDialog<Integer> {

    public IntIntervalDialog(String title) {
        super(title, new DoubleDialog().regExp());
    }

    public IntIntervalDialog() {
        this("");
    }

    public boolean isSemanticValid(String string) {
        LinkedList<Integer> values = this.values(string);
        return values.get(0) <= values.get(1);
    }

    public IntegerInterval create(String string) {
        LinkedList<Integer> values = this.values(string);
        return new IntegerInterval(values.get(0), values.get(1));
    }

    protected LinkedList<Integer> values(String string) {
        return this.strings(string).stream()
                .map(value -> new IntDialog().create(value))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void addContent(Interval<Double> element) {
        Double initial = 0.0;
        DoubleInterval interval = new DoubleInterval(element.min(), element.max());
        DoubleInterval pivot = new DoubleInterval(-1.1, 1.1);
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
        this.addLine("shifted 1: " + interval.shifted(1));
        this.addLine("scaled 2: " + interval.scaled(2));
        this.addLine("symetric: " + interval.symetric());
        Arrays.stream(interval.split(3))
            .map(splitedInterval -> "split: " + splitedInterval)
            .forEach(this::addLine);
    }

}
