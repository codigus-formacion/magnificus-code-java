package util.values.interval;

import util.Console;
import util.values.fraction.Fraction;

public class App {
    
    public static void main(String[] args){
        DoubleIntervalView intervalView = new DoubleIntervalView("Intervalo:", "el mínimo debe ser inferior o igual al máximo!");
        intervalView.writeCharacteristics(intervalView.read());
        intervalView.writeCharacteristics(new DoubleInterval(-1,1));
        intervalView.writeCharacteristics(new DoubleInterval(0,0));
        intervalView.writeCharacteristics(DoubleInterval.parse("[100,200]"));

        FractionIntervalView fractionIntervalView = new FractionIntervalView("Intervalo", "el denominador debe ser positivo");
        fractionIntervalView.writeCharacteristics(fractionIntervalView.read());
        fractionIntervalView.writeCharacteristics(new FractionInterval(new Fraction(-1),new Fraction(1)));
        fractionIntervalView.writeCharacteristics(new FractionInterval(new Fraction(0),new Fraction(0)));
        fractionIntervalView.writeCharacteristics(FractionIntervalView.parse("[1/2, 2/3]"));

        Console.close("0");
    }

}
