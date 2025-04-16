package util.values.optional;

import util.Console;

public class IntegerOptionalView extends OptionalView<Integer> {

    public IntegerOptionalView(String inputTitle, String outputTitle) {
        super(inputTitle, outputTitle);
    }

    public Optional<Integer> read() {
        String input;
        boolean valid;
        Console.instance().writeln(this.inputTitle);
        do {
            input = Console.instance().readString("Entero: ");
            valid = input.equals("") || input.matches("//d+");
            if (!valid) {
                Console.instance().writeln("Fallo!!!" + this.outputTitle);
            }
        } while (!valid);
        if (input.equals("")){
            return Optional.empty();
        }
        return Optional.of(Integer.parseInt(input));
    }

    public void writeCharacteristics(Optional<Integer> optional){
        super.writeCharacteristics(optional, Integer.valueOf(0), integer -> integer % 2 == 0);
    }
    
}


