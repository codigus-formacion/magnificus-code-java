package util.view.dialog.values;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.Dialog;

public class IntervalDialog<T> {

    private static final String PREFIX = "\\[";
    private static final String SEPARATOR = ",";
    private static final String POSTFIX = "\\]";

    private Dialog<T> delegated;

    public IntervalDialog(String title, String regExp) {
        this.delegated = new Dialog<T>(title, PREFIX + regExp + SEPARATOR + regExp + POSTFIX);
    }

    public String read() {
        return this.delegated.read();
    }

    public static LinkedList<String> strings(String string) {
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

    public void write(T element) {
        this.delegated.write(element);
    }

    public void writeln(T element) {
        this.delegated.writeln(element);
    }

    public void addHead(T element) {
        this.delegated.addHead(element);
    }

    public void writeDetails() {
        this.delegated.writeDetails();
    }

    public void addLine(String line) {
        this.delegated.addLine(line);
    }

}
