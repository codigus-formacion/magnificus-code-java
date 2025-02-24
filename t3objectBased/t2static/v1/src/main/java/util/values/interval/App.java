package util.values.interval;

import util.Console;

public class App {
    
    public static void main(String[] args){
        IntervalView intervalView = new IntervalView("Intervalo:", "el mínimo debe ser inferior o igual al máximo!");
        intervalView.writeCharacteristics(intervalView.read());
        intervalView.writeCharacteristics(new Interval(-1,1));
        intervalView.writeCharacteristics(new Interval(0,0));
        intervalView.writeCharacteristics(Interval.parse("[100,200]"));
        Console.close("0");
    }

}
