package app.menu;

import util.view.menu.DynamicMenu;
import util.view.menu.Option;

class ModelDynamicMenu extends DynamicMenu<Model> implements Option {

    public ModelDynamicMenu(Model model) {
        super("Eliminar", model);
        this.addOptions();
    }

    protected void addOptions() {
        for (int i = 0; i < this.getTarget().size(); i++) {
            final int index = i;
            this.add(new ModelOption("Eliminar", this.getTarget()) {


                public String getTitle() {
                    return super.getTitle() + ": " + this.getTarget().get(index);
                }
        
                public void interact() {
                    this.getTarget().remove(index);
                }
        
            });
        }
    }
    
    public String getTitle() {
        return "Eliminar";
    }

}
