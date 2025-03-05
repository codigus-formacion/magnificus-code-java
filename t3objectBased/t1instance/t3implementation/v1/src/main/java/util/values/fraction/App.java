package util.values.fraction;

import util.collection.list.FractionIterator;
import util.collection.list.FractionLinkedList;
import util.view.Console;
import util.view.dialog.values.FractionDialog;

public class App {

    public static void main(String[] args) {
        FractionDialog fractionDialog = new FractionDialog("Fracción");
        FractionLinkedList fractionLinkedList = FractionLinkedList.of(
                // fractionDialog.read(),
                new Fraction(2, 3),
                new Fraction(-1),
                new Fraction(),
                fractionDialog.of("1/5"),
                fractionDialog.of("-1/5"),
                fractionDialog.of("1/-5"),
                fractionDialog.of("-1/-5"));
        FractionIterator fractionIterator = fractionLinkedList.iterator();
        while (fractionIterator.hasNext()) {
            fractionDialog.writeDetails(fractionIterator.next().element());
        }
        Console.close("0");
    }

}