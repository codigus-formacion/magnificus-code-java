package util.view.dialog.collection.list;

import util.view.Console;
import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

import util.collection.list.DoubleIntervalLinkedList;
import util.collection.list.DoubleIterator;
import util.collection.list.DoubleLinkedList;
import util.collection.list.StringIterator;
import util.collection.list.StringLinkedList;
import util.values.interval.DoubleInterval;

public class DoubleLinkedListDialog {

    protected static final String PREFIX = "\\{";
    protected static final String SEPARATOR = ",";
    protected static final String POSTFIX = "\\}";

    protected static String REGEXP() {
        return PREFIX + "(" + IntDialog.REGEXP() + "(" + SEPARATOR + IntDialog.REGEXP() + ")*)?" + POSTFIX;
    }

    protected String title;
    protected Integer element;
    private String content;

    protected DoubleLinkedListDialog() {
        this.title = "";
    }

    public DoubleLinkedListDialog(String title) {
        assert title != null && !title.isBlank() : "Title cannot be null or blank";

        this.title = title;
    }

    public DoubleLinkedList read() {
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
        return "Al no respetar el formato \"" + REGEXP() + "\"";
    }

    protected boolean isValid(String string) {
        return string.matches(REGEXP());
    }

    public DoubleLinkedList of(String string) {
        assert this.isValid(string);

        DoubleLinkedList intList = new DoubleLinkedList();
        DoubleIterator iterator = this.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next().element());
        }
        return intList;
    }

    protected DoubleLinkedList values(String string) {
        DoubleLinkedList integers = new DoubleLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next().element();
            integers.add(new DoubleDialog().of(elementString));
        }
        return integers;
    }

    protected StringLinkedList strings(String string) {
        assert string != null : "Input string cannot be null";

        StringLinkedList strings = new StringLinkedList();
        String withoutBrackets = string.replaceAll("[" + PREFIX + POSTFIX + "]", "");
        if (withoutBrackets.isBlank()) {
            return strings;
        }
        for (String elementString : withoutBrackets.split(SEPARATOR)) {
            strings.add(elementString);
        }
        return strings;
    }

    public void write(DoubleLinkedList element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(DoubleLinkedList element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(DoubleLinkedList element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(DoubleLinkedList list) {
        assert list != null : "Element cannot be null";

        this.addLine("toString: " + list.toString());
        int sum = 0;
        DoubleIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.addLine("sum: " + sum);

        DoubleLinkedList mappedList = new DoubleLinkedList();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        DoubleIntervalLinkedList intervalList = new DoubleIntervalLinkedList();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Double integer = iterator.next().element();
            intervalList.add(new DoubleInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        DoubleLinkedList doubleList = new DoubleLinkedList();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            doubleList.add(iterator.next().element() * 2.0);
        }
        this.addLine("mapToDouble *2: " + doubleList);

        this.addLine("asDoubleList: " + doubleList.toString());
    }

    protected void addLine(String line) {
        this.content += "\n" + line;
    }

}
