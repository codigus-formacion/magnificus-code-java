package app.service;

import util.view.dialog.primitive.Console;
import util.view.dialog.values.DateDialog;
import util.view.dialog.values.TimeIntervalDialog;
import util.view.menu.IterativeMenu;
import util.view.menu.Option;
import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.collection.list.LinkedList;
import util.collection.map.LinkedMap;
import util.collection.set.LinkedSet;

public class ServiceMenu extends IterativeMenu<LinkedMap<Date, Interval<Time>>> {

  public ServiceMenu(LinkedMap<Date, Interval<Time>> target) {
    super("", target);
  }

  protected void addOptions() {
    this.add(new Option<LinkedMap<Date, Interval<Time>>>("Listar", this.getTarget()) {

      public void interact() {
        LinkedSet<Date> set = this.getTarget().keySet();
        LinkedList<Date>.Iterator<Date> iterator = set.iterator();
        while (iterator.hasNext()) {
          Date date = iterator.next();
          new ServiceDialog().writeln(new Service(date, this.getTarget().get(date)));
        }
      }

    });
    this.add(new Option<LinkedMap<Date, Interval<Time>>>("Añadir", this.getTarget()) {

      public void interact() {
        ServiceDialog serviceDialog = new ServiceDialog("Servicio");
        Service service = (Service) serviceDialog.read();
        this.getTarget().put(service.getKey(), service.getValue());
      }

    });
    this.add(new Option<LinkedMap<Date, Interval<Time>>>("Borrar", this.getTarget()) {

      public void interact() {
        DateDialog dateDialog = new DateDialog("Fecha");
        Date date = dateDialog.read();
        Interval<Time> interval = this.getTarget().get(date);
        if (interval == null) {
          Console.instance().writeln("No existe");
        } else {
          this.getTarget().remove(date);
          dateDialog.writeDetails(date);
          TimeIntervalDialog timeIntervalDialog = new TimeIntervalDialog("Eliminado");
          timeIntervalDialog.writeDetails(interval);
        }
      }

    });
  }

}
