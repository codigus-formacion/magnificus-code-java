package util.view.dialog.values;

import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.DoubleInterval;
import util.values.Interval;
import util.view.dialog.primitive.DoubleDialog;

public class DoubleIntervalDialog extends IntervalDialog<Double> {

    public DoubleIntervalDialog(String title) {
        super(title, new DoubleDialog().regExp());
    }
    
    public DoubleIntervalDialog() {
        this("");
    }

    public boolean isSemanticValid(String string){
        LinkedList<Double> values = this.values(string);
        return values.get(0)<=values.get(1);
    }

    public DoubleInterval create(String string) {
        LinkedList<Double> values = this.values(string);
        return new DoubleInterval(values.get(0), values.get(1));
    }

    protected LinkedList<Double> values(String string) {
        LinkedList<Double> doubleList = new LinkedList<Double>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            doubleList.add(new DoubleDialog().create(iterator.next()));
        }
        return doubleList;
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
        for (DoubleInterval splitedInterval : interval.split(3)) {
            this.addLine("split: " + splitedInterval);
        }
    }

}
