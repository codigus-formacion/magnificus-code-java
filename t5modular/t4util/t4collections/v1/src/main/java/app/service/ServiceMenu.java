package app.service;

import util.view.menu.IterativeMenu;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

import util.values.Date;
import util.values.Interval;
import util.values.Time;

public class ServiceMenu extends IterativeMenu {

  public ServiceMenu(LinkedHashMap<Date, Interval<Time>> target) {
    super("Menú de Servicio");
    this.add("Listar", new ServiceOption(target) {

      public void interact() {
        Set<Date> set = this.getTarget().keySet();
        Iterator<Date> iterator = set.iterator();
        while (iterator.hasNext()) {
          Date date = iterator.next();
          new ServiceDialog().writeln(new Service(date, this.getTarget().get(date)));
        }
      }

    });
    this.add("Añadir", new ServiceOption(target) {

      public void interact() {
        ServiceDialog serviceDialog = new ServiceDialog("Servicio");
        Service service = (Service) serviceDialog.read();
        this.getTarget().put(service.getKey(), service.getValue());
      }

    });
    this.add("Menu de Borrado de Servicio", new RemovingServiceMenu(target));
  }

}
