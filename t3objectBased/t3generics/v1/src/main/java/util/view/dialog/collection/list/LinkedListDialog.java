package util.view.dialog.collection.list;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.Dialog;

public class LinkedListDialog<T> {

    private static final String PREFIX = "\\{";
    private static final String SEPARATOR = ",";
    private static final String POSTFIX = "\\}";

    private Dialog<T> delegated;

    public LinkedListDialog(String title, String regExp) {
        this.delegated = new Dialog<T>(title, PREFIX + "(" + regExp + "(" + SEPARATOR + regExp + ")*)?" + POSTFIX);
    }

    public String read() {
        return this.delegated.read();
    }

    boolean isValid(String string) {
        return this.delegated.isValid(string);
    }

    public static LinkedList<String> strings(String string) {
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

    public void write(T element) {
        this.delegated.write(element);
    }

    public void writeln(T element) {
        this.delegated.writeln(element);
    }

    public void writeDetails(T element) {
        this.delegated.writeDetails();
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
