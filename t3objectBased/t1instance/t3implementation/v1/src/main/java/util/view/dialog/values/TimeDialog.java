package util.view.dialog.values;

import util.values.Time;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.IntDialog;

public class TimeDialog {

    private String SEPARATOR = ":";

    private String title;
    private String content;

    public TimeDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public Time read() {
        String input;
        boolean valid;
        do {
            Console.instance().write(this.title + " (" + regExp() + "): ");
            input = Console.instance().readString();
            valid = this.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return this.create(input);
    }

    public String regExp() {
        IntDialog intDialog = new IntDialog();
        return intDialog.regExp() + SEPARATOR + intDialog.regExp() + SEPARATOR + intDialog.regExp();
    }

    private boolean isValid(String string) {
        assert string != null;

        if (!string.matches(regExp())) {
            return false;
        }
        Integer[] integers = this.values(string);
        return new Time(0, 0, 0).isValidHour(integers[0])
                && new Time(0, 0, 0).isValidMinute(integers[1])
                && new Time(0, 0, 0).isValidSeconds(integers[2]);
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

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public Time create(String string) {
        assert this.isValid(string);

        Integer[] integers = values(string);
        return new Time(integers[0], integers[1], integers[2]);
    }

    public void write(Time time) {
        assert time != null;

        Console.instance().write(time);
    }

    public void writeln(Time time) {
        this.write(time);
        Console.instance().writeln();
    }

    public void writeDetails(Time time) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(time);
        Console.instance().writeln(this.content);
    }

    public void addContent(Time time) {
        this.addLine("toString: " + time);
        this.addLine("next: " + time.next());
        Time pivot = new Time(12, 30, 0);
        this.addLine("before " + pivot + ": " + time.before(pivot));
        this.addLine("equals " + pivot + ": " + time.equals(pivot));
        this.addLine("after " + pivot + ": " + time.after(pivot));
    }

    private void addLine(String line) {
        this.content += "\n" + line;
    }

}
