package app.values;

import util.collection.list.FractionLinkedList;
import util.collection.list.iterator.FractionIterator;
import util.values.Fraction;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.FractionDialog;

public class FractionApp {

    public static void main(String[] args) {
        FractionDialog fractionDialog = new FractionDialog("Fracción");
        FractionLinkedList fractionLinkedList = FractionLinkedList.of(
            fractionDialog.read(),
            new Fraction(2, 3),
            new Fraction(-1),
            new Fraction(),
            FractionDialog.create("1/5"),
            FractionDialog.create("-1/5"),
            FractionDialog.create("1/-5"),
            FractionDialog.create("-1/-5"));
        FractionIterator fractionIterator = fractionLinkedList.iterator();
        while (fractionIterator.hasNext()) {
            fractionDialog.writeDetails(fractionIterator.next().element());
        }
        Console.close("0");
    }

}