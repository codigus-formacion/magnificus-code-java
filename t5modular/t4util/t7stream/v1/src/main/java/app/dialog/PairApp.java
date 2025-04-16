package app.dialog;

import java.util.LinkedList;

import util.values.DoubleInterval;
import util.values.Pair;
import util.values.Time;
import util.view.dialog.collection.list.TimeLinkedListDialog;
import util.view.dialog.values.DoubleIntervalDialog;
import util.view.dialog.values.TimeDialog;

public class PairApp {
  
  public static void main(String[] args){
        LinkedList<Time> times = new LinkedList<Time>();
        for(Time time : new Time[]{
            new TimeDialog().create("1:1:1"),
            new TimeDialog().create("2:2:52"),
            new TimeDialog().create("3:3:53")
        }) {
            times.add(time);
        };
        Pair<DoubleInterval, LinkedList<Time>> pair = 
            new Pair<DoubleInterval, LinkedList<Time>>(
                new DoubleIntervalDialog().create("[1.1,2.2]"), 
                times);
        new DoubleIntervalDialog("Intervalo de decimales")
            .writeDetails(pair.getKey());
        new TimeLinkedListDialog("Listado de horas")
            .writeDetails(pair.getValue());
    }

}
