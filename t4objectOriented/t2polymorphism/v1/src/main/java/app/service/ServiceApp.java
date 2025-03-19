package app.service;

import util.collection.list.LinkedList;
import util.collection.map.LinkedMap;
import util.values.Interval;
import util.values.Date;
import util.values.Time;

public class ServiceApp {

  public static void main(String[] args) {
    ServiceDialog serviceDialog = new ServiceDialog("Servicio");
    LinkedList<Service> services = LinkedList.of(
        // (Service) serviceDialog.read(),
        (Service) serviceDialog.create("<1/1/1|[2:2:2,3:3:3]>"),
        new Service(new Date(2, 2, 2),
            new Interval<Time>(
                new Time(3, 3, 3),
                new Time(4, 4, 4))));

    LinkedList<Service>.Iterator<Service> serviceIterator = services.iterator();
    while (serviceIterator.hasNext()) {
      serviceDialog.writeDetails(serviceIterator.next());
    }
    LinkedMap<Date, Interval<Time>> serviceMap = new LinkedMap<Date, Interval<Time>>();
    serviceMap.put(
      new Date(5,5,5), 
      new Interval<Time>(
        new Time(6,0,0),
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
