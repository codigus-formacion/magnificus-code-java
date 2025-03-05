package util.view.dialog.primitive;

import util.view.Console;

public class IntDialog {

    public static String REGEXP() {
        return Console.INTEGER_REGEXP;
    }

    protected String title;
    protected int element;
    private String content;

    public IntDialog() {
        this.title = "";
    }

    protected IntDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public int read() {
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

    public Integer of(String string) {
        assert string.matches(REGEXP());

        return Integer.parseInt(string);
    }

    public void write(int element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(int element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(int element) {
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

}
