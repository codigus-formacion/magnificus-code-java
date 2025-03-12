package app;

import util.collection.list.LinkedList;
import util.values.DoubleInterval;
import util.values.Fraction;
import util.values.FractionInterval;
import util.values.Interval;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.FractionIntervalDialog;

public class IntervalApp {

    public static void main(String[] args) {
        DoubleIntervalDialog doubleIntervalDialog = new DoubleIntervalDialog("Intervalo de Doubles");
        LinkedList<Interval<Double>> doubleIntervalList = LinkedList.of(
                doubleIntervalDialog.read(),
                new DoubleInterval(-1, 1),
                new DoubleInterval(0, 0),
                new DoubleIntervalDialog().create("[100,200]")
                );
        LinkedList<Interval<Double>>.Iterator<Interval<Double>> doubleIntervalIterator = doubleIntervalList.iterator();
        while (doubleIntervalIterator.hasNext()) {
            doubleIntervalDialog.writeDetails(doubleIntervalIterator.next());
        }

        FractionIntervalDialog fractionIntervalDialog = new FractionIntervalDialog("Intervalo de Fracciones");
        LinkedList<Interval<Fraction>> fractionIntervalList = LinkedList.of(
                fractionIntervalDialog.read(),
                new FractionInterval(new Fraction(-1), new Fraction(1)),
                new FractionInterval(new Fraction(1, 2), new Fraction(2, 1)),
                new FractionInterval(new Fraction(0), new Fraction(0)),
                new FractionIntervalDialog().create("[1/2,2/3]")
                );
        LinkedList<Interval<Fraction>>.Iterator<Interval<Fraction>> fractionIntervalIterator = fractionIntervalList
                .iterator();
        while (fractionIntervalIterator.hasNext()) {
            fractionIntervalDialog.writeDetails(fractionIntervalIterator.next());
        }
        Console.close("0");
    }

}
