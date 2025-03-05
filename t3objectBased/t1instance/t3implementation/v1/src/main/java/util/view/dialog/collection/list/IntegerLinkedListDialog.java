package util.view.dialog.collection.list;

import util.view.Console;
import util.view.dialog.primitive.IntDialog;

import java.util.LinkedList;

import util.collection.list.IntegerIntervalLinkedList;
import util.collection.list.IntegerIterator;
import util.collection.list.IntegerLinkedList;
import util.collection.list.StringIterator;
import util.collection.list.StringLinkedList;
import util.values.interval.IntegerInterval;

public class IntegerLinkedListDialog {

    protected static final String PREFIX = "\\{";
    protected static final String SEPARATOR = ",";
    protected static final String POSTFIX = "\\}";

    protected static String REGEXP() {
        return PREFIX + "(" + IntDialog.REGEXP() + "(" + SEPARATOR + IntDialog.REGEXP() + ")*)?" + POSTFIX;
    }

    protected String title;
    protected Integer element;
    private String content;

    protected IntegerLinkedListDialog() {
        this.title = "";
    }

    public IntegerLinkedListDialog(String title) {
        assert title != null && !title.isBlank() : "Title cannot be null or blank";

        this.title = title;
    }

    public IntegerLinkedList read() {
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

    public IntegerLinkedList of(String string) {
        assert this.isValid(string);

        IntegerLinkedList intList = new IntegerLinkedList();
        IntegerIterator iterator = this.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next().element());
        }
        return intList;
    }

    protected IntegerLinkedList values(String string) {
        IntegerLinkedList integers = new IntegerLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next().element();
            integers.add(new IntDialog().of(elementString));
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

    public void write(IntegerLinkedList element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(IntegerLinkedList element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(IntegerLinkedList element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(IntegerLinkedList list) {
        assert list != null : "Element cannot be null";

        this.addLine("toString: " + list.toString());        
        int sum = 0;
        IntegerIterator iterator = list.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.addLine("sum: " + sum);

        LinkedList<Integer> mappedList = new LinkedList<Integer>();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        IntegerIntervalLinkedList intervalList = new IntegerIntervalLinkedList();
        iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next().element();
            intervalList.add(new IntegerInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Double> doubleList = new LinkedList<Double>();
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
