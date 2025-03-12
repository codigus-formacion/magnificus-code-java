package app;

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
                TimeLinkedList timeList = new TimeLinkedList();
                for (Time time : new Time[] {
                                timeDialog.read(),
                                new Time(0, 0, 0),
                                new Time(23, 59, 59),
                                timeDialog.create("0:0:0"),
                                timeDialog.create("23:59:59")
                }) {
                        timeList.add(time);
                }
                TimeIterator timeIterator = timeList.iterator();
                while (timeIterator.hasNext()) {
                        timeDialog.writeDetails(timeIterator.next());
                }
                DateDialog dateDialog = new DateDialog("Fecha");
                DateLinkedList dateList = new DateLinkedList();
                for (Date date : new Date[] {
                                dateDialog.read(),
                                new Date(2025, 1, 1),
                                new Date(2025, 12, 30),
                                dateDialog.create("2025/1/1"),
                                dateDialog.create("2025/02/27")
                }) {
                        dateList.add(date);
                }
                DateIterator dateIterator = dateList.iterator();
                while (dateIterator.hasNext()) {
                        dateDialog.writeDetails(dateIterator.next());
                }
                Console.close("0");
        }

}
