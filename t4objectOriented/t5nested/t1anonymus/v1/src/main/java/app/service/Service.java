package app.service;

import util.values.Date;
import util.values.Interval;
import util.values.Pair;
import util.values.Time;

public class Service  extends Pair<Date, Interval<Time>> {

    public Service(Date date, Interval<Time> interval) {
        super(date, interval);
    }

}
