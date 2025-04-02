package app.dialog;

import util.collection.Collection;
import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.DoubleInterval;
import util.values.Fraction;
import util.values.FractionInterval;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.FractionIntervalDialog;

public class IntervalApp {

    public static void main(String[] args) {
        IntervalApp.writeDetails(
                new DoubleIntervalDialog("Intervalo de Doubles"),
                LinkedList.of(
                        // doubleIntervalDialog.read(),
                        new DoubleInterval(-1, 1),
                        new DoubleInterval(0, 0),
                        new DoubleIntervalDialog().create("[100,200]")));

        IntervalApp.writeDetails(
            new FractionIntervalDialog("Intervalo de Fracciones"), 
            LinkedList.of(
                // fractionIntervalDialog.read(),
                new FractionInterval(new Fraction(-1), new Fraction(1)),
                new FractionInterval(new Fraction(1, 2), new Fraction(2, 1)),
                new FractionInterval(new Fraction(0), new Fraction(0)),
                new FractionIntervalDialog().create("[1/2,2/3]")));
        Console.close("0");
    }

    private static <T> void writeDetails(Dialog<T> dialog, Collection<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            dialog.writeDetails(iterator.next());
        }
    }

}
