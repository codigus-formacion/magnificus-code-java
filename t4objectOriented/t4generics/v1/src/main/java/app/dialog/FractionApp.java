package app.dialog;

import util.collection.Collection;
import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.Fraction;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.values.FractionDialog;

public class FractionApp {

    public static void main(String[] args) {
        FractionApp.writeDetails(
            new FractionDialog("Fracción"),
            LinkedList.of(
                new FractionDialog().read(),
                new Fraction(2, 3),
                new Fraction(-1),
                new Fraction(),
                new FractionDialog().create("1/5"),
                new FractionDialog().create("-1/5"),
                new FractionDialog().create("1/-5"),
                new FractionDialog().create("-1/-5")));
        Console.close("0");
    }

    private static <T> void writeDetails(Dialog<T> dialog, Collection<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            dialog.writeDetails(iterator.next());
        }
    }

}