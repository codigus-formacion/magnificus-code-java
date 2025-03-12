package util.view.dialog.collection.list;

import util.view.dialog.primitive.DoubleDialog;
import util.values.DoubleInterval;
import util.collection.list.LinkedList;

public class DoubleLinkedListDialog {

    private LinkedListDialog<LinkedList<Double>> delegated;

    public DoubleLinkedListDialog(String title) {
        this.delegated = new LinkedListDialog<LinkedList<Double>>(title, DoubleDialog.regExp());
    }

    public LinkedList<Double> read() {
        String input;
        do {
            input = this.delegated.read();
        } while (!this.delegated.isValid(input));
        return DoubleLinkedListDialog.create(input);
    }

    public static LinkedList<Double> create(String string) {
        LinkedList<Double> intList = new LinkedList<Double>();
        LinkedList<Double>.Iterator<Double> iterator = DoubleLinkedListDialog.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next());
        }
        return intList;
    }
    
    private static LinkedList<Double> values(String string) {
        LinkedList<Double> integers = new LinkedList<Double>();
        LinkedList<String>.Iterator<String> iterator = LinkedListDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next();
            integers.add(DoubleDialog.create(elementString));
        }
        return integers;
    }

    public void write(LinkedList<Double> linkedList) {
        this.delegated.write(linkedList);
    }

    public void writeln(LinkedList<Double> linkedList) {
        this.delegated.writeln(linkedList);
    }

    public void writeDetails(LinkedList<Double> linkedList) {
        this.delegated.addHead(linkedList);
        this.addContent(linkedList);
        this.delegated.writeDetails();
    }

    public void addContent(LinkedList<Double> linkedList) {
        double sum = 0;
        LinkedList<Double>.Iterator<Double> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next();
        }
        this.delegated.addLine("sum: " + sum);

        LinkedList<Double> mappedList = new LinkedList<Double>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next() + 1);
        }
        this.delegated.addLine("map + 1: " + mappedList);

        LinkedList<DoubleInterval> intervalList = new LinkedList<DoubleInterval>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            Double integer = iterator.next();
            intervalList.add(new DoubleInterval(-integer, integer));
        }
        this.delegated.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Double> doubleList = new LinkedList<Double>();
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            doubleList.add(iterator.next() * 2.0);
        }
        this.delegated.addLine("mapToDouble *2: " + doubleList);

        this.delegated.addLine("asDoubleList: " + doubleList.toString());
    }

}
