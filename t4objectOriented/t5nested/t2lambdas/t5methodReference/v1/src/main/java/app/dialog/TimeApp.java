package app.dialog;

import util.collection.Iterator;
import util.collection.list.LinkedList;
import util.values.Date;
import util.values.Time;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.DateDialog;
import util.view.dialog.values.TimeDialog;

public class TimeApp {

        public static void main(String[] args) {
                TimeDialog timeDialog = new TimeDialog("Hora");
                LinkedList.of(
                                // timeDialog.read(),
                                new Time(0, 0, 0),
                                new Time(23, 59, 59),
                                timeDialog.create("0:0:0"),
                                timeDialog.create("23:59:59"))
                                .forEach(timeDialog::writeDetails);
                DateDialog dateDialog = new DateDialog("Fecha");
                LinkedList.of(
                                dateDialog.read(),
                                new Date(2025, 1, 1),
                                new Date(2025, 12, 30),
                                dateDialog.create("2025/1/1"),
                                dateDialog.create("2025/02/27"))
                                .forEach(dateDialog::writeDetails);
                Console.close("0");
        }

}
