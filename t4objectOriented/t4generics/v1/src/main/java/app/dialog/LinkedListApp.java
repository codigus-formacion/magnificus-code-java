package app.dialog;

import util.view.dialog.collection.list.DoubleLinkedListDialog;
import util.view.dialog.collection.list.IntegerLinkedListDialog;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.Dialog;
import util.collection.Collection;
import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.Math;

public class LinkedListApp {

    public static void main(String[] args) {
        LinkedListApp.writeDetails(
                new IntegerLinkedListDialog("Lista de Enteros"),
                LinkedList.of(
                        // new IntegerLinkedListDialog().read(),
                        LinkedList.of(new Integer[] { 1, 2, 3 }),
                        LinkedList.of(4, 5, 6),
                        LinkedList.of(4, 5, 6),
                        LinkedList.of(),
                        LinkedList.empty(),
                        LinkedListApp.getRandomIntList(),
                        LinkedListApp.getRangeIntList(),
                        LinkedListApp.getRangeClosedIntList(),
                        new IntegerLinkedListDialog().create("{}"),
                        new IntegerLinkedListDialog().create("{1,2,3}"),
                        new IntegerLinkedListDialog().create("{-3,-2,-1}"),
                        new IntegerLinkedListDialog().create("{100,150,200}")));

        LinkedListApp.writeDetails(
                new DoubleLinkedListDialog("Lista de Decimales"),
                LinkedList.of(
                        // new DoubleLinkedListDialog().read(),
                        LinkedList.of(new Double[] { 1.1, 2.2, 3.3 }),
                        LinkedList.of(4.4, 5.5, 6.6),
                        LinkedList.of(),
                        LinkedList.empty(),
                        LinkedListApp.getRandomDoublelist(),
                        new DoubleLinkedListDialog().create("{}"),
                        new DoubleLinkedListDialog().create("{1.1,2.2,3.3}"),
                        new DoubleLinkedListDialog().create("{-3.3,-2.2,-1.1}"),
                        new DoubleLinkedListDialog().create("{100.0,150.0,200.0}")));
        Console.close("0");
    }

    private static <T> void writeDetails(Dialog<T> dialog, Collection<T> collection) {
        Iterator<T> iterator = collection.iterator();
        while (iterator.hasNext()) {
            dialog.writeDetails(iterator.next());
        }
    }

    private static LinkedList<Integer> getRandomIntList() {
        LinkedList<Integer> randomIntList = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            randomIntList.add(0 + Math.randomInt(10));
        }
        return randomIntList;
    }

    private static LinkedList<Integer> getRangeIntList() {
        LinkedList<Integer> rangeIntList = new LinkedList<Integer>();
        for (int i = 0; i < 10; i++) {
            rangeIntList.add(i);
        }
        return rangeIntList;
    }

    private static LinkedList<Integer> getRangeClosedIntList() {
        LinkedList<Integer> rangeClosedIntList = new LinkedList<Integer>();
        for (int i = 0; i <= 10; i++) {
            rangeClosedIntList.add(i);
        }
        return rangeClosedIntList;
    }

    private static LinkedList<Double> getRandomDoublelist() {
        LinkedList<Double> randomDoublelist = new LinkedList<Double>();
        for (int i = 0; i < 10; i++) {
            randomDoublelist.add(0 + Math.nextDouble(10));
        }
        return randomDoublelist;
    }

}
