package app.menu;

import util.view.menu.DynamicMenu;
import util.view.menu.Option;

class ModelDynamicMenu extends DynamicMenu implements Option {

    private Model model;

    public ModelDynamicMenu(Model model) {
        super("Eliminar");
        this.model = model;
        this.addOptions();
    }

    protected void addOptions() {
        for (int i = 0; i < this.model.size(); i++) {
            final int index = i;
            this.add("Eliminar: " + this.model.get(index), new ModelOption(this.model) {
        
                public void interact() {
                    this.getTarget().remove(index);
                }
        
            });
        }
    }

}
