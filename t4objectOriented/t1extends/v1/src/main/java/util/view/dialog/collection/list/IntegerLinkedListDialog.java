package util.view.dialog.collection.list;

import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.IntDialog;

import util.collection.list.Iterator;
import util.collection.list.LinkedList;
import util.values.IntegerInterval;

public class IntegerLinkedListDialog {

    private static final String PREFIX = "\\{";
    private static final String SEPARATOR = ",";
    private static final String POSTFIX = "\\}";

    private String title;
    private String content;

    public IntegerLinkedListDialog(String title) {
        assert title != null && !title.isBlank() : "Title cannot be null or blank";

        this.title = title;
    }

    public LinkedList<Integer> read() {
        String input;
        boolean valid;
        do {
            Console.instance().write(this.title + " (" + regExp() + "): ");
            input = Console.instance().readString();
            valid = IntegerLinkedListDialog.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return IntegerLinkedListDialog.create(input);
    }

    private static String regExp() {
        IntDialog intDialog = new IntDialog();
        return PREFIX + "(" + intDialog.regExp() + "(" + SEPARATOR + intDialog.regExp() + ")*)?" + POSTFIX;
    }

    private static boolean isValid(String string) {
        return string.matches(regExp());
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public static LinkedList<Integer> create(String string) {
        assert IntegerLinkedListDialog.isValid(string);

        LinkedList<Integer> intList = new LinkedList<Integer>();
        Iterator<Integer> iterator = IntegerLinkedListDialog.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next().element());
        }
        return intList;
    }

    private static LinkedList<Integer> values(String string) {
        assert IntegerLinkedListDialog.isValid(string);

        LinkedList<Integer> integers = new LinkedList<Integer>();
        Iterator<String> iterator = IntegerLinkedListDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next().element();
            integers.add(new IntDialog().create(elementString));
        }
        return integers;
    }

    private static LinkedList<String> strings(String string) {
        assert IntegerLinkedListDialog.isValid(string);

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

    public void write(LinkedList<Integer> integerLinkedList) {
        assert this.title != null;

        Console.instance().write(integerLinkedList);
    }

    public void writeln(LinkedList<Integer> integerLinkedList) {
        this.write(integerLinkedList);
        Console.instance().writeln();
    }

    public void writeDetails(LinkedList<Integer> integerLinkedList) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(integerLinkedList);
        Console.instance().writeln(this.content);
    }

    public void addContent(LinkedList<Integer> integerLinkedList) {
        assert integerLinkedList != null : "Element cannot be null";

        this.addLine("toString: " + integerLinkedList.toString());        
        int sum = 0;
        Iterator<Integer> iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.addLine("sum: " + sum);

        LinkedList<Integer> mappedList = new LinkedList<Integer>();
        iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        LinkedList<IntegerInterval> intervalList = new LinkedList<IntegerInterval>();
        iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next().element();
            intervalList.add(new IntegerInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        LinkedList<Double> doubleList = new LinkedList<Double>();
        iterator = integerLinkedList.iterator();
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
