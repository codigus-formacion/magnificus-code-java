package util.view.dialog.values;

import util.values.Time;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.primitive.IntDialog;

public class TimeDialog {

    private static String SEPARATOR = ":";

    private Dialog<Time> delegated;

    public TimeDialog(String title) {
        this.delegated = new Dialog<Time>(title, TimeDialog.regExp());
    }

    public Time read() {
        String input;
        do {
            input = this.delegated.read();
        } while (!TimeDialog.isValid(input));
        return TimeDialog.create(input);
    }

    public static String regExp() {
        return IntDialog.regExp() + SEPARATOR + IntDialog.regExp() + SEPARATOR + IntDialog.regExp();
    }

    private static boolean isValid(String string) {
        assert string != null;

        if (!string.matches(regExp())) {
            return false;
        }
        Integer[] integers = TimeDialog.values(string);
        return Time.isValidHour(integers[0])
                && Time.isValidMinute(integers[1])
                && Time.isValidSeconds(integers[2]);
    }

    private static Integer[] values(String string) {
        assert TimeDialog.isValid(string);

        String[] strings = string.split(SEPARATOR);
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = IntDialog.create(strings[i]);
        }
        return integers;
    }

    public static Time create(String string) {
        assert TimeDialog.isValid(string);

        Integer[] values = values(string);
        return new Time(values[0], values[1], values[2]);
    }

    public void write(Time time) {
        this.delegated.write(time);
    }

    public void writeln(Time time) {
        this.delegated.writeln(time);
    }

    public void writeDetails(Time element) {
        this.delegated.addHead(element);
        this.addContent(element);
        this.delegated.writeDetails();
    }

    public void addContent(Time time) {
        this.delegated.addLine("next: " + time.next());
        Time pivot = new Time(12, 30, 0);
        this.delegated.addLine("before " + pivot + ": " + time.before(pivot));
        this.delegated.addLine("equals " + pivot + ": " + time.equals(pivot));
        this.delegated.addLine("after " + pivot + ": " + time.after(pivot));
    }

}
