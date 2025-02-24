package util.values.interval;

import util.Console;

public class DoubleIntervalView {

    private final String inputTitle;
    private final String outputTitle;

    public DoubleIntervalView(String inputTitle, String outputTitle){
        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
    }
    
    public DoubleInterval read() {
        Console.instance().writeln(inputTitle);
        double min = Console.instance().readDouble("Mínimo: ");
        double max = Console.instance().readDouble("Máximo: ");
        return new DoubleInterval(min, max);
    }

    public void write(DoubleInterval interval) {
        Console.instance().write(this.outputTitle + interval);
    }

}
