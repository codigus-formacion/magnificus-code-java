package util.values.fraction;

import util.Console;

public class FractionView {

    private final String inputTitle;
    private final String outputTitle;

    public FractionView(String inputTitle, String outputTitle) {
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
    }

    public Fraction read() {
        int numerator;
        int denominator;
        boolean valid;
        Console.instance().writeln(this.inputTitle);
        do {
            numerator = Console.instance().readInt("Numerador: ");
            denominator = Console.instance().readInt("Denominador: ");
            valid = denominator != 0;
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.outputTitle);
            }
        } while (!valid);
        return new Fraction(numerator, denominator);
    }

    public void write(Fraction fraction) {
        Console.instance().write(this.inputTitle + fraction);
    }

    public void writeln(Fraction fraction) {
        this.write(fraction);
        Console.instance().writeln();
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
        Console.instance().writeln(string + "\n");
    }

    public static Fraction parse(String string) {
        if (!string.matches("-?\\\\d+/\\\\d+")){
            return null;
        }
        String[] partes = string.split("/");
        return new Fraction(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]));
      }


}
