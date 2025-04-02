package app.dialog;

import util.collection.Collection;
import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.Date;
import util.values.Time;
import util.view.dialog.primitive.Console;
import util.view.dialog.primitive.Dialog;
import util.view.dialog.values.DateDialog;
import util.view.dialog.values.TimeDialog;

public class TimeApp {

        public static void main(String[] args) {
                TimeApp.writeDetails(
                                new TimeDialog("Hora"),
                                LinkedList.of(
                                                // new TimeDialog().read(),
                                                new Time(0, 0, 0),
                                                new Time(23, 59, 59),
                                                new TimeDialog().create("0:0:0"),
                                                new TimeDialog().create("23:59:59")));
                                                
                TimeApp.writeDetails(
                        new DateDialog("Fecha"),
                        LinkedList.of(
                                // new DateDialog().read(),
                                new Date(2025, 1, 1),
                                new Date(2025, 12, 30),
                                new DateDialog().create("2025/1/1"),
                                new DateDialog().create("2025/02/27")));
                Console.close("0");
        }

        private static <T> void writeDetails(Dialog<T> dialog, Collection<T> collection) {
                Iterator<T> iterator = collection.iterator();
                while (iterator.hasNext()) {
                        dialog.writeDetails(iterator.next());
                }
        }

}
