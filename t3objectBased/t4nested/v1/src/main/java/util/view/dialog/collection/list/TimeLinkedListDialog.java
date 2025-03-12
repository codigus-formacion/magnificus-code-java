package util.view.dialog.collection.list;

import util.collection.list.LinkedList;
import util.values.Time;
import util.view.dialog.values.TimeDialog;

public class TimeLinkedListDialog {
    
    private LinkedListDialog<LinkedList<Time>> delegated;

    public TimeLinkedListDialog(String title) {
        this.delegated = new LinkedListDialog<LinkedList<Time>>(title, TimeDialog.regExp());
    }

    public LinkedList<Time> read() {
        String input;
        do {
            input = this.delegated.read();
        } while (!this.delegated.isValid(input));
        return TimeLinkedListDialog.create(input);
    }

    public static LinkedList<Time> create(String string) {
        LinkedList<Time> intList = new LinkedList<Time>();
        LinkedList<Time>.Iterator<Time> iterator = TimeLinkedListDialog.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next());
        }
        return intList;
    }
    
    private static LinkedList<Time> values(String string) {
        LinkedList<Time> integers = new LinkedList<Time>();
        LinkedList<String>.Iterator<String> iterator = LinkedListDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next();
            integers.add(TimeDialog.create(elementString));
        }
        return integers;
    }

    public void write(LinkedList<Time> linkedList) {
        this.delegated.write(linkedList);
    }

    public void writeln(LinkedList<Time> linkedList) {
        this.delegated.writeln(linkedList);
    }

    public void writeDetails(LinkedList<Time> linkedList) {
        this.delegated.addHead(linkedList);
        this.addContent(linkedList);
        this.delegated.writeDetails();
    }

    public void addContent(LinkedList<Time> linkedList) {
        Time sum = new Time(0,0,0);
        LinkedList<Time>.Iterator<Time> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sum = sum.plus(iterator.next());
        }
        this.delegated.addLine("sum: " + sum);
    }

}
