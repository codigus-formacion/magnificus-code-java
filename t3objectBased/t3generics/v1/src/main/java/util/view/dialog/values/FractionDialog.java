package util.view.dialog.values;

import util.collection.list.Iterator;
import util.collection.list.LinkedList;
import util.values.Fraction;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.primitive.IntDialog;

public class FractionDialog {

    private static final String SEPARATOR = "/";

    private Dialog<Fraction> delegated;

    public FractionDialog() {
        this.delegated = new Dialog<Fraction>("", FractionDialog.regExp());
    }

    public FractionDialog(String title) {
        this.delegated = new Dialog<Fraction>(title, FractionDialog.regExp());
    }

    public Fraction read() {
        String input;
        do {
            input = this.delegated.read();
        } while (!FractionDialog.isValid(input));
        return FractionDialog.create(input);
    }

    public static final String regExp() {
        return IntDialog.regExp() + SEPARATOR + IntDialog.regExp();
    }

    private static boolean isValid(String string) {
        assert string != null;

        if (!string.matches(regExp())) {
            return false;
        }
        return FractionDialog.values(string).get(1) != 0;
    }

    private static LinkedList<Integer> values(String string) {
        assert FractionDialog.isValid(string);
        
        LinkedList<Integer> intList = new LinkedList<Integer>();
        Iterator<String> iterator = FractionDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            intList.add(IntDialog.create(iterator.next()));
        }
        return intList;
    }

    private static LinkedList<String> strings(String string) {
        assert FractionDialog.isValid(string);
        
        LinkedList<String> strings = new LinkedList<String>();
        String[] elements = string.split(SEPARATOR);
        for (String element : elements) {
            strings.add(element);
        }
        return strings;
    }

    public static Fraction create(String string) {
        assert FractionDialog.isValid(string);

        String[] integers = string.split(SEPARATOR);
        return new Fraction(IntDialog.create(integers[0]), IntDialog.create(integers[1]));
    }

    public void write(Fraction fraction) {
        this.delegated.write(fraction);
    }

    public void writeln(Fraction fraction) {
        this.delegated.writeln(fraction);
    }

    public void writeDetails(Fraction element) {
        this.delegated.addHead(element);
        this.addContent(element);
        this.delegated.writeDetails();
    }

    public void addContent(Fraction fraction) {
        this.delegated.addLine("numerator: " + fraction.numerator());
        this.delegated.addLine("denominator: " + fraction.denominator());
        this.delegated.addLine("opposite: " + fraction.opposite());
        if (!fraction.equals(new Fraction(0))) {
            this.delegated.addLine("reverse: " + fraction.reverse());
        }
        Fraction pivot = new Fraction(1, 2);
        this.delegated.addLine("add 1/2: " + fraction.add(pivot));
        this.delegated.addLine("subtract 1/2: " + fraction.subtract(pivot));
        this.delegated.addLine("multiply 1/2: " + fraction.multiply(pivot));
        this.delegated.addLine("divide 1/2: " + fraction.divide(pivot));
        this.delegated.addLine("divide 1/2: " + fraction.divide(new Fraction(0)));
        this.delegated.addLine("power 2: " + fraction.power(2));
        this.delegated.addLine("value: " + fraction.valueOf());;
    }

}
