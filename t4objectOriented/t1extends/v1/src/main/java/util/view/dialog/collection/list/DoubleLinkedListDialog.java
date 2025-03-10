package util.view.dialog.collection.list;

import util.view.dialog.primitive.DoubleDialog;
import util.values.DoubleInterval;
import util.collection.list.LinkedList;

public class DoubleLinkedListDialog extends LinkedListDialog<Double> {

    public DoubleLinkedListDialog(String title) {
        super(title);
    }

    protected String regExp() {
        return this.regExp(new DoubleDialog().regExp());
    }

    protected Double createElement(String elementString) {
        return new DoubleDialog().create(elementString);
    }

    public void addContent(LinkedList<Double> doubleLinkedList) {
        assert doubleLinkedList != null : "Element cannot be null";

        this.addLine("toString: " + doubleLinkedList.toString());
        int sum = 0;
        LinkedList<Double>.Iterator<Double> iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.addLine("sum: " + sum);

        LinkedList<Double> mappedList = new LinkedList<Double>();
        iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        LinkedList<DoubleInterval> intervalList = new LinkedList<DoubleInterval>();
        iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            Double integer = iterator.next().element();
            intervalList.add(new DoubleInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Double> doubleList = new LinkedList<Double>();
        iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            doubleList.add(iterator.next().element() * 2.0);
        }
        this.addLine("mapToDouble *2: " + doubleList);

        this.addLine("asDoubleList: " + doubleList.toString());
    }

}
