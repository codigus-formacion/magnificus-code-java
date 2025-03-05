package util.values.interval;

import util.collection.list.FractionIntervalIterator;
import util.collection.list.FractionIntervalLinkedList;
import util.collection.list.DoubleIntervalIterator;
import util.collection.list.DoubleIntervalLinkedList;
import util.values.fraction.Fraction;
import util.view.Console;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.FractionIntervalDialog;

public class App {

    public static void main(String[] args) {
        DoubleIntervalDialog doubleIntervalDialog = new DoubleIntervalDialog("Intervalo de Doubles");
        DoubleIntervalLinkedList doubleIntervalList = DoubleIntervalLinkedList.of(
                // doubleIntervalDialog.read(),
                new DoubleInterval(-1, 1),
                new DoubleInterval(0, 0),
                doubleIntervalDialog.of("[100,200]"));
        DoubleIntervalIterator doubleIntervalIterator = doubleIntervalList.iterator();
        while (doubleIntervalIterator.hasNext()) {
            doubleIntervalDialog.writeDetails(doubleIntervalIterator.next().element());
        }

        FractionIntervalDialog fractionIntervalDialog = new FractionIntervalDialog("Intervalo de Fracciones");
        FractionIntervalLinkedList fractionIntervalList = FractionIntervalLinkedList.of(
                // fractionIntervalDialog.read(),
                new FractionInterval(new Fraction(-1), new Fraction(1)),
                new FractionInterval(new Fraction(1, 2), new Fraction(2, 1)),
                new FractionInterval(new Fraction(0), new Fraction(0)),
                fractionIntervalDialog.of("[1/2,2/3]"));
        FractionIntervalIterator fractionIntervalIterator = fractionIntervalList.iterator();
        while (fractionIntervalIterator.hasNext()) {
            fractionIntervalDialog.writeDetails(fractionIntervalIterator.next().element());
        }
        Console.close("0");
    }

}
