package app.menu;

import util.view.menu.Option;

public abstract class ModelOption implements Option {

  private Model model;

  public ModelOption(Model model) {
    this.model = model;
  }

  public Model getTarget() {
    return this.model;
  }

}
