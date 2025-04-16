package util.view.dialog.collection.list;

import util.view.dialog.primitive.IntDialog;
import util.values.Math;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

import util.values.IntegerInterval;

public class IntegerLinkedListDialog extends LinkedListDialog<LinkedList<Integer>> {

    public IntegerLinkedListDialog(String title) {
        super(title, new IntDialog().regExp());
    }

    public LinkedList<Integer> create(String string) {
        LinkedList<Integer> integers = new LinkedList<Integer>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next();
            integers.add(new IntDialog().create(elementString));
        }
        return integers;
    }

    public void addContent(LinkedList<Integer> linkedList) {
        int sum = 0;
        for (Integer element : linkedList) {
            sum += element;
        }
        this.addLine("sum: " + sum);

        AccConsumer accConsumer = new AccConsumer();
        linkedList.forEach(accConsumer);
        this.addLine("sum: " + accConsumer.getSum());

        LinkedList<Integer> mappedList = new LinkedList<Integer>();
        for (Integer element : linkedList) {
            mappedList.add(element + 1);
        }
        this.addLine("map + 1: " + mappedList);

        LinkedList<IntegerInterval> intervalList = new LinkedList<IntegerInterval>();
        for (Integer element : linkedList) {
            intervalList.add(new IntegerInterval(-element, element));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Integer> doubleList = new LinkedList<Integer>();
        for (Integer element : linkedList) {
            doubleList.add(element * 2);
        } 
        this.addLine("mapToDouble *2: " + doubleList);

        this.addLine("asDoubleList: " + doubleList.toString());
        LinkedList<Integer> filteredList = new LinkedList<Integer>();
        for (Integer element : linkedList) {
            if (Math.isPrime(element)) {
                filteredList.add(element);
            }
        }
        this.addLine("filter PositivePredicate: " + filteredList.toString());

    }

    class AccConsumer implements Consumer<Integer> {
        private int sum = 0;

        public void accept(Integer element) {
            this.sum += element;
        }

        public int getSum() {
            return this.sum;
        }
    }

}
