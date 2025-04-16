package app.dialog;

import java.util.stream.Stream;

import util.values.Date;
import util.values.Time;
import util.view.dialog.primitive.Console;
import util.view.dialog.values.DateDialog;
import util.view.dialog.values.TimeDialog;

public class TimeApp {

        public static void main(String[] args) {
                TimeDialog timeDialog = new TimeDialog("Hora");
                PrimitiveApp.writeDetails(
                        Stream.of(
                                // timeDialog.read(),
                                new Time(0, 0, 0),
                                new Time(23, 59, 59),
                                timeDialog.create("0:0:0"),
                                timeDialog.create("23:59:59")),
                        timeDialog);
                DateDialog dateDialog = new DateDialog("Fecha");
                PrimitiveApp.writeDetails(
                        Stream.of(
                                dateDialog.read(),
                                new Date(2025, 1, 1),
                                new Date(2025, 12, 30),
                                dateDialog.create("2025/1/1"),
                                dateDialog.create("2025/02/27")),
                        dateDialog);
                Console.close("0");
        }

}
