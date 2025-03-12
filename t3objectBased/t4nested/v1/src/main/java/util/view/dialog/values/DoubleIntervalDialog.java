package util.view.dialog.values;

import util.collection.list.LinkedList;
import util.values.DoubleInterval;
import util.view.dialog.primitive.DoubleDialog;

public class DoubleIntervalDialog {

    private IntervalDialog<DoubleInterval> delegated;

    public DoubleIntervalDialog(String title) {
        this.delegated = new IntervalDialog<DoubleInterval>(title, DoubleDialog.regExp());
    }

    public DoubleInterval read() {
        return DoubleIntervalDialog.create(this.delegated.read());
    }

    public static DoubleInterval create(String string) {
        LinkedList<Double> values = DoubleIntervalDialog.values(string);
        return new DoubleInterval(values.get(0), values.get(1));
    }

    private static LinkedList<Double> values(String string) {
        LinkedList<Double> doubleList = new LinkedList<Double>();
        LinkedList<String>.Iterator<String> iterator = IntervalDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            doubleList.add(DoubleDialog.create(iterator.next()));
        }
        return doubleList;
    }

    public void write(DoubleInterval doubleInterval) {
        this.delegated.write(doubleInterval);
    }

    public void writeln(DoubleInterval doubleInterval) {
        this.delegated.writeln(doubleInterval);
    }

    public void writeDetails(DoubleInterval doubleInterval) {
        this.delegated.addHead(doubleInterval);
        this.addContent(doubleInterval);
        this.delegated.writeDetails();
    }

    public void addContent(DoubleInterval interval) {
        Double initial = 0.0;
        DoubleInterval pivot = new DoubleInterval(-1.1, 1.1);
        this.delegated.addLine("getMin: " + interval.min());
        this.delegated.addLine("getMax: " + interval.max());
        this.delegated.addLine("includes 0: " + interval.includes(initial));
        this.delegated.addLine("includes [-1,1]: " + interval.includes(pivot));
        this.delegated.addLine("equals [-1,1]: " + interval.equals(pivot));
        this.delegated.addLine("isIntersected [-1,1]: " + interval.isIntersected(pivot));
        if (interval.isIntersected(pivot)) {
            this.delegated.addLine("intersection [-1,1]: " + interval.intersection(pivot));
            this.delegated.addLine("union [-1,1]: " + interval.union(pivot));
        }
        this.delegated.addLine("superInterval [-1,1]: " + interval.superInterval(pivot));
        this.delegated.addLine("length: " + interval.length());
        this.delegated.addLine("middlePoint: " + interval.middlePoint());
        this.delegated.addLine("shifted 1: " + interval.shifted(1));
        this.delegated.addLine("scaled 2: " + interval.scaled(2));
        this.delegated.addLine("symetric: " + interval.symetric());
        for (DoubleInterval splitedInterval : interval.split(3)) {
            this.delegated.addLine("split: " + splitedInterval);
        }
    }

}
