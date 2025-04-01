package util.view.dialog.values;

import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.Date;
import util.view.dialog.primitive.IntDialog;
import util.view.dialog.primitive.SecuenceDialog;

public class DateDialog extends SecuenceDialog<Date> {

    private static String SEPARATOR = "/";
  
    public DateDialog(String title) {
        super(title, "", new IntDialog().regExp(),  SEPARATOR, "");
    }

    public DateDialog() {
        this("");
    }

    public boolean isSemanticValid(String string) {
        LinkedList<Integer> values = this.values(string);
        return Date.isValidMonth(values.get(1))
            && Date.isValidDay(values.get(2))
            && values.size() == 3;
    }

    private LinkedList<Integer> values(String string) {        
        LinkedList<Integer> intList = new LinkedList<Integer>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            intList.add(new IntDialog().create(iterator.next()));
        }
        return intList;
    }

    public String errorSemanticMsg() {
        return " el día y/o el mes están fuera de rango [1-30] y [1-12] respectivamente";
    }

    public Date create(String string) {
        LinkedList<Integer> values = this.values(string);
        return new Date(values.get(0), values.get(1), values.get(2));
    }

    public void addContent(Date date) {
        this.addLine("next: " + date.next());
        Date pivot = new Date(2025,6,6);
        this.addLine("before: " + date.before(pivot));
        this.addLine("equals: " + date.equals(pivot));
        this.addLine("after: " + date.after(pivot));
    }

}
