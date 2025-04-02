package app.dialog;

import util.collection.Collection;
import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

public class PrimitiveApp {

    public static void main(String[] args) {
        PrimitiveApp.writeDetails(
                new IntDialog("Entero"),
                LinkedList.of(
                        new IntDialog().read(),
                        0,
                        1,
                        -1));

        PrimitiveApp.writeDetails(
            new DoubleDialog("Decimal"),
            LinkedList.of(
                new DoubleDialog().read(),
                0.0,
                1.1,
                -1.2));
    }

    private static <T> void writeDetails(Dialog<T> dialog, Collection<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            dialog.writeDetails(iterator.next());
        }
    }

}
