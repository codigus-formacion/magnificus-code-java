package util.view.dialog.collection.list;

import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.functional.Predicate;
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
        Iterator<Time> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            sum = sum.add(iterator.next());
        }
        this.addLine("sum: " + sum);
        this.addLine("filter PositivePredicate: " 
            + linkedList.filter(Time::isPM)
            .toString());
    }

}
