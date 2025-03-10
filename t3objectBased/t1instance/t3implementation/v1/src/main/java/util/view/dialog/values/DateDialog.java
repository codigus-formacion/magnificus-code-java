package util.view.dialog.values;

import util.values.Date;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.IntDialog;

public class DateDialog {

    private String SEPARATOR = "/";

    private String title;
    private String content;

    public DateDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public Date read() {
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
        return new Date(0,1,1).isValidMonth(integers[1])
            && new Date(0,1,1).isValidDay(integers[2]);
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

    public Date create(String string) {
        assert this.isValid(string);

        Integer[] integers = values(string);
        return new Date(integers[0], integers[1], integers[2]);
    }

    public void write(Date date) {
        assert date != null;

        Console.instance().write(date);
    }

    public void writeln(Date date) {
        this.write(date);
        Console.instance().writeln();
    }

    public void writeDetails(Date date) {
        this.content = "===============";
        this.addContent(date);
        Console.instance().writeln(this.content);
    }

    public void addContent(Date date) {
        assert date != null;

        this.addLine("toString: " + date);
        this.addLine("next: " + date.next());
        Date pivot = new Date(2025,6,6);
        this.addLine("before: " + date.before(pivot));
        this.addLine("equals: " + date.equals(pivot));
        this.addLine("after: " + date.after(pivot));
    }

    private void addLine(String line) {
        assert line != null;

        this.content += "\n" + line;
    }

}
