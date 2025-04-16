package app.dialog;

import util.view.dialog.collection.list.DoubleLinkedListDialog;
import util.view.dialog.collection.list.IntegerLinkedListDialog;
import util.view.dialog.primitive.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinkedListApp {

    public static void main(String[] args) {
        IntegerLinkedListDialog intLinkedListDialog = new IntegerLinkedListDialog("Lista de Enteros");
        PrimitiveApp.writeDetails(
                Stream.of(
                        // intLinkedListDialog.read(),
                        Arrays.asList(new Integer[] { 1, 2, 3 }),
                        List.of(4, 5, 6),
                        List.of(4, 5, 6),
                        List.of(),
                        Stream.generate(() -> new Random().nextInt(10)).limit(10).toList(),
                        IntStream.range(0, 10).boxed()
                                .collect(Collectors.toList()),
                        IntStream.rangeClosed(0, 10).boxed()
                                .collect(Collectors.toList()),
                        intLinkedListDialog.create("{}"),
                        intLinkedListDialog.create("{1,2,3}"),
                        intLinkedListDialog.create("{-3,-2,-1}"),
                        intLinkedListDialog.create("{100,150,200}")),
                intLinkedListDialog);

        // DoubleLinkedListDialog doubleLinkedListDialog = new DoubleLinkedListDialog("Lista de Decimales");
        // PrimitiveApp.writeDetails(
        //     Stream.of(
        //         // doubleLinkedListDialog.read(),
        //         Arrays.asList(new Double[] { 1.1, 2.2, 3.3 }),
        //         List.of(4.4, 5.5, 6.6),
        //         List.of(),
        //         Stream.generate(() -> new Random().nextDouble(10)).limit(10)
        //                 .collect(Collectors.toList()),
        //         doubleLinkedListDialog.create("{}"),
        //         doubleLinkedListDialog.create("{1.1,2.2,3.3}"),
        //         doubleLinkedListDialog.create("{-3.3,-2.2,-1.1}"),
        //         doubleLinkedListDialog.create("{100.0,150.0,200.0}")),
        //     doubleLinkedListDialog);
        Console.close("0");
    }

}
