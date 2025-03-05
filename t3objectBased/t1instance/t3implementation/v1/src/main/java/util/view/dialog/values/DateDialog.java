package util.view.dialog.values;

import util.values.time.Date;
import util.view.Console;
import util.view.dialog.primitive.IntDialog;

public class DateDialog {

    private static String SEPARATOR = "/";

    public static String REGEXP() {
        return IntDialog.REGEXP() + SEPARATOR + IntDialog.REGEXP() + SEPARATOR + IntDialog.REGEXP();
    }

    protected String title;
    protected Date element;
    private String content;

    protected DateDialog() {
        this.title = "";
    }

    public DateDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public Date read() {
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
        if (!string.matches(REGEXP())) {
            return false;
        }
        Integer[] integers = this.values(string);
        return Date.isValidMonth(integers[1])
            && Date.isValidDay(integers[2]);
    }

    protected String errorMsg() {
        return "Al no respetar el formato \"" + REGEXP() + "\"";
    }

    public Date of(String string) {
        Integer[] integers = values(string);
        return new Date(integers[0], integers[1], integers[2]);
    }

    private Integer[] values(String string) {
        String[] strings = string.split(SEPARATOR);
        Integer[] integers = new Integer[strings.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = new IntDialog().of(strings[i]);
        }
        return integers;
    }

    public void write(Date element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(Date element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(Date element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(Date date) {
        this.addLine("toString: " + date);
        this.addLine("next: " + date.next());
        Date pivot = new Date(2025,6,6);
        this.addLine("before: " + date.before(pivot));
        this.addLine("equals: " + date.equals(pivot));
        this.addLine("after: " + date.after(pivot));
    }

    protected void addLine(String line) {
        this.content += "\n" + line;
    }

}
