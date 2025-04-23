package util.view.dialog.collection.list;

import util.view.dialog.primitive.DoubleDialog;
import util.values.DoubleInterval;
import util.values.Math;
import util.collection.Iterator;
import util.collection.list.LinkedList;

public class DoubleLinkedListDialog extends LinkedListDialog<LinkedList<Double>> {

    public DoubleLinkedListDialog(String title) {
        super(title, new DoubleDialog().regExp());
    }

    public LinkedList<Double> create(String string) {
        LinkedList<Double> integers = new LinkedList<Double>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next();
            integers.add(new DoubleDialog().create(elementString));
        }
        return integers;
    }

    public void addContent(LinkedList<Double> linkedList) {
        double sum = 0;
        Iterator<Double> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        this.addLine("sum: " + sum);

        LinkedList<Double> mappedList = new LinkedList<Double>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        LinkedList<DoubleInterval> intervalList = new LinkedList<DoubleInterval>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Double integer = iterator.next();
            intervalList.add(new DoubleInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Double> doubleList = new LinkedList<Double>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            doubleList.add(iterator.next() * 2.0);
        }
        this.addLine("mapToDouble *2: " + doubleList);

        this.addLine("asDoubleList: " + doubleList.toString());
        this.addLine("filter PositivePredicate: " + linkedList.filter(Math::isPositive).toString());
        linkedList.forEach(element -> {
                addLine(": " + element);
            });
    }

}
