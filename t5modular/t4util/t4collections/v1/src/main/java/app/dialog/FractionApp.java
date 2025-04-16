package app.dialog;

import java.util.LinkedList;

import util.values.Fraction;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.FractionDialog;

public class FractionApp {

    public static void main(String[] args) {
        FractionDialog fractionDialog = new FractionDialog("Fracción");
        FractionApp.of(
                // fractionDialog.read(),
                new Fraction(2, 3),
                new Fraction(-1),
                new Fraction(),
                fractionDialog.create("1/5"),
                fractionDialog.create("-1/5"),
                fractionDialog.create("1/-5"),
                fractionDialog.create("-1/-5"))
                .forEach(element -> {
                    fractionDialog.writeDetails(element);
                });
        Console.close("0");
    }

    private static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> list = new LinkedList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

}