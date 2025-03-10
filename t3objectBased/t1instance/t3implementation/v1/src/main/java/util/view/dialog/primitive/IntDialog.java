package util.view.dialog.primitive;

public class IntDialog {

    private String title;
    private String content;

    public IntDialog() {
        this.title = "";
    }

    public IntDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public int read() {
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

    private boolean isValid(String string) {
        return string.matches(regExp());
    }

    public String regExp() {
        return Console.INTEGER_regExp;
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public Integer create(String string) {
        assert string.matches(regExp());

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
        this.addLine("toString: " + element);
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(int integer) {
        this.addLine("sum 1: " + (integer + 1));
        this.addLine("substract 1: " + (integer - 1));
        this.addLine("multiply 2: " + (integer * 2));
        this.addLine("divide 2: " + (integer * 2));
        this.addLine("module 2: " + (integer % 2));
        this.addLine("greater 0: " + (integer > 0));
        this.addLine("equals or greater 0: " + (integer >= 0));
        this.addLine("equals 0: " + (integer == 0));
        this.addLine("lesser or equals 0: " + (integer <= 0));
        this.addLine("lesser 0: " + (integer < 0));
    }

    private void addLine(String line) {
        this.content += "\n" + line;
    }

}
