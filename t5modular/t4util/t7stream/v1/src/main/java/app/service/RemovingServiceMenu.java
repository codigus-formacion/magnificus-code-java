package app.service;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

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
    Set<Date> dates = this.services.keySet();
    Iterator<Date> iterator = dates.iterator();
    while (iterator.hasNext()) {
      Date date = iterator.next();
      this.add("Eliminar : " + date + ":" + this.services.get(date),
          () -> {
            services.remove(date);
          });
    }
  }

}
