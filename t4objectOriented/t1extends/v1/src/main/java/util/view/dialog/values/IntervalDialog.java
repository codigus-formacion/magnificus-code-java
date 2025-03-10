package util.view.dialog.values;

import util.collection.list.Iterator;
import util.collection.list.LinkedList;
import util.values.Fraction;
import util.values.FractionInterval;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.Dialog;

public class IntervalDialog<T> extends Dialog<T> {

    private static final String PREFIX = "\\[";
    private static final String SEPARATOR = ",";
    private static final String POSTFIX = "\\]";

    public IntervalDialog(String title) {
        super(title);
    }

    protected String regExp(String regExp){
        return PREFIX + regExp + SEPARATOR + regExp + POSTFIX;
    }

    private boolean isValid(String string) {
        assert string != null;

        if (!super.isValid(string)) {
            return false;
        }
        LinkedList<T> values = this.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    private LinkedList<T> values(String string) {
        assert this.isValid(string);

        LinkedList<T> fractions = new LinkedList<T>();
        Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String fraction = iterator.next().element();
            fractions.add(new FractionDialog().create(fraction));
        }
        return fractions;
    }
    
    private LinkedList<String> strings(String string) {
        assert this.isValid(string);

        LinkedList<String> strings = new LinkedList<String>();
        String withoutBrackets = string.replaceAll("[" + PREFIX + POSTFIX + "]", "");
        if (withoutBrackets.isBlank()) {
            return strings;
        }
        String[] elements = withoutBrackets.split(SEPARATOR);
        for (String element : elements) {
            System.out.println("-" + element);
            strings.add(element);
        }
        return strings;
    }

}
