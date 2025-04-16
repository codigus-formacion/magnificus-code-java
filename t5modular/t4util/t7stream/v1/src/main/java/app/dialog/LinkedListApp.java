package app.dialog;

import util.view.dialog.collection.list.DoubleListDialog;
import util.view.dialog.collection.list.IntegerListDialog;
import util.view.dialog.primitive.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LinkedListApp {

  public static void main(String[] args) {
    IntegerListDialog intListDialog = new IntegerListDialog("Lista de Enteros");
    App.writeDetails(
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
            intListDialog.create("{}"),
            intListDialog.create("{1,2,3}"),
            intListDialog.create("{-3,-2,-1}"),
            intListDialog.create("{100,150,200}")),
        intListDialog);

    DoubleListDialog doubleListDialog = new DoubleListDialog("Lista de Decimales");
    App.writeDetails(
        Stream.of(
            // doubleLinkedListDialog.read(),
            Arrays.asList(new Double[] { 1.1, 2.2, 3.3 }),
            List.of(4.4, 5.5, 6.6),
            List.of(),
            Stream.generate(() -> new Random().nextDouble(10)).limit(10)
                .collect(Collectors.toList()),
            doubleListDialog.create("{}"),
            doubleListDialog.create("{1.1,2.2,3.3}"),
            doubleListDialog.create("{-3.3,-2.2,-1.1}"),
            doubleListDialog.create("{100.0,150.0,200.0}")),
        doubleListDialog);
    Console.close("0");
  }

}
