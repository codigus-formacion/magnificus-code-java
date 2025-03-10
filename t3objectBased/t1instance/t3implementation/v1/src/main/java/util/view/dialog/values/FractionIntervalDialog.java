package util.view.dialog.values;

import util.collection.list.StringLinkedList;
import util.collection.list.iterator.StringIterator;
import util.collection.list.FractionLinkedList;
import util.values.Fraction;
import util.values.FractionInterval;
import util.view.dialog.primitive.Console;

public class FractionIntervalDialog {

    private final String PREFIX = "\\[";
    private final String SEPARATOR = ",";
    private final String POSTFIX = "\\]";
    
    private String title;
    private String content;

    public FractionIntervalDialog(String title) {
        assert !title.isBlank();

        this.title = title;
    }

    public FractionInterval read() {
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
        FractionDialog fractionDialog = new FractionDialog();
        return PREFIX + fractionDialog.regExp() + SEPARATOR + fractionDialog.regExp() + POSTFIX;
    }

    private boolean isValid(String string) {
        assert string != null;

        if (!string.matches(regExp())) {
            return false;
        }
        FractionLinkedList values = this.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    private FractionLinkedList values(String string) {
        assert this.isValid(string);

        FractionLinkedList fractions = new FractionLinkedList();
        StringIterator iterator = this.strings(string).iterator();
        while (iterator.hasNext()) {
            String fraction = iterator.next().element();
            System.out.println("+" + fraction);
            System.out.println("=" + new FractionDialog().create(fraction));
            fractions.add(new FractionDialog().create(fraction));
        }
        System.out.println(fractions.isEmpty());
        System.out.println(fractions.size());
        return fractions;
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
            System.out.println("-" + element);
            strings.add(element);
        }
        return strings;
    }

    private String errorMsg() {
        return "Al no respetar el formato \"" + regExp() + "\"";
    }

    public FractionInterval create(String string) {
        assert this.isValid(string);

        return new FractionInterval(this.values(string).get(0), this.values(string).get(1));
    }

    public void write(FractionInterval fractionInterval) {
        assert fractionInterval != null;

        Console.instance().write(fractionInterval);
    }

    public void writeln(FractionInterval fractionInterval) {
        this.write(fractionInterval);
        Console.instance().writeln();
    }

    public void writeDetails(FractionInterval fractionInterval) {
        assert this.title != null;

        this.content = "===============";
        this.addLine("toString: " + fractionInterval.toString());
        this.addContent(fractionInterval);
        Console.instance().writeln(this.content);
    }

    public void addContent(FractionInterval fractionInterval) {
        Fraction initial = new Fraction();
        FractionInterval pivot = new FractionInterval(new Fraction(1,2), new Fraction(3,4));

        this.addLine("getMin: " + fractionInterval.min());
        this.addLine("getMax: " + fractionInterval.max());
        this.addLine("includes 0: " + fractionInterval.includes(initial));
        this.addLine("includes [-1,1]: " + fractionInterval.includes(pivot));
        this.addLine("equals [-1,1]: " + fractionInterval.equals(pivot));
        this.addLine("isIntersected [-1,1]: " + fractionInterval.isIntersected(pivot));
        if (fractionInterval.isIntersected(pivot)) {
            this.addLine("intersection [-1,1]: " + fractionInterval.intersection(pivot));
            this.addLine("union [-1,1]: " + fractionInterval.union(pivot));
        }
        this.addLine("superInterval [-1,1]: " + fractionInterval.superInterval(pivot));

        this.addLine("length: " + fractionInterval.length());
        this.addLine("middlePoint: " + fractionInterval.middlePoint());
        this.addLine("shifted 1: " + fractionInterval.shifted(new Fraction(1)));
        this.addLine("scaled 2: " + fractionInterval.scaled(2));
        this.addLine("symetric: " + fractionInterval.symetric());
        for (FractionInterval splitedInterval : fractionInterval.split(3)) {
            this.addLine("split: " + splitedInterval);
        }
    }

    private void addLine(String line) {
        this.content += "\n" + line;
    }
    
}
