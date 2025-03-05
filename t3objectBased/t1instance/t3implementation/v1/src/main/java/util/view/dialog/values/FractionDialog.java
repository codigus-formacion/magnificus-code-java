package util.view.dialog.values;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import util.values.fraction.Fraction;
import util.view.Console;
import util.view.dialog.primitive.IntDialog;

public class FractionDialog {

    private static final String SEPARATOR = "/";

    public static final String REGEXP() {
        return IntDialog.REGEXP() + SEPARATOR + IntDialog.REGEXP();
    }

    protected String title;
    protected Fraction element;
    private String content;

    protected FractionDialog() {
        this.title = "";
    }

    public FractionDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public Fraction read() {
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

    protected String errorMsg() {
        return "Al no respetar el formato \"" + REGEXP() + "\"" + " o un denominador nulo";
    }

    protected boolean isValid(String string) {
        if (!string.matches(REGEXP())) {
            return false;
        }
        return this.values(string).get(1) != 0;
    }

    public void write(Fraction element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(Fraction element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(Fraction element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    protected void addLine(String line) {
        this.content += "\n" + line;
    }

    private List<Double> values(String string) {
        return Arrays.stream(string.split(SEPARATOR))
                .map(doubleString -> Double.parseDouble(doubleString))
                .collect(Collectors.toList());
    }

    public Fraction of(String string) {
        assert this.isValid(string);

        String[] integers = string.split(SEPARATOR);
        IntDialog intDialog = new IntDialog();
        return new Fraction(intDialog.of(integers[0]), intDialog.of(integers[1]));
    }

    public void addContent(Fraction fraction) {
        this.addLine("toString: " + fraction.toString());
        this.addLine("numerator: " + fraction.numerator());
        this.addLine("denominator: " + fraction.denominator());
        this.addLine("opposite: " + fraction.opposite());
        if (!fraction.equals(new Fraction(0))) {
            this.addLine("reverse: " + fraction.reverse());
        }
        Fraction pivot = new Fraction(1, 2);
        this.addLine("add 1/2: " + fraction.add(pivot));
        this.addLine("subtract 1/2: " + fraction.subtract(pivot));
        this.addLine("multiply 1/2: " + fraction.multiply(pivot));
        this.addLine("divide 1/2: " + fraction.divide(pivot));
        this.addLine("power 2: " + fraction.power(2));
        this.addLine("value: " + fraction.valueOf());
        this.addLine("hashCode: " + fraction.hashCode());
        this.addLine("clone: " + fraction.clone());
    }

}
