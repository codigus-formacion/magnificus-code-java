package app.service;

import util.collection.map.LinkedMap;
import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.view.menu.Option;

public abstract class ServiceOption implements Option {

    private String title;
    private LinkedMap<Date, Interval<Time>> services;
  
    public ServiceOption(String title, LinkedMap<Date, Interval<Time>> services) {
      this.title = title;
      this.services = services;
    }
  
    public LinkedMap<Date, Interval<Time>> getTarget() {
      return this.services;
    }
  
    public String getTitle() {
      return this.title;
    }
  
  }
  
