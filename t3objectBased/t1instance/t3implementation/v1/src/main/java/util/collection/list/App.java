package util.collection.list;

import java.util.Random;

import util.view.Console;
import util.view.dialog.collection.list.DoubleLinkedListDialog;
import util.view.dialog.collection.list.IntegerLinkedListDialog;

public class App {

    public static void main(String[] args) {
        IntegerLinkedListDialog intLinkedListDialog = new IntegerLinkedListDialog("Lista de Enteros");
        // intLinkedListDialog.writeDetails(intLinkedListDialog.read());
        intLinkedListDialog.writeDetails(new IntegerLinkedList(new Integer[] { 1, 2, 3 }));
        intLinkedListDialog.writeDetails(new IntegerLinkedList(4, 5, 6));
        intLinkedListDialog.writeDetails(new IntegerLinkedList(4, 5, 6));
        intLinkedListDialog.writeDetails(new IntegerLinkedList());
        intLinkedListDialog.writeDetails(IntegerLinkedList.of(7, 8, 9, 10, 11));
        intLinkedListDialog.writeDetails(App.generateInts(0,10,10));
        intLinkedListDialog.writeDetails(App.range(0, 10));
        intLinkedListDialog.writeDetails(App.rangeClosed(0, 10));
        intLinkedListDialog.writeDetails(intLinkedListDialog.of("{}"));
        intLinkedListDialog.writeDetails(intLinkedListDialog.of("{1,2,3}"));
        intLinkedListDialog.writeDetails(intLinkedListDialog.of("{-3,-2,-1}"));
        intLinkedListDialog.writeDetails(intLinkedListDialog.of("{100,150,200}"));
        intLinkedListDialog.writeDetails(new IntegerLinkedList(new Integer[] { 1, 2, 3 }));
        
        DoubleLinkedListDialog doubleLinkedListDialog = new DoubleLinkedListDialog("Lista de Decimales");
        // doubleLinkedListDialog.writeDetails(doubleLinkedListDialog.read());
        doubleLinkedListDialog.writeDetails(new DoubleLinkedList(new Double[] { 1.1, 2.2, 3.3 }));
        doubleLinkedListDialog.writeDetails(new DoubleLinkedList(4.4, 5.5, 6.6));
        doubleLinkedListDialog.writeDetails(new DoubleLinkedList());
        doubleLinkedListDialog.writeDetails(DoubleLinkedList.of(7.7, 8.8, 9.9, 10.10, 11.11));
        doubleLinkedListDialog.writeDetails(DoubleLinkedList.empty());
        doubleLinkedListDialog.writeDetails(App.generateDoubles(0.0, 10.0, 10));
        doubleLinkedListDialog.writeDetails(doubleLinkedListDialog.of("{}"));
        doubleLinkedListDialog.writeDetails(doubleLinkedListDialog.of("{1.1,2.2,3.3}"));
        doubleLinkedListDialog.writeDetails(doubleLinkedListDialog.of("{-3.3,-2.2,-1.1}"));
        doubleLinkedListDialog.writeDetails(doubleLinkedListDialog.of("{100.0,150.0,200.0}"));
        Console.close("0");
    }

    private static IntegerLinkedList rangeClosed(int begin, int end) {
        return App.range(begin, end + 1);
    }

    private static IntegerLinkedList range(int begin, int end) {
        IntegerLinkedList list = new IntegerLinkedList();
        for (int i = begin; i < end; i++) {
            list.add(i);
        }
        return list;
    }

    private static IntegerLinkedList generateInts(int begin, int end, int amount) {
        IntegerLinkedList list = new IntegerLinkedList();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            list.add(begin + random.nextInt(end - begin));
        }
        return list;
    }

    private static DoubleLinkedList generateDoubles(double begin, double end, int amount) {
        DoubleLinkedList list = new DoubleLinkedList();
        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            list.add(begin + random.nextDouble(end - begin));
        }
        return list;
    }

}
