package app.dialog;

import util.view.dialog.collection.list.DoubleLinkedListDialog;
import util.view.dialog.collection.list.IntegerLinkedListDialog;
import util.view.dialog.primitive.Console;
import util.collection.list.LinkedList;
import util.values.Math;

public class LinkedListApp {

    public static void main(String[] args) {
        IntegerLinkedListDialog intLinkedListDialog = new IntegerLinkedListDialog("Lista de Enteros");
        LinkedList.of(
                // intLinkedListDialog.read(),
                LinkedList.of(new Integer[] { 1, 2, 3 }),
                LinkedList.of(4, 5, 6),
                LinkedList.of(4, 5, 6),
                LinkedList.of(),
                LinkedList.empty(),
                LinkedListApp.getRandomIntList(),
                LinkedListApp.getRangeIntList(),
                LinkedListApp.getRangeClosedIntList(),
                intLinkedListDialog.create("{}"),
                intLinkedListDialog.create("{1,2,3}"),
                intLinkedListDialog.create("{-3,-2,-1}"),
                intLinkedListDialog.create("{100,150,200}"))
                .forEach(element -> {
                    intLinkedListDialog.writeDetails((LinkedList<Integer>) element);
                });

        DoubleLinkedListDialog doubleLinkedListDialog = new DoubleLinkedListDialog("Lista de Decimales");
        LinkedList.of(
                // doubleLinkedListDialog.read(),
                LinkedList.of(new Double[] { 1.1, 2.2, 3.3 }),
                LinkedList.of(4.4, 5.5, 6.6),
                LinkedList.of(),
                LinkedList.empty(),
                LinkedListApp.getRandomDoublelist(),
                doubleLinkedListDialog.create("{}"),
                doubleLinkedListDialog.create("{1.1,2.2,3.3}"),
                doubleLinkedListDialog.create("{-3.3,-2.2,-1.1}"),
                doubleLinkedListDialog.create("{100.0,150.0,200.0}"))
                .forEach(element -> {
                    doubleLinkedListDialog.writeDetails((LinkedList<Double>) element);
                });
        Console.close("0");
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
