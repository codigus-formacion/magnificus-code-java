package util.view.dialog.values;

import util.collection.list.LinkedList;
import util.values.Fraction;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.primitive.IntDialog;

public class FractionDialog extends Dialog<Fraction> {

    private static final String SEPARATOR = "/";

    public FractionDialog() {
        super();
    }

    public FractionDialog(String title) {
        super(title);
    }

    public final String regExp() {
        IntDialog intDialog = new IntDialog();
        return intDialog.regExp() + SEPARATOR + intDialog.regExp();
    }

    protected boolean isSemanticValid(String string) {
        return new FractionDialog().values(string).get(1) != 0;
    }

    private LinkedList<Integer> values(String string) {
        assert new FractionDialog().isValid(string);
        
        LinkedList<Integer> intList = new LinkedList<Integer>();
        LinkedList<String>.Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            intList.add(new IntDialog().create(iterator.next().element()));
        }
        return intList;
    }

    private LinkedList<String> strings(String string) {
        assert this.isValid(string);
        
        LinkedList<String> strings = new LinkedList<String>();
        String[] elements = string.split(SEPARATOR);
        for (String element : elements) {
            strings.add(element);
        }
        return strings;
    }

    public Fraction create(String string) {
        assert this.isValid(string);

        String[] integers = string.split(SEPARATOR);
        IntDialog intDialog = new IntDialog();
        return new Fraction(intDialog.create(integers[0]), intDialog.create(integers[1]));
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
        this.addLine("power 2: " + fraction.power(2));
        this.addLine("value: " + fraction.valueOf());
    }

}
