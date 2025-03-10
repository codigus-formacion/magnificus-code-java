package util.view.dialog.values;

import util.collection.list.Iterator;
import util.collection.list.LinkedList;
import util.values.Fraction;
import util.values.FractionInterval;
import util.view.dialog.primitive.Console;

public class FractionIntervalDialog {

    private static final String PREFIX = "\\[";
    private static final String SEPARATOR = ",";
    private static final String POSTFIX = "\\]";
    
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
            valid = FractionIntervalDialog.isValid(input);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.errorMsg());
            }
        } while (!valid);
        return FractionIntervalDialog.create(input);
    }

    public static String regExp(){
        return PREFIX + FractionDialog.regExp() + SEPARATOR + FractionDialog.regExp() + POSTFIX;
    }

    private static boolean isValid(String string) {
        assert string != null;

        if (!string.matches(regExp())) {
            return false;
        }
        LinkedList<Fraction> values = FractionIntervalDialog.values(string);
        return values.get(0).compareTo(values.get(1)) <= 0;
    }

    private static LinkedList<Fraction> values(String string) {
        assert FractionIntervalDialog.isValid(string);

        LinkedList<Fraction> fractions = new LinkedList<Fraction>();
        Iterator<String> iterator = FractionIntervalDialog.strings(string).iterator();
        while (iterator.hasNext()) {
            String fraction = iterator.next().element();
            System.out.println("+" + fraction);
            System.out.println("=" + FractionDialog.create(fraction));
            fractions.add(FractionDialog.create(fraction));
        }
        System.out.println(fractions.isEmpty());
        System.out.println(fractions.size());
        return fractions;
    }
    
    private static LinkedList<String> strings(String string) {
        assert FractionIntervalDialog.isValid(string);

        LinkedList<String> strings = new LinkedList<String>();
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

    public static FractionInterval create(String string) {
        assert FractionIntervalDialog.isValid(string);

        LinkedList<Fraction> values = FractionIntervalDialog.values(string);
        return new FractionInterval(values.get(0), values.get(1));
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
        this.addContent(fractionInterval);
        Console.instance().writeln(this.content);
    }

    public void addContent(FractionInterval fractionInterval) {
        Fraction initial = new Fraction();
        FractionInterval pivot = new FractionInterval(new Fraction(1,2), new Fraction(3,4));

        this.addLine("toString: " + fractionInterval.toString());
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
        this.addLine("hashCode: " + fractionInterval.hashCode());
        this.addLine("clone: " + fractionInterval.clone());

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
