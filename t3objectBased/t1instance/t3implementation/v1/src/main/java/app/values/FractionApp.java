package app.values;

import util.collection.list.FractionLinkedList;
import util.collection.list.iterator.FractionIterator;
import util.values.Fraction;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.FractionDialog;

public class FractionApp {

    public static void main(String[] args) {
        FractionDialog fractionDialog = new FractionDialog("Fracción");
        FractionLinkedList fractionLinkedList = new FractionLinkedList();
        for(Fraction fraction : new Fraction[]{
            fractionDialog.read(),
            new Fraction(2, 3),
            new Fraction(-1),
            new Fraction(),
            fractionDialog.create("1/5"),
            fractionDialog.create("-1/5"),
            fractionDialog.create("1/-5"),
            fractionDialog.create("-1/-5")
        }) {
            fractionLinkedList.add(fraction);
        }
        FractionIterator fractionIterator = fractionLinkedList.iterator();
        while (fractionIterator.hasNext()) {
            fractionDialog.writeDetails(fractionIterator.next().element());
        }
        Console.close("0");
    }

}