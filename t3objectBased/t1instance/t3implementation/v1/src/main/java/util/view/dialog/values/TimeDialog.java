package util.view.dialog.values;

import util.values.time.Time;
import util.view.Console;
import util.view.dialog.primitive.IntDialog;

public class TimeDialog {

    private static String SEPARATOR = ":";

    public static String REGEXP() {
        return IntDialog.REGEXP() + SEPARATOR + IntDialog.REGEXP() + SEPARATOR + IntDialog.REGEXP();
    }

    protected String title;
    protected Time element;
    private String content;

    protected TimeDialog() {
        this.title = "";
    }

    public TimeDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public Time read() {
        String input;
        boolean valid;
        do {
            Console.instance().write(this.title + " (" + REGEXP() + "): ");
            input = Console.instance().readString();
            valid = this.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return this.of(input);
    }

   protected boolean isValid(String string) {
        if (string.matches(REGEXP())){
            return false;
        }
        Integer[] integers = this.values(string);
        return Time.isValidHour(integers[0])
            && Time.isValidMinute(integers[1])
            && Time.isValidSeconds(integers[2]);
    }

    protected String errorMsg() {
        return "Al no respetar el formato \"" + REGEXP() + "\"";
    }

    public Time of(String string) {
        assert this.isValid(string);

        Integer[] integers = values(string);
        return new Time(integers[0], integers[1], integers[2]);
    }

    public void write(int element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(int element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(Time element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(Integer integer) {
        this.addLine("toString: " + integer.toString());
    }

    protected void addLine(String line) {
        this.content += "\n" + line;
    }

    private Integer[] values(String string) {
        String[] strings = string.split(SEPARATOR);
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new IntDialog().of(strings[i]);
        }
        return integers;
    }

    public void addContent(Time time) {
        this.addLine("toString: " + time);
        this.addLine("next: " + time.next());
        Time pivot = new Time(12,30,0);
        this.addLine("before " + pivot + ": " + time.before(pivot));
        this.addLine("equals " + pivot + ": " + time.equals(pivot));
        this.addLine("after " + pivot + ": " + time.after(pivot));
    }

}
