package util.view.dialog.values;

import util.collection.list.DoubleLinkedList;
import util.collection.list.StringIterator;
import util.collection.list.StringLinkedList;
import util.values.interval.DoubleInterval;
import util.values.interval.FractionInterval;
import util.view.Console;
import util.view.dialog.primitive.DoubleDialog;

public class DoubleIntervalDialog {

    protected static final String PREFIX = "\\[";
    protected static final String SEPARATOR = ",";
    protected static final String POSTFIX = "\\]";

    public static String REGEXP(){
        return PREFIX + DoubleDialog.REGEXP() + SEPARATOR + DoubleDialog.REGEXP() + POSTFIX;
    }
    
    protected String title;
    protected FractionInterval element;
    private String content;
    
    protected DoubleIntervalDialog() {
        this.title = "";
    }

    public DoubleIntervalDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public DoubleInterval read() {
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

    protected boolean isValid(String string) {
        if (!string.matches(REGEXP())) {
            return false;
        }
        DoubleLinkedList values = this.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    protected DoubleLinkedList values(String string) {
        DoubleLinkedList doubleList = new DoubleLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            doubleList.add(new DoubleDialog().of(iterator.next().element()));
        }
        return doubleList;
    }
    
    protected StringLinkedList strings(String string) {
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

    protected String errorMsg() {
        return "Al no respetar el formato \"" + REGEXP() + "\"";
    }

    public DoubleInterval of(String string) {
        assert this.isValid(string);

        return new DoubleInterval(this.values(string).get(0), this.values(string).get(1));
    }

    public void write(DoubleInterval element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(DoubleInterval element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(DoubleInterval element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(DoubleInterval interval) {
        Double initial = 0.0;
        DoubleInterval pivot = new DoubleInterval(-1.1,1.1);

        this.addLine("toString: " + interval.toString());
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
        this.addLine("hashCode: " + interval.hashCode());
        this.addLine("clone: " + interval.clone());

                this.addLine("length: " + interval.length());
        this.addLine("middlePoint: " + interval.middlePoint());
        this.addLine("shifted 1: " + interval.shifted(1));
        this.addLine("scaled 2: " + interval.scaled(2));
        this.addLine("symetric: " + interval.symetric());
        for (DoubleInterval splitedInterval : interval.split(3)) {
            this.addLine("split: " + splitedInterval);
        }
    }

    protected void addLine(String line) {
        this.content += "\n" + line;
    }

}
