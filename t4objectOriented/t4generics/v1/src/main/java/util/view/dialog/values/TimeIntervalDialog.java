package util.view.dialog.values;

import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.Interval;
import util.values.Time;
import util.values.TimeInterval;

public class TimeIntervalDialog extends IntervalDialog<Time> {
    
    public TimeIntervalDialog(String title) {
        super(title, new TimeDialog().regExp());
    }   
    
    public TimeIntervalDialog() {
        this("");
    }

    public boolean isSemanticValid(String string){
        LinkedList<Time> values = this.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    public Interval<Time> create(String string) {
        LinkedList<Time> values = this.values(string);
        return new Interval<Time>(values.get(0), values.get(1));
    }

    protected LinkedList<Time> values(String string) {
        LinkedList<Time> fractions = new LinkedList<Time>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            fractions.add(new TimeDialog().create(iterator.next()));
        }
        return fractions;
    }

    protected void addContent(Interval<Time> element) {
        TimeInterval interval = new TimeInterval(element);
        Time initial = new Time(0,0,0);
        TimeInterval pivot = new TimeInterval(new Time(1,2,3), new Time(3,4,5));

        this.addLine("toString: " + interval.toString());
        this.addLine("getMin: " + interval.min());
        this.addLine("getMax: " + interval.max());
        this.addLine("includes 0:0:0: " + interval.includes(initial));
        this.addLine("includes [1:2:3,3:4:5]: " + interval.includes(pivot));
        this.addLine("equals [1:2:3,3:4:5]: " + interval.equals(pivot));
        this.addLine("isIntersected [1:2:3,3:4:5]: " + interval.isIntersected(pivot));
        if (interval.isIntersected(pivot)) {
            this.addLine("intersection [1:2:3,3:4:5]: " + interval.intersection(pivot));
            this.addLine("union [1:2:3,3:4:5]: " + interval.union(pivot));
        }
        this.addLine("superInterval [1:2:3,3:4:5]: " + interval.superInterval(pivot));
        this.addLine("length: " + interval.length());
        this.addLine("middlePoint: " + interval.middlePoint());
        this.addLine("shifted 1,1,1: " + interval.shifted(new Time(1,1,1)));
        this.addLine("scaled 2: " + interval.scaled(2));
        this.addLine("symetric: " + interval.symetric());
        for (TimeInterval splitedInterval : interval.split(3)) {
            this.addLine("split: " + splitedInterval);
        }
    }
    
}

