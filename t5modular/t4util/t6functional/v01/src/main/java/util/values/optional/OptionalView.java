package util.values.optional;

import java.util.function.Predicate;

import util.Console;

public abstract class OptionalView<T> {

    protected final String inputTitle;
    protected final String outputTitle;

    public OptionalView(String inputTitle, String outputTitle) {
        assert inputTitle != null;
        assert outputTitle != null;

        this.inputTitle = inputTitle;
        this.outputTitle = outputTitle;
    }

    public abstract Optional<T> read();

    public void write(Optional<T> value) {
        Console.instance().write(value);
    }

    public void writeln(Optional<T> value) {
        this.write(value);
        Console.instance().writeln();
    }
    
    protected void writeCharacteristics(Optional<T> optional, T initial, Predicate<T> predicate) {
        StringBuffer string = new StringBuffer("---------");
        string.append("\ntoString: " + optional.toString());
        string.append("\nEs null? " + optional.equals(Optional.empty()));
        string.append("\nEs 1 presente? " + optional.equals(Optional.of(1)));
        if (optional.isPresent()) {
            string.append("\nPresente: " + optional.get());
        }
        if (optional.isEmpty()) {
            string.append("\nVacío!");
        }
        Console.instance().writeln("Defecto: " + optional.orElse(initial));
        try {
            string.append("\nExcepcional? " + optional.orElseThrow());
        } catch (Exception e) {
            e.printStackTrace();
        }
        optional.ifPresent(value -> {
            string.append("\nget" + optional.get());
        });
        optional.ifPresentOrElse(value -> {
            string.append("\n" + optional.get());
        }, () -> {
            string.append("\nVacío");
        });
        string.append("\nLo que sea: " + optional.orElseGet(() -> initial));
        string.append("\nDefecto: " + optional.or(() -> Optional.of(initial)));
        try {
            string.append("\nLo que sea: " + optional.orElseThrow(() -> new Exception("Excepcional!!!")));
        } catch (Exception e) {
            string.append("\nVacío");
        }
        optional.filter(predicate)
                .ifPresent(value -> {
                    string.append("\nPar: " + value);
                });
        if (optional.isPresent()) {
            string.append("\nDouble: " + optional.map(value -> (long) value).get());
            string.append("\nDouble: " + optional.flatMap(value -> Optional.of((long) value)).get());
        }
    }

}

