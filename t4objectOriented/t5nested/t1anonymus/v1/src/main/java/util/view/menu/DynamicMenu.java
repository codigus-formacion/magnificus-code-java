package util.view.menu;

public abstract class DynamicMenu<T>  {

    private IterativeMenu<T> delegated;

    public DynamicMenu(String title, T target) {
        this.delegated = new IterativeMenu<T>(title, target);
    }

    public void add(Option option) {
        this.delegated.add(option);
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

    public T getTarget(){
        return this.delegated.getTarget();
    }

}
