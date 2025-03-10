package util.view.dialog.values;

import util.values.Date;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.primitive.IntDialog;

public class DateDialog extends Dialog<Date> {

    private static String SEPARATOR = "/";

    public DateDialog(String title) {
        super(title);
    }

    public String regExp() {
        String regExp = new IntDialog().regExp();
        return regExp + SEPARATOR + regExp + SEPARATOR + regExp;
    }

    protected boolean isSemanticValid(String string) {
        Integer[] integers = this.values(string);
        return Date.isValidMonth(integers[1])
            && Date.isValidDay(integers[2]);
    }

    private Integer[] values(String string) {
        assert this.isValid(string);

        String[] strings = string.split(SEPARATOR);
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new IntDialog().create(strings[i]);
        }
        return integers;
    }

    public Date create(String string) {
        Integer[] integers = this.values(string);
        return new Date(integers[0], integers[1], integers[2]);
    }

    public void addContent(Date date) {
        this.addLine("next: " + date.next());
        Date pivot = new Date(2025,6,6);
        this.addLine("before: " + date.before(pivot));
        this.addLine("equals: " + date.equals(pivot));
        this.addLine("after: " + date.after(pivot));
    }

}
