package app.service;

import util.collection.list.LinkedList;
import util.collection.map.LinkedMap;
import util.collection.set.LinkedSet;
import util.values.Date;
import util.values.Interval;
import util.values.Time;
import util.view.menu.DynamicMenu;
import util.view.menu.Option;

public class RemovingServiceMenu extends DynamicMenu<LinkedMap<Date, Interval<Time>>> {

  public RemovingServiceMenu(LinkedMap<Date, Interval<Time>> services) {
      super("Menu de Borrado de Servicio", services);
      this.addOptions();
  }

  class RemoveModelOption extends Option<LinkedMap<Date, Interval<Time>>> {

      private Date date;

      public RemoveModelOption(LinkedMap<Date, Interval<Time>> services, Date date) {
          super("Eliminar ", services);
          this.date = date;
      }

      protected String getTitle() {
          return super.getTitle() + ": " + this.date + ":" + 
            this.getTarget().get(this.date);
      }

      public void interact() {
          this.getTarget().remove(this.date);
      }

  }

  protected void addOptions() {
    LinkedSet<Date> dates =  this.getTarget().keySet();
    LinkedList<Date>.Iterator<Date> iterator = dates.iterator();
    while (iterator.hasNext()){
      this.add(new RemoveModelOption(this.getTarget(), iterator.next()));
    }
  }
// edmundo parra n2, placa Marina Modista 1ºJ


}
