package app.service;

import util.view.menu.IterativeMenu;
import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.collection.Iterator;
import util.collection.map.LinkedMap;
import util.collection.set.LinkedSet;

public class ServiceMenu extends IterativeMenu<LinkedMap<Date, Interval<Time>>> {

  public ServiceMenu(LinkedMap<Date, Interval<Time>> target) {
    super("Menú de Servicio", target);
    this.add(new ListOption(this.getTarget()));
    this.add(new AddOption(this.getTarget()));
    this.add(new RemoveOption(this.getTarget()));
  }

  class ListOption extends ServiceOption {

    public ListOption(LinkedMap<Date, Interval<Time>> target) {
      super("Listar", target);
    }

    public void interact() {
      LinkedSet<Date> set = this.getTarget().keySet();
      Iterator<Date> iterator = set.iterator();
      while (iterator.hasNext()) {
        Date date = iterator.next();
        new ServiceDialog().writeln(new Service(date, this.getTarget().get(date)));
      }
    }

  }

  class AddOption extends ServiceOption {

    public AddOption(LinkedMap<Date, Interval<Time>> target) {
      super("Añadir", target);
    }

    public void interact() {
      ServiceDialog serviceDialog = new ServiceDialog("Servicio");
      Service service = (Service) serviceDialog.read();
      this.getTarget().put(service.getKey(), service.getValue());
    }

  }

  class RemoveOption extends ServiceOption {

    public RemoveOption(LinkedMap<Date, Interval<Time>> target) {
      super("Borrar", target);
    }

    public void interact() {
      RemovingServiceMenu menu = new RemovingServiceMenu(getTarget());
      menu.interact();
      // DateDialog dateDialog = new DateDialog("Fecha");
      // Date date = dateDialog.read();
      // Interval<Time> interval = this.getTarget().get(date);
      // if (interval == null) {
      //   Console.instance().writeln("No existe");
      // } else {
      //   this.getTarget().remove(date);
      //   dateDialog.writeDetails(date);
      //   TimeIntervalDialog timeIntervalDialog = new TimeIntervalDialog("Eliminado");
      //   timeIntervalDialog.writeDetails(interval);
      // }
    }
  }

}
