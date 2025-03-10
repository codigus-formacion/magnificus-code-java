package util.view.dialog.primitive;

public class DoubleDialog {

    private String title;
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
        return Console.DOUBLE_regExp;
    }

    private boolean isValid(String string) {
        return string.matches(regExp());
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public Double create(String string) {
        assert string.matches(regExp());

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
        this.addLine("toString: " + element);
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(double decimal) {
        this.addLine("sum 1: " + (decimal + 1));
        this.addLine("substract 1: " + (decimal - 1));
        this.addLine("multiply 2: " + (decimal * 2));
        this.addLine("divide 2: " + (decimal * 2));
        this.addLine("module 2: " + (decimal % 2));
        this.addLine("greater 0: " + (decimal > 0));
        this.addLine("equals or greater 0: " + (decimal >= 0));
        this.addLine("equals 0: " + (decimal == 0));
        this.addLine("lesser or equals 0: " + (decimal <= 0));
        this.addLine("lesser 0: " + (decimal < 0));
    }

    private void addLine(String line) {
        this.content += "\n" + line;
    }

}