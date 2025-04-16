package util.view.dialog.values;

import java.util.LinkedList;
import java.util.stream.Collectors;

import util.values.Fraction;
import util.view.dialog.primitive.IntDialog;
import util.view.dialog.primitive.SecuenceDialog;

public class FractionDialog extends SecuenceDialog<Fraction> {

    private static final String SEPARATOR = "/";

    public FractionDialog(String title) {
        super(title, "", new IntDialog().regExp(), SEPARATOR, "");
    }

    public FractionDialog() {
        this("");
    }

    public boolean isSemanticValid(String string) {
        LinkedList<Integer> values = this.values(string);
        return values.size() == 2 && values.get(1) != 0;
    }

    private LinkedList<Integer> values(String string) {
        return this.strings(string).stream()
                .map(s -> new IntDialog().create(s))
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public Fraction create(String string) {
        LinkedList<Integer> values = this.values(string);
        return new Fraction(values.get(0), values.get(1));
    }

    public void addContent(Fraction fraction) {
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
        this.addLine("divide 1/2: " + fraction.divide(new Fraction(0)));
        this.addLine("power 2: " + fraction.power(2));
        this.addLine("value: " + fraction.valueOf());;
    }

}
