package app.values;

import util.collection.list.FractionIntervalLinkedList;
import util.collection.list.iterator.DoubleIntervalIterator;
import util.collection.list.iterator.FractionIntervalIterator;
import util.collection.list.DoubleIntervalLinkedList;
import util.values.DoubleInterval;
import util.values.Fraction;
import util.values.FractionInterval;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.FractionIntervalDialog;

public class IntervalApp {

    public static void main(String[] args) {
        DoubleIntervalDialog doubleIntervalDialog = new DoubleIntervalDialog("Intervalo de Doubles");
        DoubleIntervalLinkedList doubleIntervalList = new DoubleIntervalLinkedList();
        for(DoubleInterval doubleInterval : new DoubleInterval[]{
            doubleIntervalDialog.read(),
            new DoubleInterval(-1, 1),
            new DoubleInterval(0, 0),
            doubleIntervalDialog.create("[100,200]")
        }){
            doubleIntervalList.add(doubleInterval);
        }
        DoubleIntervalIterator doubleIntervalIterator = doubleIntervalList.iterator();
        while (doubleIntervalIterator.hasNext()) {
            doubleIntervalDialog.writeDetails(doubleIntervalIterator.next().element());
        }

        FractionIntervalDialog fractionIntervalDialog = new FractionIntervalDialog("Intervalo de Fracciones");
        FractionIntervalLinkedList fractionIntervalList = new FractionIntervalLinkedList();
        for(FractionInterval fractionInterval : new FractionInterval[]{
            fractionIntervalDialog.read(),
                new FractionInterval(new Fraction(-1), new Fraction(1)),
                new FractionInterval(new Fraction(1, 2), new Fraction(2, 1)),
                new FractionInterval(new Fraction(0), new Fraction(0)),
                fractionIntervalDialog.create("[1/2,2/3]")
        }) {
            fractionIntervalList.add(fractionInterval);
        }
        FractionIntervalIterator fractionIntervalIterator = fractionIntervalList.iterator();
        while (fractionIntervalIterator.hasNext()) {
            fractionIntervalDialog.writeDetails(fractionIntervalIterator.next().element());
        }
        Console.close("0");
    }

}
