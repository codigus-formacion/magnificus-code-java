package app.service;

import java.util.LinkedHashMap;

import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.view.menu.DynamicMenu;
import util.view.menu.Option;

public class RemovingServiceMenu extends DynamicMenu implements Option {

  private LinkedHashMap<Date, Interval<Time>> services;

  public RemovingServiceMenu(LinkedHashMap<Date, Interval<Time>> services) {
    super("Menu de Borrado de Servicio");
    this.services = services;
    this.addOptions();
  }

  protected void addOptions() {
    this.services.forEach((date, interval) -> 
      this.add("Eliminar : " + date + ":" + interval, 
          () -> services.remove(date))
    );
  }

}
