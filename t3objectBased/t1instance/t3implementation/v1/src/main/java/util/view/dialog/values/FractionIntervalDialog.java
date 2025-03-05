package util.view.dialog.values;

import util.collection.list.StringIterator;
import util.collection.list.StringLinkedList;
import util.collection.list.FractionLinkedList;
import util.values.fraction.Fraction;
import util.values.interval.FractionInterval;
import util.view.Console;

public class FractionIntervalDialog {

    protected static final String PREFIX = "\\[";
    protected static final String SEPARATOR = ",";
    protected static final String POSTFIX = "\\]";

    public static String REGEXP(){
        return PREFIX + FractionDialog.REGEXP() + SEPARATOR + FractionDialog.REGEXP() + POSTFIX;
    }
    
    protected String title;
    protected FractionInterval element;
    private String content;
    
    protected FractionIntervalDialog() {
        this.title = "";
    }

    public FractionIntervalDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public FractionInterval read() {
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
        FractionLinkedList values = this.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    protected FractionLinkedList values(String string) {
        FractionLinkedList fractions = new FractionLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            fractions.add(new FractionDialog().of(iterator.next().element()));
        }
        return fractions;
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

    public FractionInterval of(String string) {
        assert this.isValid(string);

        return new FractionInterval(this.values(string).get(0), this.values(string).get(1));
    }

    public void write(FractionInterval element) {
        assert this.title != null;

        Console.instance().write(element);
    }

    public void writeln(FractionInterval element) {
        this.write(element);
        Console.instance().writeln();
    }

    public void writeDetails(FractionInterval element) {
        assert this.title != null;

        this.content = "===============";
        this.addContent(element);
        Console.instance().writeln(this.content);
    }

    public void addContent(FractionInterval interval) {
        Fraction initial = new Fraction();
        FractionInterval pivot = new FractionInterval(new Fraction(1,2), new Fraction(3,4));

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
        this.addLine("shifted 1: " + interval.shifted(new Fraction(1)));
        this.addLine("scaled 2: " + interval.scaled(2));
        this.addLine("symetric: " + interval.symetric());
        for (FractionInterval splitedInterval : interval.split(3)) {
            this.addLine("split: " + splitedInterval);
        }
    }

    protected void addLine(String line) {
        this.content += "\n" + line;
    }
    
}
