package util.view.dialog.values;

import util.collection.list.IntegerLinkedList;
import util.collection.list.StringLinkedList;
import util.collection.list.iterator.StringIterator;
import util.values.Fraction;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.IntDialog;

public class FractionDialog {

    private final String SEPARATOR = "/";

    private String title;
    private String content;

    public FractionDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public FractionDialog() {
        this("");
    }

    public Fraction read() {
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

    public final String regExp() {
        IntDialog intDialog = new IntDialog();
        return intDialog.regExp() + SEPARATOR + intDialog.regExp();
    }

    private boolean isValid(String string) {
        assert string != null;

        if (!string.matches(regExp())) {
            return false;
        }
        return this.values(string).get(1) != 0;
    }

    private IntegerLinkedList values(String string) {
        assert this.isValid(string);
        
        IntegerLinkedList intList = new IntegerLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            intList.add(new IntDialog().create(iterator.next().element()));
        }
        return intList;
    }

    private StringLinkedList strings(String string) {
        assert this.isValid(string);
        
        StringLinkedList strings = new StringLinkedList();
        String[] elements = string.split(SEPARATOR);
        for (String element : elements) {
            strings.add(element);
        }
        return strings;
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"" + " o un denominador nulo";
    }

    public Fraction create(String string) {
        assert this.isValid(string);

        String[] integers = string.split(SEPARATOR);
        IntDialog intDialog = new IntDialog();
        return new Fraction(intDialog.create(integers[0]), intDialog.create(integers[1]));
    }

    public void write(Fraction fraction) {
        assert fraction != null;

        Console.instance().write(fraction);
    }

    public void writeln(Fraction fraction) {
        this.write(fraction);
        Console.instance().writeln();
    }

    public void writeDetails(Fraction fraction) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(fraction);
        Console.instance().writeln(this.content);
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

    private void addLine(String line) {
        this.content += "\n" + line;
    }

}
