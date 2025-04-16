package util.view.dialog.collection.list;

import util.view.dialog.primitive.DoubleDialog;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import util.values.DoubleInterval;

public class DoubleLinkedListDialog extends LinkedListDialog<List<Double>> {

    public DoubleLinkedListDialog(String title) {
        super(title, new DoubleDialog().regExp());
    }

    public List<Double> create(String string) {
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
        for(Double element : linkedList) {
            sum += element;
        }
        this.addLine("sum: " + sum);

        LinkedList<Double> mappedList = new LinkedList<Double>();
        for(Double element : linkedList) {
            mappedList.add(element + 1);
        }
        this.addLine("map + 1: " + mappedList);

        LinkedList<DoubleInterval> intervalList = new LinkedList<DoubleInterval>();
        for(Double element : linkedList) {
            intervalList.add(new DoubleInterval(-element, element));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Double> doubleList = new LinkedList<Double>();
        for(Double element : linkedList) {
            doubleList.add(element * 2.0);
        }
        this.addLine("mapToDouble *2: " + doubleList);

        this.addLine("asDoubleList: " + doubleList.toString());
        LinkedList<Double> filteredList = new LinkedList<Double>();
        for(Double element : linkedList) {
            if (element > 0.0) {
                filteredList.add(element);
            }
        }
        this.addLine("filter PositivePredicate: " + filteredList.toString());

        linkedList.forEach(element -> {
                addLine(": " + element);
            });
    }

}
