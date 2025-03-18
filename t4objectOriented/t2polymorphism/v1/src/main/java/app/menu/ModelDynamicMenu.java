package app.menu;

import util.view.menu.DynamicMenu;
import util.view.menu.Option;

class ModelDynamicMenu extends DynamicMenu<Model> {

    public ModelDynamicMenu(Model model) {
        super("Model Dynamic Menu", model);
        this.addOptions();
    }

    class RemoveModelOption extends Option<Model> {

        private int index;

        public RemoveModelOption(Model model, int index) {
            super("Eliminar ", model);
            this.index = index;
        }

        protected String getTitle() {
            return super.getTitle() + ": " + this.getTarget().get(this.index);
        }

        public void interact() {
            this.getTarget().remove(this.index);
        }

    }

    protected void addOptions() {
        for (int i = 0; i < this.getTarget().size(); i++) {
            this.add(new RemoveModelOption(this.getTarget(), i));
        }
    }

}
