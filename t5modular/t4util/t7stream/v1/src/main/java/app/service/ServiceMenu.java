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
    this.add("Listar", () -> {
      Set<Date> set = target.keySet();
      Iterator<Date> iterator = set.iterator();
      while (iterator.hasNext()) {
        Date date = iterator.next();
        new ServiceDialog().writeln(new Service(date, target.get(date)));
      }
    });
    this.add("Añadir", () -> {
      ServiceDialog serviceDialog = new ServiceDialog("Servicio");
      Service service = (Service) serviceDialog.read();
      target.put(service.getKey(), service.getValue());
    });
    this.add("Menu de Borrado de Servicio", new RemovingServiceMenu(target));
  }

}
