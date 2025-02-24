package util.values.interval;

import util.Console;

public class IntervalView {

    private final String inputTitle;
    private final String outputTitle;

    public IntervalView(String inputTitle, String outputTitle){
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
    }
    
    public Interval read() {
        Console.instance().writeln(inputTitle);
        double min = Console.instance().readDouble("Mínimo: ");
        double max = Console.instance().readDouble("Máximo: ");
        return new Interval(min, max);
    }

    public void write(Interval interval) {
        Console.instance().write(this.outputTitle + interval);
    }

}
