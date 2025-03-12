package app;

import util.view.dialog.collection.list.DoubleLinkedListDialog;
import util.view.dialog.collection.list.IntegerLinkedListDialog;
import util.view.dialog.primitive.Console;
import util.collection.list.DoubleLinkedList;
import util.collection.list.DoubleLinkedListLinkedList;
import util.collection.list.IntegerLinkedList;
import util.collection.list.IntegerLinkedListLinkedList;
import util.collection.list.iterator.DoubleLinkedListIterator;
import util.collection.list.iterator.IntegerLinkedListIterator;

public class LinkedListApp {

    public static void main(String[] args) {
        IntegerLinkedListDialog intLinkedListDialog = new IntegerLinkedListDialog("Lista de Enteros");
        IntegerLinkedListLinkedList integerLinkedListLinkedList = IntegerLinkedListLinkedList.of(
                intLinkedListDialog.read(),
                IntegerLinkedList.of(new Integer[] { 1, 2, 3 }),
                IntegerLinkedList.of(4, 5, 6),
                IntegerLinkedList.of(4, 5, 6),
                IntegerLinkedList.of(),
                IntegerLinkedList.empty(),
                IntegerLinkedListLinkedList.getRandomIntList(),
                IntegerLinkedListLinkedList.getRangeIntList(),
                IntegerLinkedListLinkedList.getRangeClosedIntList(),
                IntegerLinkedListDialog.create("{}"),
                IntegerLinkedListDialog.create("{1,2,3}"),
                IntegerLinkedListDialog.create("{-3,-2,-1}"),
                IntegerLinkedListDialog.create("{100,150,200}"));
        IntegerLinkedListIterator integerLinkedListIterator = integerLinkedListLinkedList.iterator();
        while (integerLinkedListIterator.hasNext()) {
            intLinkedListDialog.writeDetails(integerLinkedListIterator.next());
        }

        DoubleLinkedListDialog doubleLinkedListDialog = new DoubleLinkedListDialog("Lista de Decimales");
        DoubleLinkedListLinkedList doubleLinkedListLinkedList = DoubleLinkedListLinkedList.of(
                doubleLinkedListDialog.read(),
                DoubleLinkedList.of(new Double[] { 1.1, 2.2, 3.3 }),
                DoubleLinkedList.of(4.4, 5.5, 6.6),
                DoubleLinkedList.of(),
                DoubleLinkedList.empty(),
                DoubleLinkedListLinkedList.getRandomDoublelist(),
                DoubleLinkedListDialog.create("{}"),
                DoubleLinkedListDialog.create("{1.1,2.2,3.3}"),
                DoubleLinkedListDialog.create("{-3.3,-2.2,-1.1}"),
                DoubleLinkedListDialog.create("{100.0,150.0,200.0}"));
        DoubleLinkedListIterator doubleLinkedListIterator = doubleLinkedListLinkedList.iterator();
        while (doubleLinkedListIterator.hasNext()) {
            doubleLinkedListDialog.writeDetails(doubleLinkedListIterator.next());
        }
        Console.close("0");
    }

}
