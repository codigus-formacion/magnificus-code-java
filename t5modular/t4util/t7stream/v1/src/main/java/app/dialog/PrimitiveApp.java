package app.dialog;

import java.util.stream.Stream;

import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

public class PrimitiveApp {

    public static void main(String[] args) {
        IntDialog intDialog = new IntDialog("Entero");
        App.writeDetails(
            Stream.of(
                // intDialog.read(),
                0,
                1,
                -1),
            intDialog);

        DoubleDialog doubleDialog = new DoubleDialog("Decimal");
        App.writeDetails(
            Stream.of(
                // doubleDialog.read(),
                0.0,
                1.1,
                -1.2),
            doubleDialog);
        Console.close("0");
    }

}
