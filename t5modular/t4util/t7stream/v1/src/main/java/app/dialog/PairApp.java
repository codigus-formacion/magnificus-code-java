package app.dialog;

import java.util.List;

import util.values.DoubleInterval;
import util.values.Pair;
import util.values.Time;
import util.view.dialog.collection.list.TimeListDialog;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.TimeDialog;

public class PairApp {

  public static void main(String[] args) {
    Pair<DoubleInterval, List<Time>> pair = 
      new Pair<DoubleInterval, List<Time>>(
          new DoubleIntervalDialog().create("[1.1,2.2]"),
          List.of(
              new TimeDialog().create("1:1:1"),
              new TimeDialog().create("2:2:52"),
              new TimeDialog().create("3:3:53")));
    new DoubleIntervalDialog("Intervalo de decimales").writeDetails(pair.getKey());
    new TimeListDialog("Listado de horas").writeDetails(pair.getValue());
  }

}
