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
import util.values.Math;

public class LinkedListApp {

    public static void main(String[] args) {
        Math math = new Math();
        IntegerLinkedList randomIntList = new IntegerLinkedList();
        for (int i = 0; i < 10; i++) {
            randomIntList.add(0 + math.randomInt(10));
        }
        IntegerLinkedList rangeIntList = new IntegerLinkedList();
        for (int i = 0; i < 10; i++) {
            rangeIntList.add(i);
        }
        IntegerLinkedList rangeClosedIntList = new IntegerLinkedList();
        for (int i = 0; i <= 10; i++) {
            rangeClosedIntList.add(i);
        }

        IntegerLinkedListDialog intLinkedListDialog = new IntegerLinkedListDialog("Lista de Enteros");
        IntegerLinkedListLinkedList integerLinkedListLinkedList = new IntegerLinkedListLinkedList();
        for (IntegerLinkedList integerLinkedList : new IntegerLinkedList[] {
                intLinkedListDialog.read(),
                new IntegerLinkedList(new Integer[] { 1, 2, 3 }),
                new IntegerLinkedList(4, 5, 6),
                new IntegerLinkedList(4, 5, 6),
                new IntegerLinkedList(),
                randomIntList,
                rangeIntList,
                rangeClosedIntList,
                intLinkedListDialog.create("{}"),
                intLinkedListDialog.create("{1,2,3}"),
                intLinkedListDialog.create("{-3,-2,-1}"),
                intLinkedListDialog.create("{100,150,200}")
        }) {
            integerLinkedListLinkedList.add(integerLinkedList);
        }
        IntegerLinkedListIterator integerLinkedListIterator = integerLinkedListLinkedList.iterator();
        while (integerLinkedListIterator.hasNext()){
            intLinkedListDialog.writeDetails(integerLinkedListIterator.next());
        }

        DoubleLinkedList randomDoublelist = new DoubleLinkedList();
        for (int i = 0; i < 10; i++) {
            randomDoublelist.add(0 + math.nextDouble(10));
        }
        DoubleLinkedListDialog doubleLinkedListDialog = new DoubleLinkedListDialog("Lista de Decimales");
        DoubleLinkedListLinkedList doubleLinkedListLinkedList = new DoubleLinkedListLinkedList();
        for (DoubleLinkedList doubleLinkedList : new DoubleLinkedList[] {
                doubleLinkedListDialog.read(),
                new DoubleLinkedList(new Double[] { 1.1, 2.2, 3.3 }),
                new DoubleLinkedList(4.4, 5.5, 6.6),
                new DoubleLinkedList(),
                randomDoublelist,
                doubleLinkedListDialog.create("{}"),
                doubleLinkedListDialog.create("{1.1,2.2,3.3}"),
                doubleLinkedListDialog.create("{-3.3,-2.2,-1.1}"),
                doubleLinkedListDialog.create("{100.0,150.0,200.0}")
        }) {
            doubleLinkedListLinkedList.add(doubleLinkedList);
        }
        DoubleLinkedListIterator doubleLinkedListIterator = doubleLinkedListLinkedList.iterator();
        while (doubleLinkedListIterator.hasNext()){
            doubleLinkedListDialog.writeDetails(doubleLinkedListIterator.next());
        }
        Console.close("0");
    }

}
