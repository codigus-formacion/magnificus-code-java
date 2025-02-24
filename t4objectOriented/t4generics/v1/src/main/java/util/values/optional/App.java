package util.values.optional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import util.Console;
import util.values.interval.DoubleInterval;

public class App {


    public static void main(String[] args) {
        List<Optional<Integer>> intergerOptionals = Arrays.asList(
                Optional.empty(),
                Optional.of(1),
                Optional.of(2),
                Optional.ofNullable(null),
                Optional.ofNullable(1),
                Optional.ofNullable(2));
        intergerOptionals.forEach(optional -> testInteger(optional));

        List<Optional<DoubleInterval>> intervalOptionals = Arrays.asList(
                Optional.empty(),
                Optional.of(new DoubleInterval(1, 2)),
                Optional.of(new DoubleInterval(10, 20)),
                Optional.ofNullable(null),
                Optional.ofNullable(new DoubleInterval(1, 2)),
                Optional.ofNullable(new DoubleInterval(1, 2)));
        intervalOptionals.forEach(optional -> testInterval(optional));

        intergerOptionals.forEach(optional -> test(optional, 0, value -> value.doubleValue()));

        class IntervalToDoubleFunction implements Function<DoubleInterval,Double> {

            @Override
            public Double apply(DoubleInterval interval) {
                return interval.length();
            }

        }
        intervalOptionals.forEach(optional -> test(optional, new DoubleInterval(0,0), 
            new IntervalToDoubleFunction()));

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
            Console.instance().writeln(optional.map(value -> (long) value).get());

            Console.instance().writeln(optional.flatMap(value -> Optional.of((long) value)).get());
        }
    }

    private static void testInterval(Optional<DoubleInterval> optional) {
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

        Console.instance().writeln("Defecto: " + optional.orElse(new DoubleInterval(0, 0)));

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

        Console.instance().writeln("Lo que sea: " + optional.orElseGet(() -> new DoubleInterval(0, 0)));

        Console.instance().writeln("Defecto: " + optional.or(() -> Optional.of(new DoubleInterval(0, 0))));

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
            Console.instance().writeln(optional.map(value -> value.length()).get());

            Console.instance().writeln(optional.flatMap(value -> Optional.of(value.length())).get());
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
            Console.instance().writeln(optional.map(value -> function.apply(value)).get());

            Console.instance().writeln(optional.flatMap(value -> Optional.of(function.apply(value))).get());
        }
    }
}
