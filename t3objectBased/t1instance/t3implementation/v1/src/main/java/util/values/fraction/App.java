package util.values.fraction;

import util.Console;

public class App {
    
    public static void main(String[] args){
        FractionView intervalView = new FractionView("Intervalo:", "el mínimo debe ser inferior o igual al máximo!");
        intervalView.writeCharacteristics(intervalView.read());
        intervalView.writeCharacteristics(new Fraction(2,3));
        intervalView.writeCharacteristics(new Fraction(-1));
        intervalView.writeCharacteristics(new Fraction());
        Console.close("0");
    }


}