package app.service;

import util.view.menu.IterativeMenu;

import java.util.LinkedHashMap;

import util.values.Date;
import util.values.Interval;
import util.values.Time;

public class ServiceMenu extends IterativeMenu {

  public ServiceMenu(LinkedHashMap<Date, Interval<Time>> target) {
    super("Menú de Servicio");
    this.add("Listar", () -> {
      target.forEach((date, interval) -> 
        new ServiceDialog().writeln(new Service(date, interval))
      );
    });
    this.add("Añadir", () -> {
      ServiceDialog serviceDialog = new ServiceDialog("Servicio");
      Service service = (Service) serviceDialog.read();
      target.put(service.getKey(), service.getValue());
    });
    this.add("Menu de Borrado de Servicio", new RemovingServiceMenu(target));
  }

}
