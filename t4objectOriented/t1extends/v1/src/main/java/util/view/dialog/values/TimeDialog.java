package util.view.dialog.values;

import util.values.Time;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.primitive.IntDialog;

public class TimeDialog extends Dialog<Time> {

    private static String SEPARATOR = ":";

    public TimeDialog(){
        super();
    }

    public TimeDialog(String title) {
        super(title);
    }

    public String regExp() {
        IntDialog intDialog = new IntDialog();
        return intDialog.regExp() + SEPARATOR + intDialog.regExp() + SEPARATOR + intDialog.regExp();
    }

    protected boolean isValid(String string) {
        assert string != null;

        if (!string.matches(regExp())) {
            return false;
        }
        Integer[] integers = this.values(string);
        return Time.isValidHour(integers[0])
                && Time.isValidMinute(integers[1])
                && Time.isValidSeconds(integers[2]);
    }

    private Integer[] values(String string) {
        assert new TimeDialog().isValid(string);

        String[] strings = string.split(SEPARATOR);
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new IntDialog().create(strings[i]);
        }
        return integers;
    }

    public Time create(String string) {
        assert this.isValid(string);

        Integer[] values = values(string);
        return new Time(values[0], values[1], values[2]);
    }

    public void addContent(Time time) {
        this.addLine("toString: " + time);
        this.addLine("next: " + time.next());
        Time pivot = new Time(12, 30, 0);
        this.addLine("before " + pivot + ": " + time.before(pivot));
        this.addLine("equals " + pivot + ": " + time.equals(pivot));
        this.addLine("after " + pivot + ": " + time.after(pivot));
    }

}
