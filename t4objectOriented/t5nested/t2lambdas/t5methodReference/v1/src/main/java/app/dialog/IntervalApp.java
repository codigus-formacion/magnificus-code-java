package app.dialog;

import util.collection.list.LinkedList;
import util.values.DoubleInterval;
import util.values.Fraction;
import util.values.FractionInterval;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.FractionIntervalDialog;

public class IntervalApp {

    public static void main(String[] args) {
        DoubleIntervalDialog doubleIntervalDialog = new DoubleIntervalDialog("Intervalo de Doubles");
        LinkedList.of(
                // doubleIntervalDialog.read(),
                new DoubleInterval(-1, 1),
                new DoubleInterval(0, 0),
                new DoubleIntervalDialog().create("[100,200]"))
                .forEach(doubleIntervalDialog::writeDetails);

        FractionIntervalDialog fractionIntervalDialog = new FractionIntervalDialog("Intervalo de Fracciones");
        LinkedList.of(
                // fractionIntervalDialog.read(),
                new FractionInterval(new Fraction(-1), new Fraction(1)),
                new FractionInterval(new Fraction(1, 2), new Fraction(2, 1)),
                new FractionInterval(new Fraction(0), new Fraction(0)),
                new FractionIntervalDialog().create("[1/2,2/3]"))
                .forEach(fractionIntervalDialog::writeDetails);
        Console.close("0");
    }

}
