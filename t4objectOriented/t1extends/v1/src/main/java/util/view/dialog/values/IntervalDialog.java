package util.view.dialog.values;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.Dialog;

public abstract class IntervalDialog<T,U> extends Dialog<T> {

    private static final String PREFIX = "\\[";
    private static final String SEPARATOR = ",";
    private static final String POSTFIX = "\\]";

    public IntervalDialog(String title) {
        super(title);
    }

    protected String regExp(String regExp) {
        return PREFIX + regExp + SEPARATOR + regExp + POSTFIX;
    }

    protected LinkedList<U> values(String string) {
        assert this.isValid(string);

        LinkedList<U> elements = new LinkedList<U>();
        LinkedList<String>.Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String element = iterator.next().element();
            elements.add(this.createElement(element));
        }
        return elements;
    }

    protected abstract U createElement(String element);

    protected LinkedList<String> strings(String string) {
        assert this.isValid(string);

        LinkedList<String> strings = new LinkedList<String>();
        String withoutBrackets = string.replaceAll("[" + PREFIX + POSTFIX + "]", "");
        if (withoutBrackets.isBlank()) {
            return strings;
        }
        String[] elements = withoutBrackets.split(SEPARATOR);
        for (String element : elements) {
            strings.add(element);
        }
        return strings;
    }

}
