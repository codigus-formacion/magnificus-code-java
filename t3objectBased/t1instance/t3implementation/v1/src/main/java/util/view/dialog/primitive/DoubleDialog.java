package util.view.dialog.primitive;

import util.view.Console;

public class DoubleDialog {

    public static String REGEXP() {
        return Console.DOUBLE_REGEXP;
    }

    protected String title;
    protected double element;
    private String content;

    public DoubleDialog() {
        this.title = "";
    }

    public DoubleDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public double read() {
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
        return string.matches(REGEXP());
    }

    protected String errorMsg() {
        return "Al no respetar el formato \"" + REGEXP() + "\"";
    }

    public Double of(String string) {
        assert string.matches(REGEXP());

        return Double.parseDouble(string);
    }

    public void write(double element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(double element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(double element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(Double decimal) {
        this.addLine("toString: " + decimal.toString());
    }


    protected void addLine(String line) {
        this.content += "\n" + line;
    }

}