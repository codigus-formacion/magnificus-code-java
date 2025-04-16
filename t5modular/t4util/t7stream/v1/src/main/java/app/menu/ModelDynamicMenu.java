package app.menu;

import java.util.stream.IntStream;

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
        IntStream.range(0, this.model.size())
            .forEach(index -> this.add("Eliminar: " + this.model.get(index), () -> this.model.remove(index)));
    }

}
