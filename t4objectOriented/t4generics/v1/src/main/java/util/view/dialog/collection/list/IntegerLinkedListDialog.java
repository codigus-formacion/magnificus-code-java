package util.view.dialog.collection.list;

import util.view.dialog.primitive.IntDialog;
import util.collection.Iterator;
import util.collection.list.LinkedList;
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
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        this.addLine("sum: " + sum);

        LinkedList<Integer> mappedList = new LinkedList<Integer>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        LinkedList<IntegerInterval> intervalList = new LinkedList<IntegerInterval>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            intervalList.add(new IntegerInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Integer> doubleList = new LinkedList<Integer>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            doubleList.add(iterator.next() * 2);
        }
        this.addLine("mapToDouble *2: " + doubleList);

        this.addLine("asDoubleList: " + doubleList.toString());
    }

}
