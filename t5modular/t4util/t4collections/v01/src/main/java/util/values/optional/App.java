package util.values.optional;

import java.util.Arrays;
import java.util.List;

import util.Console;
import util.function.Function;
import util.values.interval.Interval;

public class App {

    public static void main(String[] args) {
        List<Optional<Integer>> intergerOptionals = Arrays.asList(
                Optional.empty(),
                Optional.of(1),
                Optional.of(2),
                Optional.ofNullable(null),
                Optional.ofNullable(1),
                Optional.ofNullable(2));
        intergerOptionals.stream().forEach(optional -> testInteger(optional));

        List<Optional<Interval>> intervalOptionals = Arrays.asList(
                Optional.empty(),
                Optional.of(new Interval(1, 2)),
                Optional.of(new Interval(10, 20)),
                Optional.ofNullable(null),
                Optional.ofNullable(new Interval(1, 2)),
                Optional.ofNullable(new Interval(1, 2)));
        intervalOptionals.stream().forEach(optional -> testInterval(optional));

        intergerOptionals.stream().forEach(optional -> test(optional, 0, value -> value.doubleValue()));
        intervalOptionals.stream().forEach(optional -> test(optional, new Interval(0, 0), value -> value.length()));

        Console.close();
    }

    private static void testInteger(Optional<Integer> optional) {
        Console.instance().writeln("---------");

        Console.instance().writeln(optional.toString());

        Console.instance().writeln("Es null? " + optional.equals(Optional.empty()));
        Console.instance().writeln("Es 1 presente? " + optional.equals(Optional.of(1)));

        if (optional.isPresent()) {
            Console.instance().writeln("Presente: " + optional.get());
        }

        if (optional.isEmpty()) {
            Console.instance().writeln("Vacío!");
        }

        Console.instance().writeln("Defecto: " + optional.orElse(0));

        try {
            Console.instance().writeln("Excepcional? " + optional.orElseThrow());
        } catch (Exception e) {
            Console.instance().writeln(e);
        }

        //

        optional.ifPresent(value -> {
            Console.instance().writeln(optional.get());
        });

        optional.ifPresentOrElse(value -> {
            Console.instance().writeln(optional.get());
        }, () -> {
            Console.instance().writeln("Vacío");
        });

        Console.instance().writeln("Lo que sea: " + optional.orElseGet(() -> 0));

        Console.instance().writeln("Defecto: " + optional.or(() -> Optional.of(0)));

        try {
            Console.instance().writeln("Lo que sea: " + optional.orElseThrow(() -> new Exception("Excepcional!!!")));
        } catch (Exception e) {
            Console.instance().writeln("Vacío");
        }

        optional.filter(value -> value % 2 == 0)
                .ifPresent(value -> {
                    Console.instance().writeln("Par: " + value);
                });

        if (optional.isPresent()) {
            Console.instance().writeln("Double: " + optional.map(value -> (long) value).get());

            Console.instance().writeln("Double: " + optional.flatMap(value -> Optional.of((long) value)).get());
        }
    }

    private static void testInterval(Optional<Interval> optional) {
        Console.instance().writeln("---------");

        Console.instance().writeln(optional.toString());

        Console.instance().writeln("Es null? " + optional.equals(Optional.empty()));
        Console.instance().writeln("Es 1 presente? " + optional.equals(Optional.of(1)));

        if (optional.isPresent()) {
            Console.instance().writeln("Presente: " + optional.get());
        }

        if (optional.isEmpty()) {
            Console.instance().writeln("Vacío!");
        }

        Console.instance().writeln("Defecto: " + optional.orElse(new Interval(0, 0)));

        try {
            Console.instance().writeln("Excepcional? " + optional.orElseThrow());
        } catch (Exception e) {
            Console.instance().writeln(e);
        }

        //

        optional.ifPresent(value -> {
            Console.instance().writeln(optional.get());
        });

        optional.ifPresentOrElse(value -> {
            Console.instance().writeln(optional.get());
        }, () -> {
            Console.instance().writeln("Vacío");
        });

        Console.instance().writeln("Lo que sea: " + optional.orElseGet(() -> new Interval(0, 0)));

        Console.instance().writeln("Defecto: " + optional.or(() -> Optional.of(new Interval(0, 0))));

        try {
            Console.instance().writeln("Lo que sea: " + optional.orElseThrow(() -> new Exception("Excepcional!!!")));
        } catch (Exception e) {
            Console.instance().writeln("Vacío");
        }

        optional.filter(value -> value.length() % 2 == 0)
                .ifPresent(value -> {
                    Console.instance().writeln("Par: " + value);
                });

        if (optional.isPresent()) {
            Console.instance().writeln("Double: " + optional.map(value -> value.length()).get());

            Console.instance().writeln("Double: " + optional.flatMap(value -> Optional.of(value.length())).get());
        }
    }

    private static <T> void test(Optional<T> optional, T defect, Function<T, Double> function) {
        Console.instance().writeln("---------");

        Console.instance().writeln(optional.toString());

        Console.instance().writeln("Es null? " + optional.equals(Optional.empty()));
        Console.instance().writeln("Es 1 presente? " + optional.equals(Optional.of(1)));

        if (optional.isPresent()) {
            Console.instance().writeln("Presente: " + optional.get());
        }

        if (optional.isEmpty()) {
            Console.instance().writeln("Vacío!");
        }

        Console.instance().writeln("Defecto: " + optional.orElse(defect));

        try {
            Console.instance().writeln("Excepcional? " + optional.orElseThrow());
        } catch (Exception e) {
            Console.instance().writeln(e);
        }

        //

        optional.ifPresent(value -> {
            Console.instance().writeln(optional.get());
        });

        optional.ifPresentOrElse(value -> {
            Console.instance().writeln(optional.get());
        }, () -> {
            Console.instance().writeln("Vacío");
        });

        Console.instance().writeln("Lo que sea: " + optional.orElseGet(() -> defect));

        Console.instance().writeln("Defecto: " + optional.or(() -> Optional.of(defect)));

        try {
            Console.instance().writeln("Lo que sea: " + optional.orElseThrow(() -> new Exception("Excepcional!!!")));
        } catch (Exception e) {
            Console.instance().writeln("Vacío");
        }

        optional.filter(value -> function.apply(value) % 2 == 0)
                .ifPresent(value -> {
                    Console.instance().writeln("Par: " + value);
                });

        if (optional.isPresent()) {
            Console.instance().writeln("Double: " + optional.map(value -> function.apply(value)).get());

            Console.instance()
                    .writeln("Double: " + optional.flatMap(value -> Optional.of(function.apply(value))).get());

            Console.instance().writeln("Cuántos: " + optional.stream().count());
        }
    }
}
