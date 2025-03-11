package util.view.dialog.collection.list;

import util.view.dialog.primitive.IntDialog;
import util.collection.list.LinkedList;
import util.values.IntegerInterval;

public class IntegerLinkedListDialog {

    private LinkedListDialog<LinkedList<Integer>> delegated;

    public IntegerLinkedListDialog(String title) {
        this.delegated = new LinkedListDialog<LinkedList<Integer>>(title, IntDialog.regExp());
    }

    public LinkedList<Integer> read() {
        String input;
        do {
            input = this.delegated.read();
        } while (!this.delegated.isValid(input));
        return IntegerLinkedListDialog.create(input);
    }

    public static LinkedList<Integer> create(String string) {
        LinkedList<Integer> intList = new LinkedList<Integer>();
        LinkedList<Integer>.Iterator<Integer> iterator = IntegerLinkedListDialog.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next().element());
        }
        return intList;
    }
    
    private static LinkedList<Integer> values(String string) {
        LinkedList<Integer> integers = new LinkedList<Integer>();
        LinkedList<String>.Iterator<String> iterator = LinkedListDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next().element();
            integers.add(IntDialog.create(elementString));
        }
        return integers;
    }

    public void write(LinkedList<Integer> linkedList) {
        this.delegated.write(linkedList);
    }

    public void writeln(LinkedList<Integer> linkedList) {
        this.delegated.writeln(linkedList);
    }

    public void writeDetails(LinkedList<Integer> linkedList) {
        this.delegated.addHead(linkedList);
        this.addContent(linkedList);
        this.delegated.writeDetails();
    }

    public void addContent(LinkedList<Integer> linkedList) {
        int sum = 0;
        LinkedList<Integer>.Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.delegated.addLine("sum: " + sum);

        LinkedList<Integer> mappedList = new LinkedList<Integer>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.delegated.addLine("map + 1: " + mappedList);

        LinkedList<IntegerInterval> intervalList = new LinkedList<IntegerInterval>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next().element();
            intervalList.add(new IntegerInterval(-integer, integer));
        }
        this.delegated.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Integer> doubleList = new LinkedList<Integer>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            doubleList.add(iterator.next().element() * 2);
        }
        this.delegated.addLine("mapToDouble *2: " + doubleList);

        this.delegated.addLine("asDoubleList: " + doubleList.toString());
    }

}
