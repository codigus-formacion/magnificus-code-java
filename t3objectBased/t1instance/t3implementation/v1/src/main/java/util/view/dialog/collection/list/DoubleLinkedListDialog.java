package util.view.dialog.collection.list;

import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.DoubleDialog;
import util.collection.list.DoubleIntervalLinkedList;
import util.collection.list.StringLinkedList;
import util.collection.list.iterator.DoubleIterator;
import util.collection.list.iterator.StringIterator;
import util.values.DoubleInterval;
import util.collection.list.DoubleLinkedList;

public class DoubleLinkedListDialog {

    private final String PREFIX = "\\{";
    private final String SEPARATOR = ",";
    private final String POSTFIX = "\\}";

    private String title;
    private String content;

    public DoubleLinkedListDialog(String title) {
        assert !title.isBlank() : "Title cannot be null or blank";

        this.title = title;
    }

    public DoubleLinkedList read() {
        String input;
        boolean valid;
        do {
            Console.instance().write(this.title + " (" + regExp() + "): ");
            input = Console.instance().readString();
            valid = this.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return this.create(input);
    }

    public String regExp() {
        DoubleDialog doubleDialog = new DoubleDialog();
        return PREFIX + "(" + doubleDialog.regExp() + "(" + SEPARATOR + doubleDialog.regExp() + ")*)?" + POSTFIX;
    }

    private boolean isValid(String string) {
        return string.matches(regExp());
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public DoubleLinkedList create(String string) {
        assert this.isValid(string);

        DoubleLinkedList intList = new DoubleLinkedList();
        DoubleIterator iterator = this.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next().element());
        }
        return intList;
    }
    
    private DoubleLinkedList values(String string) {
        assert this.isValid(string);

        DoubleLinkedList integers = new DoubleLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next().element();
            integers.add(new DoubleDialog().create(elementString));
        }
        return integers;
    }

    private StringLinkedList strings(String string) {
        assert this.isValid(string);

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

    public void write(DoubleLinkedList doubleLinkedList) {
        assert this.title != null;

        Console.instance().write(doubleLinkedList);
    }

    public void writeln(DoubleLinkedList doubleLinkedList) {
        this.write(doubleLinkedList);
        Console.instance().writeln();
    }

    public void writeDetails(DoubleLinkedList doubleLinkedList) {
        assert this.title != null;
        assert doubleLinkedList != null;

        this.content = "===============";
        this.addLine("toString: " + doubleLinkedList.toString());
        this.addContent(doubleLinkedList);
        Console.instance().writeln(this.content);
    }

    public void addContent(DoubleLinkedList doubleLinkedList) {
        int sum = 0;
        DoubleIterator iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.addLine("sum: " + sum);

        DoubleLinkedList mappedList = new DoubleLinkedList();
        iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        DoubleIntervalLinkedList intervalList = new DoubleIntervalLinkedList();
        iterator = doubleLinkedList.iterator();
        while (iterator.hasNext()) {
            Double integer = iterator.next().element();
            intervalList.add(new DoubleInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        DoubleLinkedList doubleList = new DoubleLinkedList();
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
