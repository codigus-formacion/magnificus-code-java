package util.view.dialog.collection.list;

import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.DoubleDialog;
import util.values.DoubleInterval;
import util.collection.list.Iterator;
import util.collection.list.LinkedList;

public class DoubleLinkedListDialog {

    private static final String PREFIX = "\\{";
    private static final String SEPARATOR = ",";
    private static final String POSTFIX = "\\}";

    private String title;
    private String content;

    public DoubleLinkedListDialog(String title) {
        assert !title.isBlank() : "Title cannot be null or blank";

        this.title = title;
    }

    public LinkedList<Double> read() {
        String input;
        boolean valid;
        do {
            Console.instance().write(this.title + " (" + regExp() + "): ");
            input = Console.instance().readString();
            valid = DoubleLinkedListDialog.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return DoubleLinkedListDialog.create(input);
    }

    public static String regExp() {
        DoubleDialog doubleDialog = new DoubleDialog();
        return PREFIX + "(" + doubleDialog.regExp() + "(" + SEPARATOR + doubleDialog.regExp() + ")*)?" + POSTFIX;
    }

    private static boolean isValid(String string) {
        return string.matches(regExp());
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public static LinkedList<Double> create(String string) {
        assert DoubleLinkedListDialog.isValid(string);

        LinkedList<Double> intList = new LinkedList<Double>();
        Iterator<Double> iterator = DoubleLinkedListDialog.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next().element());
        }
        return intList;
    }
    
    private static LinkedList<Double> values(String string) {
        assert DoubleLinkedListDialog.isValid(string);

        LinkedList<Double> integers = new LinkedList<Double>();
        Iterator<String> iterator = DoubleLinkedListDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next().element();
            integers.add(new DoubleDialog().create(elementString));
        }
        return integers;
    }

    private static LinkedList<String> strings(String string) {
        assert DoubleLinkedListDialog.isValid(string);

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

    public void write(LinkedList<Double> doubleLinkedList) {
        assert this.title != null;

        Console.instance().write(doubleLinkedList);
    }

    public void writeln(LinkedList<Double> doubleLinkedList) {
        this.write(doubleLinkedList);
        Console.instance().writeln();
    }

    public void writeDetails(LinkedList<Double> doubleLinkedList) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(doubleLinkedList);
        Console.instance().writeln(this.content);
    }

    public void addContent(LinkedList<Double> doubleLinkedList) {
        assert doubleLinkedList != null : "Element cannot be null";

        this.addLine("toString: " + doubleLinkedList.toString());
        int sum = 0;
        Iterator<Double> iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.addLine("sum: " + sum);

        LinkedList<Double> mappedList = new LinkedList<Double>();
        iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        LinkedList<DoubleInterval> intervalList = new LinkedList<DoubleInterval>();
        iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            Double integer = iterator.next().element();
            intervalList.add(new DoubleInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Double> doubleList = new LinkedList<Double>();
        iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            doubleList.add(iterator.next().element() * 2.0);
        }
        this.addLine("mapToDouble *2: " + doubleList);

        this.addLine("asDoubleList: " + doubleList.toString());
    }

    private void addLine(String line) {
        this.content += "\n" + line;
    }

}
