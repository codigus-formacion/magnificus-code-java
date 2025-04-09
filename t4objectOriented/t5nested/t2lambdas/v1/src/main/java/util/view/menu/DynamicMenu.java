package util.view.menu;

public abstract class DynamicMenu  {

    private IterativeMenu delegated;

    public DynamicMenu(String title) {
        this.delegated = new IterativeMenu(title);
    }

    public void add(String subtitle, Option option) {
        this.delegated.add(subtitle, option);
    }

    public void interact() {
        do {
            this.delegated.removeOptions();
            this.addOptions();
            this.delegated.showTitles();
            this.delegated.execChoosedOption();
        } while (!this.delegated.isExecutedQuitOption());
    }

    protected abstract void addOptions();

}
