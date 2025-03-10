package app.values;

import util.collection.list.Iterator;
import util.collection.list.LinkedList;
import util.values.Fraction;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.FractionDialog;

public class FractionApp {

    public static void main(String[] args) {
        FractionDialog fractionDialog = new FractionDialog("Fracción");
        LinkedList<Fraction> fractionLinkedList = LinkedList.of(
                fractionDialog.read(),
                new Fraction(2, 3),
                new Fraction(-1),
                new Fraction(),
                FractionDialog.create("1/5"),
                FractionDialog.create("-1/5"),
                FractionDialog.create("1/-5"),
                FractionDialog.create("-1/-5"));
        Iterator<Fraction> fractionIterator = fractionLinkedList.iterator();
        while (fractionIterator.hasNext()) {
            fractionDialog.writeDetails(fractionIterator.next().element());
        }
        Console.close("0");
    }

}