package app.dialog;

import java.util.stream.Stream;

import util.values.Fraction;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.FractionDialog;

public class FractionApp {

    public static void main(String[] args) {
        FractionDialog fractionDialog = new FractionDialog("Fracción");
        PrimitiveApp.writeDetails(
            Stream.of(
                // fractionDialog.read(),
                new Fraction(2, 3),
                new Fraction(-1),
                new Fraction(),
                fractionDialog.create("1/5"),
                fractionDialog.create("-1/5"),
                fractionDialog.create("1/-5"),
                fractionDialog.create("-1/-5")),
            fractionDialog);
        Console.close("0");
    }

}