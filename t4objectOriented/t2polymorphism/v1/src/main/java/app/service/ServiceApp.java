package app.service;

import util.collection.list.LinkedList;
import util.values.Interval;
import util.values.Date;
import util.values.Time;

public class ServiceApp {

  public static void main(String[] args) {
    ServiceDialog serviceDialog = new ServiceDialog("Servicio");
    LinkedList<Service> services = LinkedList.of(
        (Service) serviceDialog.read(),
        (Service) serviceDialog.create("<1/1/1|[2:2:2,3:3:3]>"),
        new Service(new Date(1, 1, 1),
            new Interval<Time>(
                new Time(0, 0, 0),
                new Time(2, 2, 2))));

    LinkedList<Service>.Iterator<Service> serviceIterator = services.iterator();
    while (serviceIterator.hasNext()) {
      serviceDialog.writeDetails(serviceIterator.next());
    }
  }
}
