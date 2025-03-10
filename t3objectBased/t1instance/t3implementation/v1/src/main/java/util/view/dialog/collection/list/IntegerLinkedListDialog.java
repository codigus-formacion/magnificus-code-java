package util.view.dialog.collection.list;

import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.IntDialog;

import util.collection.list.DoubleLinkedList;
import util.collection.list.IntegerIntervalLinkedList;
import util.collection.list.IntegerLinkedList;
import util.collection.list.StringLinkedList;
import util.collection.list.iterator.IntegerIterator;
import util.collection.list.iterator.StringIterator;
import util.values.IntegerInterval;

public class IntegerLinkedListDialog {

    private final String PREFIX = "\\{";
    private final String SEPARATOR = ",";
    private final String POSTFIX = "\\}";

    private String title;
    private String content;

    public IntegerLinkedListDialog(String title) {
        assert title != null && !title.isBlank() : "Title cannot be null or blank";

        this.title = title;
    }

    public IntegerLinkedList read() {
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

    private String regExp() {
        IntDialog intDialog = new IntDialog();
        return PREFIX + "(" + intDialog.regExp() + "(" + SEPARATOR + intDialog.regExp() + ")*)?" + POSTFIX;
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    private boolean isValid(String string) {
        return string.matches(regExp());
    }

    public IntegerLinkedList create(String string) {
        assert this.isValid(string);

        IntegerLinkedList intList = new IntegerLinkedList();
        IntegerIterator iterator = this.values(string).iterator();
        while (iterator.hasNext()) {
            intList.add(iterator.next().element());
        }
        return intList;
    }

    private IntegerLinkedList values(String string) {
        assert this.isValid(string);

        IntegerLinkedList integers = new IntegerLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String elementString = iterator.next().element();
            integers.add(new IntDialog().create(elementString));
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

    public void write(IntegerLinkedList integerLinkedList) {
        assert this.title != null;

        Console.instance().write(integerLinkedList);
    }

    public void writeln(IntegerLinkedList integerLinkedList) {
        this.write(integerLinkedList);
        Console.instance().writeln();
    }

    public void writeDetails(IntegerLinkedList integerLinkedList) {
        assert this.title != null;
        assert integerLinkedList != null;       

        this.content = "===============";
        this.addLine("toString: " + integerLinkedList.toString()); 
        this.addContent(integerLinkedList);
        Console.instance().writeln(this.content);
    }

    public void addContent(IntegerLinkedList integerLinkedList) {
        int sum = 0;
        IntegerIterator iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            sum += iterator.next().element();
        }
        this.addLine("sum: " + sum);

        IntegerLinkedList mappedList = new IntegerLinkedList();
        iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            mappedList.add(iterator.next().element() + 1);
        }
        this.addLine("map + 1: " + mappedList);

        IntegerIntervalLinkedList intervalList = new IntegerIntervalLinkedList();
        iterator = integerLinkedList.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next().element();
            intervalList.add(new IntegerInterval(-integer, integer));
        }
        this.addLine("mapToObj Interval: " + intervalList);

        DoubleLinkedList doubleList = new DoubleLinkedList();
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
