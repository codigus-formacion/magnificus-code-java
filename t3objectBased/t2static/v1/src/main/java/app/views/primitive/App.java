package app.views.primitive;

import util.collection.list.DoubleLinkedList;
import util.collection.list.IntegerLinkedList;
import util.collection.list.iterator.DoubleIterator;
import util.collection.list.iterator.IntegerIterator;
import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

public class App {

    public static void main(String[] args) {
        IntDialog intDialog = new IntDialog("Entero");
        IntegerLinkedList intList = IntegerLinkedList.of(
            intDialog.read(),
            0,
            1,
            -1);
        IntegerIterator intIterator = intList.iterator();
        while (intIterator.hasNext()) {
            intDialog.writeDetails(intIterator.next().element());
        }

        DoubleDialog doubleDialog = new DoubleDialog("Decimal");
        DoubleLinkedList doubleList = DoubleLinkedList.of(
            doubleDialog.read(),
                0.0,
                1.1,
                -1.2);
        DoubleIterator doubleIterator = doubleList.iterator();
        while (doubleIterator.hasNext()) {
            doubleDialog.writeDetails(doubleIterator.next().element());
        }
    }

}
