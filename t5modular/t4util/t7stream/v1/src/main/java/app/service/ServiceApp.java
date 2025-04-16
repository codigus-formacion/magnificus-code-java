package app.service;

import util.values.Interval;

import java.util.LinkedHashMap;

import util.values.Date;
import util.values.Time;

public class ServiceApp {

  public static void main(String[] args) {
    LinkedHashMap<Date, Interval<Time>> serviceMap = new LinkedHashMap<Date, Interval<Time>>();
    serviceMap.put(
      new Date(5,5,5), 
      new Interval<Time>(
        new Time(6,6,6),
        new Time(7,7,7)));
    serviceMap.put(
      new Date(6,6,6), 
      new Interval<Time>(
        new Time(7,7,7),
        new Time(8,8,8)));
    serviceMap.put(
      new Date(7,7,7), 
      new Interval<Time>(
        new Time(8,8,8),
        new Time(9,9,9)));
    ServiceMenu serviceMenu = new ServiceMenu(serviceMap);
    serviceMenu.interact();

  }

}
