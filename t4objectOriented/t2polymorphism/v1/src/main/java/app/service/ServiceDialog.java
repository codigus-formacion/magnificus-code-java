package app.service;

import util.collection.list.LinkedList;
import util.values.Date;
import util.values.Interval;
import util.values.Pair;
import util.values.Time;
import util.view.dialog.values.DateDialog;
import util.view.dialog.values.PairDialog;
import util.view.dialog.values.TimeIntervalDialog;

public class ServiceDialog extends PairDialog<Date, Interval<Time>> {

    public ServiceDialog(String title) {
        super(title, new DateDialog().regExp(), new TimeIntervalDialog().regExp());
    }

    public ServiceDialog(){
        this("");
    }

    public Pair<Date, Interval<Time>> create(String input) {
        LinkedList<String> strings = this.strings(input);
        return new Service(
            new DateDialog().create(strings.get(0)),
            new TimeIntervalDialog().create(strings.get(1)));
    }
    
    protected void addContent(Pair<Date, Interval<Time>> element) {
        Service service = (Service) element;
        this.addLine("Fecha: " + service.getKey());
        this.addLine("Intervalo de Horas: " + service.getValue());
    }

}
