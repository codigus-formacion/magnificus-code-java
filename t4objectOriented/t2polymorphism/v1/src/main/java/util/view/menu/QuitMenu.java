package util.view.menu;

public abstract class QuitMenu<T> extends Menu<T> {

    private QuitOption<T> quitOption;

    public QuitMenu(String title, T target) {
        super(title, target);
        this.quitOption = new QuitOption<T>(this.getTarget());
    }

    protected void showTitles() {
        if (!this.hasOption(quitOption)){
            this.add(this.quitOption);
        }
        super.showTitles();
    }

    public boolean isExecutedQuitOption(){
        return quitOption.isExecuted();
    }

}
