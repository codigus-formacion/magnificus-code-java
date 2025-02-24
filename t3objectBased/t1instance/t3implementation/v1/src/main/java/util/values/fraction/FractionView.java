package util.values.fraction;

import util.Console;

public class FractionView {

    private final String inputTitle;
    private final String outputTitle;
    private final Console console;

    public FractionView(String inputTitle, String outputTitle) {
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
        this.console = new Console();
    }

    public Fraction read() {
        int numerator;
        int denominator;
        boolean valid;
        this.console.writeln(this.inputTitle);
        do {
            numerator = this.console.readInt("Numerador: ");
            denominator = this.console.readInt("Denominador: ");
            valid = denominator != 0;
            if (!valid) {
                this.console.writeln("Fallo!!!" + this.outputTitle);
            }
        } while (!valid);
        return new Fraction(numerator, denominator);
    }

    public void write(Fraction fraction) {
        this.console.write(this.inputTitle + fraction);
    }

    public void writeln(Fraction fraction) {
        this.write(fraction);
        this.console.writeln();
    }

    public void writeCharacteristics(Fraction fraction){
        String string = "\n=============";
        string += "\ntoString: " + fraction.toString();
        string += "\nnumerator: " + fraction.numerator();
        string += "\ndenominator: " + fraction.denominator();
        string += "\nvalue: " + fraction.value();
        string += "\nopposite: " + fraction.opposite();
        if (!fraction.equals(new Fraction(0))){
            string += "\nreverse: " + fraction.reverse();
        }
        Fraction pivot = new Fraction(1,2);
        string += "\nadd 1/2: " + fraction.add(pivot);
        string += "\nsubtract 1/2: " + fraction.subtract(pivot);
        string += "\nmultiply 1/2: " + fraction.multiply(pivot);
        string += "\ndivide 1/2: " + fraction.divide(pivot);
        string += "\npower 2: " + fraction.power(2);
        string += "\nhashCode: " + fraction.hashCode();
        string += "\nclone: " + fraction.clone();
        this.console.writeln(string + "\n");
    }

}
