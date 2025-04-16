package util.view.menu;

public abstract class DynamicMenu extends IterativeMenu  {

    public DynamicMenu(String title) {
        super(title);
    }

    public void interact() {
        do {
            this.removeOptions();
            this.addOptions();
            this.showTitles();
            this.execChoosedOption();
        } while (!this.isExecutedQuitOption());
    }

    protected abstract void addOptions();

}
