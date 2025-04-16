package util.view.dialog.collection.list;

import java.util.Iterator;
import java.util.LinkedList;

import util.values.Time;
import util.view.dialog.values.TimeDialog;

public class TimeLinkedListDialog extends LinkedListDialog<LinkedList<Time>> {

    public TimeLinkedListDialog(String title) {
        super(title, new TimeDialog().regExp());
    }
    
    public LinkedList<Time> create(String string) {
        LinkedList<Time> times = new LinkedList<Time>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next();
            times.add(new TimeDialog().create(elementString));
        }
        return times;
    }

    public void addContent(LinkedList<Time> linkedList) {
        Time sum = new Time(0,0,0);
        for (Time element : linkedList) {
            sum = sum.add(element);
        }
        this.addLine("sum: " + sum);
        LinkedList<Time> filteredList = new LinkedList<Time>();
        for(Time element : linkedList) {
            if (element.after(new Time(12,0,0))) {
                filteredList.add(element);
            }
        }
        this.addLine("filter PositivePredicate: " + filteredList.toString());
    }

}
