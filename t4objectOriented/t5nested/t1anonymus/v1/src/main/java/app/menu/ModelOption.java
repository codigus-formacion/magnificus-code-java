package app.menu;

import util.view.menu.Option;

public abstract class ModelOption implements Option {

  private String title;
  private Model model;

  public ModelOption(String title, Model model) {
    this.title = title;
    this.model = model;
  }

  public Model getTarget() {
    return this.model;
  }

  public String getTitle() {
    return this.title;
  }

}
