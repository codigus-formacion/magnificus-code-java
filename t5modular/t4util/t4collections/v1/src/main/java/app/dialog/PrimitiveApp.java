package app.dialog;

import java.util.LinkedList;

import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

public class PrimitiveApp {

    public static void main(String[] args) {
        IntDialog intDialog = new IntDialog("Entero");
        PrimitiveApp.of(
                // intDialog.read(),
                0,
                1,
                -1)
                .forEach(element -> {
                    intDialog.writeDetails((Integer) element);
                });

        DoubleDialog doubleDialog = new DoubleDialog("Decimal");
        PrimitiveApp.of(
                // doubleDialog.read(),
                0.0,
                1.1,
                -1.2)
                .forEach(element -> {
                    doubleDialog.writeDetails((Double) element);
                });

    }

    private static <T> LinkedList<T> of(T... elements) {
        LinkedList<T> list = new LinkedList<>();
        for (T element : elements) {
            list.add(element);
        }
        return list;
    }

}
