package utils;

public class IntervalView {

    private final String inputTitle;
    private final String outputTitle;

    public IntervalView(String inputTitle, String outputTitle){
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
    }
    
    public Interval read() {
        return Console.instance().read(
                this.inputTitle,
                new Interval(0, 0),
                input -> Interval.parseInterval(input) != null,
                input -> Interval.parseInterval(input));
    }

    public void write(Interval interval) {
        Console.instance().write(this.outputTitle + interval);
    }

}
