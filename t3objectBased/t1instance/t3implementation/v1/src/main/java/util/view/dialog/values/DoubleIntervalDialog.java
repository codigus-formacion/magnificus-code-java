package util.view.dialog.values;

import util.collection.list.DoubleLinkedList;
import util.collection.list.StringLinkedList;
import util.collection.list.iterator.StringIterator;
import util.values.DoubleInterval;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.DoubleDialog;

public class DoubleIntervalDialog {

    private final String PREFIX = "\\[";
    private final String SEPARATOR = ",";
    private final String POSTFIX = "\\]";
    
    private String title;
    private String content;

    public DoubleIntervalDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public DoubleInterval read() {
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

    public String regExp(){
        String regExp = new DoubleDialog().regExp();
        return PREFIX + regExp + SEPARATOR + regExp + POSTFIX;
    }

    private boolean isValid(String string) {
        assert string != null;

        if (!string.matches(regExp())) {
            return false;
        }
        DoubleLinkedList values = this.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    private DoubleLinkedList values(String string) {
        assert this.isValid(string);

        DoubleLinkedList doubleList = new DoubleLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            doubleList.add(new DoubleDialog().create(iterator.next().element()));
        }
        return doubleList;
    }
    
    private StringLinkedList strings(String string) {
        assert this.isValid(string);

        StringLinkedList strings = new StringLinkedList();
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

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public DoubleInterval create(String string) {
        assert this.isValid(string);

        return new DoubleInterval(this.values(string).get(0), this.values(string).get(1));
    }

    public void write(DoubleInterval doubleInterval) {
        assert doubleInterval != null;

        Console.instance().write(doubleInterval);
    }

    public void writeln(DoubleInterval doubleInterval) {
        this.write(doubleInterval);
        Console.instance().writeln();
    }

    public void writeDetails(DoubleInterval doubleInterval) {
        assert this.title != null;

        this.content = "===============";
        this.addLine("toString: " + doubleInterval.toString());
        this.addContent(doubleInterval);
        Console.instance().writeln(this.content);
    }

    public void addContent(DoubleInterval interval) {
        Double initial = 0.0;
        DoubleInterval pivot = new DoubleInterval(-1.1,1.1);
        this.addLine("getMin: " + interval.min());
        this.addLine("getMax: " + interval.max());
        this.addLine("includes 0: " + interval.includes(initial));
        this.addLine("includes [-1,1]: " + interval.includes(pivot));
        this.addLine("equals [-1,1]: " + interval.equals(pivot));
        this.addLine("isIntersected [-1,1]: " + interval.isIntersected(pivot));
        if (interval.isIntersected(pivot)) {
            this.addLine("intersection [-1,1]: " + interval.intersection(pivot));
            this.addLine("union [-1,1]: " + interval.union(pivot));
        }
        this.addLine("superInterval [-1,1]: " + interval.superInterval(pivot));

                this.addLine("length: " + interval.length());
        this.addLine("middlePoint: " + interval.middlePoint());
        this.addLine("shifted 1: " + interval.shifted(1));
        this.addLine("scaled 2: " + interval.scaled(2));
        this.addLine("symetric: " + interval.symetric());
        for (DoubleInterval splitedInterval : interval.split(3)) {
            this.addLine("split: " + splitedInterval);
        }
    }

    private void addLine(String line) {
        this.content += "\n" + line;
    }

}
