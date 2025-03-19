package app.service;

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

public class ServiceMenu extends IterativeMenu<LinkedMap<Date,Interval<Time>>> {

  public ServiceMenu(LinkedMap<Date, Interval<Time>> target) {
      super("", target);
    }
  
  protected void addOptions() {
    this.add(new Option<LinkedMap<Date, Interval<Time>>>("Listar", this.getTarget()){

      public void interact() {
        LinkedSet<Date> set = this.getTarget().keySet();
        LinkedList<Date>.Iterator<Date> iterator = set.iterator();
        while (iterator.hasNext()){
          Date date = iterator.next();
          new ServiceDialog("Fecha").write(
            new Service(date, this.getTarget().get(date)));
        }
      }
      
    });
  }
  
}
