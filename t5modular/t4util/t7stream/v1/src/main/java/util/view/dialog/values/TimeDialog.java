package util.view.dialog.values;

import java.util.LinkedList;
import java.util.stream.Collectors;

import util.values.Time;
import util.view.dialog.primitive.IntDialog;
import util.view.dialog.primitive.SecuenceDialog;

public class TimeDialog extends SecuenceDialog<Time> {

    private static String SEPARATOR = ":";

    public TimeDialog(String title) {
        super(title, "", new IntDialog().regExp(), SEPARATOR, "");
    }

    public TimeDialog() {
        this("");
    }

    public boolean isSemanticValid(String string) {
        LinkedList<Integer> values = this.values(string);
        return Time.isValidHour(values.get(0))
                && Time.isValidMinute(values.get(1))
                && Time.isValidSeconds(values.get(2))
                && values.size() == 3;
    }

    public String errorSemanticMsg() {
        return " no hay 3 valores o la hora, minuto o segundo están fuera de rango [0-23] y [0-59] respectivamente";
    }

    public Time create(String string) {
        LinkedList<Integer> values = this.values(string);
        return new Time(values.get(0), values.get(1), values.get(2));
    }

    private LinkedList<Integer> values(String string) {
        return this.strings(string).stream()
                .map(s -> new IntDialog().create(s))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public void addContent(Time time) {
        this.addLine("next: " + time.next());
        Time pivot = new Time(12, 30, 0);
        this.addLine("before " + pivot + ": " + time.before(pivot));
        this.addLine("equals " + pivot + ": " + time.equals(pivot));
        this.addLine("after " + pivot + ": " + time.after(pivot));
    }

}
