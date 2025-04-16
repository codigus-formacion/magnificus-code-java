package util.values.optional;

import util.Console;
import util.values.fraction.Fraction;
import util.values.interval.Interval;

public class App {

    public static void main(String[] args) {
        IntegerOptionalView integerOptionalView = new IntegerOptionalView("Optional", "Error");
        integerOptionalView.writeCharacteristics(integerOptionalView.read());
        integerOptionalView.writeCharacteristics(Optional.empty());
        integerOptionalView.writeCharacteristics(Optional.of(1));
        integerOptionalView.writeCharacteristics(Optional.of(2));
        integerOptionalView.writeCharacteristics(Optional.ofNullable(null));
        integerOptionalView.writeCharacteristics(Optional.ofNullable(1));
        integerOptionalView.writeCharacteristics(Optional.ofNullable(2));

        FractionIntervalOptionalView fractionIntervalOptionalView = new FractionIntervalOptionalView("Optional", "Error");
        fractionIntervalOptionalView.writeCharacteristics(fractionIntervalOptionalView.read());
        fractionIntervalOptionalView.writeCharacteristics(Optional.empty());
        fractionIntervalOptionalView.writeCharacteristics(Optional.of(new Interval<Fraction>(new Fraction(1), new Fraction(2))));
        fractionIntervalOptionalView.writeCharacteristics(Optional.of(new Interval<Fraction>(new Fraction(10), new Fraction(20))));
        fractionIntervalOptionalView.writeCharacteristics(Optional.ofNullable(null));
        fractionIntervalOptionalView.writeCharacteristics(Optional.ofNullable(new Interval<Fraction>(new Fraction(1), new Fraction(1))));

        Console.close("0");
    }

}
