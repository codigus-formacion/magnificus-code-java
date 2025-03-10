package util.view.dialog.collection.list;

import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

import util.collection.list.LinkedList;
import util.values.IntegerInterval;

public class IntegerLinkedListDialog extends LinkedListDialog<Integer> {

    public IntegerLinkedListDialog(String title) {
        super(title);
    }

    protected String regExp() {
        return this.regExp(new DoubleDialog().regExp());
    }

    protected Integer createElement(String elementString) {
        return new IntDialog().create(elementString);
    }

    public void addContent(LinkedList<Integer> integerLinkedList) {
        assert integerLinkedList != null : "Element cannot be null";

        this.addLine("toString: " + integerLinkedList.toString());        
        int sum = 0;
        LinkedList<Integer>.Iterator<Integer> iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.addLine("sum: " + sum);

        LinkedList<Integer> mappedList = new LinkedList<Integer>();
        iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        LinkedList<IntegerInterval> intervalList = new LinkedList<IntegerInterval>();
        iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next().element();
            intervalList.add(new IntegerInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Double> doubleList = new LinkedList<Double>();
        iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            doubleList.add(iterator.next().element() * 2.0);
        }
        this.addLine("mapToDouble *2: " + doubleList);

        this.addLine("asDoubleList: " + doubleList.toString());
    }  


}
