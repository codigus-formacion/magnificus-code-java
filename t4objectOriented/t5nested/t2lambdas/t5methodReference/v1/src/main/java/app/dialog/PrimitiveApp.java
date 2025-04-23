package app.dialog;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

public class PrimitiveApp {

    public static void main(String[] args) {
        IntDialog intDialog = new IntDialog("Entero");
        LinkedList.of(
                // intDialog.read(),
                0,
                1,
                -1)
                .forEach(intDialog::writeDetails);

        DoubleDialog doubleDialog = new DoubleDialog("Decimal");
        LinkedList.of(
                // doubleDialog.read(),
                0.0,
                1.1,
                -1.2)
                .forEach(doubleDialog::writeDetails);
            
    }

}
