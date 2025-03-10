package util.view.dialog.collection.list;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.Dialog;

public abstract class LinkedListDialog<T> extends Dialog<LinkedList<T>> {

    private static final String PREFIX = "\\{";
    private static final String SEPARATOR = ",";
    private static final String POSTFIX = "\\}";

    public LinkedListDialog(String title) {
        super(title);
    }

    protected String regExp(String regExp) {
        return PREFIX + "(" + regExp + "(" + SEPARATOR + regExp + ")*)?" + POSTFIX;
    }

    public LinkedList<T> create(String string) {
        assert this.isValid(string);

        return this.values(string);
    }

    protected LinkedList<T> values(String string) {
        assert this.isValid(string);

        LinkedList<T> elements = new LinkedList<T>();
        LinkedList<String>.Iterator<String> iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next().element();
            elements.add(this.createElement(elementString));
        }
        return elements;
    }

    protected abstract T createElement(String elementString);

    protected LinkedList<String> strings(String string) {
        assert this.isValid(string);

        LinkedList<String> strings = new LinkedList<String>();
        String withoutBrackets = string.replaceAll("[" + PREFIX + POSTFIX + "]", "");
        if (withoutBrackets.isBlank()) {
            return strings;
        }
        for (String elementString : withoutBrackets.split(SEPARATOR)) {
            strings.add(elementString);
        }
        return strings;
    }

}
