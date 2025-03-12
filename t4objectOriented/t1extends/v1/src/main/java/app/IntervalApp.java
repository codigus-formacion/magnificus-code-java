package app;

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
        LinkedList<DoubleInterval> doubleIntervalList = LinkedList.of(
                doubleIntervalDialog.read(),
                new DoubleInterval(-1.0, 1.0),
                new DoubleInterval(0.0, 0.0),
                doubleIntervalDialog.create("[100,200]"));
        LinkedList<DoubleInterval>.Iterator<DoubleInterval> doubleIntervalIterator = doubleIntervalList.iterator();
        while (doubleIntervalIterator.hasNext()) {
            doubleIntervalDialog.writeDetails(doubleIntervalIterator.next().element());
        }

        FractionIntervalDialog fractionIntervalDialog = new FractionIntervalDialog("Intervalo de Fracciones");
        LinkedList<FractionInterval> fractionIntervalList = LinkedList.of(
                fractionIntervalDialog.read(),
                new FractionInterval(new Fraction(-1), new Fraction(1)),
                new FractionInterval(new Fraction(1, 2), new Fraction(2, 1)),
                new FractionInterval(new Fraction(0), new Fraction(0)),
                fractionIntervalDialog.create("[1/2,2/3]"));
        LinkedList<FractionInterval>.Iterator<FractionInterval> fractionIntervalIterator = fractionIntervalList
                .iterator();
        while (fractionIntervalIterator.hasNext()) {
            fractionIntervalDialog.writeDetails(fractionIntervalIterator.next().element());
        }
        Console.close("0");
    }

}
