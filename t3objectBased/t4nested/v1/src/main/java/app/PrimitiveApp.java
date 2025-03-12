package app;

import util.collection.list.LinkedList;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.primitive.DoubleDialog;
import util.view.dialog.primitive.IntDialog;

public class PrimitiveApp {

    public static void main(String[] args) {
        IntDialog intDialog = new IntDialog("Entero");
        LinkedList<Integer> intList = LinkedList.of(
                intDialog.read(),
                0,
                1,
                -1);
        LinkedList<Integer>.Iterator<Integer> intIterator = intList.iterator();
        while (intIterator.hasNext()) {
            intDialog.writeDetails(intIterator.next().element());
        }

        DoubleDialog doubleDialog = new DoubleDialog("Decimal");
        LinkedList<Double> doubleList = LinkedList.of(
                doubleDialog.read(),
                0.0,
                1.1,
                -1.2);
        LinkedList<Double>.Iterator<Double> doubleIterator = doubleList.iterator();
        while (doubleIterator.hasNext()) {
            doubleDialog.writeDetails(doubleIterator.next().element());
        }

        class BooleanDialog {

            private Dialog<Boolean> delegated;

            public BooleanDialog(String title) {
                this.delegated = new Dialog<Boolean>(title, BooleanDialog.regExp());
            }

            public boolean read() {
                return BooleanDialog.create(this.delegated.read());
            }

            public static String regExp() {
                return "true|false";
            }

            public static Boolean create(String string) {
                return Boolean.parseBoolean(string);
            }

            public void writeDetails(Boolean element) {
                this.delegated.addHead(element);
                this.addContent(element);
                this.delegated.writeDetails();
            }

            public void addContent(Boolean logic) {
                this.delegated.addLine("not: " + !logic);
                this.delegated.addLine("and true: " + (logic && true));
                this.delegated.addLine("or false 2: " + (logic || false));

            }

        }
        BooleanDialog booleanDialog = new BooleanDialog("Lógico");
        LinkedList<Boolean> booleanList = LinkedList.of(
            booleanDialog.read(),
                true,
                false);
        LinkedList<Boolean>.Iterator<Boolean> booleanIterator = booleanList.iterator();
        while (booleanIterator.hasNext()) {
            booleanDialog.writeDetails(booleanIterator.next().element());
        }
    }
}
