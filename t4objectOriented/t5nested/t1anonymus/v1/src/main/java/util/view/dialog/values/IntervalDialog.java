package util.view.dialog.values;

import util.collection.list.LinkedList;
import util.values.Interval;
import util.view.dialog.primitive.SecuenceDialog;

public abstract class IntervalDialog<T extends Comparable<T>> extends SecuenceDialog<Interval<T>> {

    protected IntervalDialog(String title, String regExp) {
        super(title, "\\[", regExp, ",", "\\]");
    }

    protected boolean isSemanticValid(String string){
        LinkedList<T> values = this.values(string);
        return values.size() != 2;
    }

    protected abstract LinkedList<T> values(String string);

    protected IntervalDialog(String regExp) {
        this("", regExp);
    }

}
