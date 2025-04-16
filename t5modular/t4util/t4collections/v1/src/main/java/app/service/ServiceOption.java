package app.service;

import java.util.LinkedHashMap;

import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.view.menu.Option;

public abstract class ServiceOption implements Option {

    private LinkedHashMap<Date, Interval<Time>> services;
  
    public ServiceOption(LinkedHashMap<Date, Interval<Time>> services) {
      this.services = services;
    }
  
    public LinkedHashMap<Date, Interval<Time>> getTarget() {
      return this.services;
    }
  
  }
  
