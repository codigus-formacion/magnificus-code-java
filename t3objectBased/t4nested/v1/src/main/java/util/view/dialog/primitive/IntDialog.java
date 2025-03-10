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
            valid = IntDialog.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return IntDialog.create(input);
    }

    private static boolean isValid(String string) {
        return string.matches(regExp());
    }

    public static String regExp() {
        return Console.INTEGER_regExp;
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public static Integer create(String string) {
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
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(Integer integer) {
        this.addLine("toString: " + integer.toString());
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
