package util.values.optional;

import util.Console;
import util.values.fraction.Fraction;
import util.values.fraction.FractionView;
import util.values.interval.FractionIntervalView;
import util.values.interval.Interval;

public class FractionIntervalOptionalView extends OptionalView<Interval<Fraction>> {

    public FractionIntervalOptionalView(String inputTitle, String outputTitle) {
        super(inputTitle, outputTitle);
    }

    public Optional<Interval<Fraction>> read() {
        String input;
        Interval<Fraction> interval;
        boolean valid;
        Console.instance().writeln(this.inputTitle);
        do {
            input = Console.instance().readString();
            interval = FractionIntervalView.parse(input);
            min = fractionView.read();
            max = fractionView.read();
            valid = min.lesser(max);
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.outputTitle);
            }
        } while (!valid);
        if (input.equals("")){
            return Optional.empty();
        }
        return Optional.of(new Interval<Fraction>(min, max));
    }

    
}
