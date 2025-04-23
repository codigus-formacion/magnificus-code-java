package app.service;

import util.collection.Iterator;
import util.collection.map.LinkedMap;
import util.collection.set.LinkedSet;
import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.view.menu.DynamicMenu;
import util.view.menu.Option;

public class RemovingServiceMenu extends DynamicMenu implements Option {

  private LinkedMap<Date, Interval<Time>> services;

  public RemovingServiceMenu(LinkedMap<Date, Interval<Time>> services) {
    super("Menu de Borrado de Servicio");
    this.services = services;
    this.addOptions();
  }

  protected void addOptions() {
    LinkedSet<Date> dates = this.services.keySet();
    Iterator<Date> iterator = dates.iterator();
    while (iterator.hasNext()) {
      Date date = iterator.next();
      this.add("Eliminar : " + date + ":" + this.services.get(date),
          new ServiceOption(services) {

            public void interact() {
              services.remove(date);
            }

          });
    }
  }

}
