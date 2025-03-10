package app.values;

import util.collection.list.DateLinkedList;
import util.collection.list.TimeLinkedList;
import util.collection.list.iterator.DateIterator;
import util.collection.list.iterator.TimeIterator;
import util.values.Date;
import util.values.Time;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.DateDialog;
import util.view.dialog.values.TimeDialog;

public class TimeApp {

        public static void main(String[] args) {
                TimeDialog timeDialog = new TimeDialog("Hora");
                TimeLinkedList timeList = TimeLinkedList.of(
                                timeDialog.read(),
                                new Time(0, 0, 0),
                                new Time(23, 59, 59),
                                TimeDialog.create("0:0:0"),
                                TimeDialog.create("23:59:59"));
                TimeIterator timeIterator = timeList.iterator();
                while (timeIterator.hasNext()) {
                        timeDialog.writeDetails(timeIterator.next().element());
                }
                DateDialog dateDialog = new DateDialog("Fecha");
                DateLinkedList dateList = DateLinkedList.of(
                                dateDialog.read(),
                                new Date(2025, 1, 1),
                                new Date(2025, 12, 30),
                                DateDialog.create("2025/1/1"),
                                DateDialog.create("2025/02/27"));
                DateIterator dateIterator = dateList.iterator();
                while (dateIterator.hasNext()) {
                        dateDialog.writeDetails(dateIterator.next().element());
                }
                Console.close("0");
        }

}
