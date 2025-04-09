package app.service;

import util.collection.Iterator;
import util.collection.map.LinkedMap;
import util.collection.set.LinkedSet;
import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.view.menu.DynamicMenu;
import util.view.menu.Option;

public class RemovingServiceMenu extends DynamicMenu<LinkedMap<Date, Interval<Time>>> implements Option {

  public RemovingServiceMenu(LinkedMap<Date, Interval<Time>> services) {
    super("Menu de Borrado de Servicio", services);
    this.addOptions();
  }

  protected void addOptions() {
    LinkedSet<Date> dates = this.getTarget().keySet();
    Iterator<Date> iterator = dates.iterator();
    while (iterator.hasNext()) {
      Date date = iterator.next();
      this.add(new ServiceOption("Eliminar ", getTarget()) {

        public String getTitle() {
          return super.getTitle() + ": " + date + ":" +
              this.getTarget().get(date);
        }

        public void interact() {
          this.getTarget().remove(date);
        }

      });
    }
  }

  @Override
  public String getTitle() {
    return "Borrar";
  }

}
