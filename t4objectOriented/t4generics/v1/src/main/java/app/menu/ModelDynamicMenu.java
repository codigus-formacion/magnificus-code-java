package app.menu;

import util.view.menu.DynamicMenu;

class ModelDynamicMenu extends DynamicMenu<Model> {

    public ModelDynamicMenu(Model model) {
        super("Model Dynamic Menu", model);
        this.addOptions();
    }

    class RemoveModelOption extends ModelOption {

        private int index;

        public RemoveModelOption(Model model, int index) {
            super("Eliminar", model);
            this.index = index;
        }

        public String getTitle() {
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
