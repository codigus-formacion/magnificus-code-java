import utils.interval.Interval;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.BiFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.microsoft.azure.eventhubs.impl.Operation;

import utils.Console;

public class StreamsApp {

    public static void main(String[] args) {
        creationTest();
        List<List<Interval>> integerListList = List.of(
                List.of(),
                List.of(new Interval(-1, 1)),
                List.of(new Interval(-1, 1), new Interval(-2, 2)),
                List.of(new Interval(-1, 1), new Interval(-2, 2), new Interval(-3, 3), new Interval(-4, 4)));
        integerListList.forEach(list -> {
            terminalTest(list);
            intermediateTest(list);
            toStringTest(list);
        });
    }

    private static void creationTest() {
        writeln("- creationTest");
        writeln("Stream Interval [-1,1]: ", List.of(new Interval(-1, 1)).stream());
        writeln("Stream Interval [-1,1][-2,2]: ", Set.of(new Interval(-1, 1), new Interval(-2, 2)).stream());
        writeln("Stream Interval [-1,1][-2,2][-3,3][-4,4]: ",
                Stream.of(new Interval(-1, 1), new Interval(-2, 2), new Interval(-3, 3), new Interval(-4, 4)));
        writeln("Stream empty: ", Stream.empty());
        writeln("Stream Random: ", Stream.generate(() -> {
            Random random = new Random();
            double min = random.nextDouble();
            return new Interval(min, min + random.nextDouble());
        }));
    }

    private static void writeln(String string) {
        Console.instance().writeln(string);
    }

    private static <T> void writeln(String title, Stream<T> stream) {
        writeln(title + stream
                .map(element -> element.toString())
                .collect(Collectors.joining(", ", "[", "]")));
    }

    private static <T> void terminalTest(List<T> list, Predicate<T> predicate, Consumer<T> consumer) {
        writeln("------------");
        writeln("elementos: ", list.stream());
        writeln("- terminalTest");
        toNumberTest(list);
        toBooleanTest(list, predicate);
        toCollectionTest(list);
        voidTest(list, consumer);
    }

    private static <T> void toNumberTest(List<T> list) {
        writeln("-- toNumberTest");
        writeln("findFirst: " + list.stream().findFirst());
        writeln("findAny: " + list.stream().findAny());
        writeln("count: " + list.stream().count());
    }

    private static <T> void toBooleanTest(List<T> list, Predicate<T> predicate) {
        writeln("-- toBooleanTest");
        writeln("allMatch: " + list.stream().allMatch(predicate));
        writeln("anyMatch: " + list.stream().anyMatch(predicate));
        writeln("noneMatch: " + list.stream().noneMatch(predicate));
    }

    private static <T> void toCollectionTest(List<T> list) {
        Console.instance().writeln("- toCollectionTest");
        Console.instance().writeln("collect toList: " + list.stream().collect(Collectors.toList()));
        Console.instance().writeln("collect toSet: " + list.stream().collect(Collectors.toSet()));
    }

    private static <T> void voidTest(List<T> list, Consumer<T> consumer) {
        writeln("-- voidTest");
        list.stream().forEach(consumer);
        list.stream().forEachOrdered(consumer);
    }

    private static <T> void intermediateTest(List<T> list) {
        writeln("- intermediateTest");
        substreamTest(list);
        converterTest(list);
    }

    private static <T> void substreamTest(List<T> list, Predicate<T> predicate) {
        writeln("-- substreamTest");
        writeln("filter: ", list.stream().filter(predicate));
        writeln("takeWhile: ", list.stream().takeWhile(predicate));
        writeln("limit 5: ", list.stream().limit(5));
        writeln("dropWhile: ", list.stream().dropWhile(predicate));
        writeln("skip: ", list.stream().skip(5));
        writeln("distinct: ", list.stream().distinct());
        writeln("sorted: ", list.stream().sorted());
        writeln("unordered: ", list.stream().unordered());
    }

    private static <T, R> void converterTest(List<T> list, UnaryOperator<T> operator, Function<T, Stream<T>> function, BiFunction<T, Stream<T>, T> bifunction) {
        writeln("-- converterTest");
        writeln("map scale 2: ", list.stream().map(operator));
        writeln("map split 2: ", list.stream().flatMap(function));
        writeln("map scale, symetric, scale: ",
                list.stream()
                        .<Interval>mapMulti(bifunction));
    }

    private static <T> void toStringTest(List<T> list) {
        writeln("toString: " + list.stream().toString());
        writeln("joining - : " + list.stream()
                .map(element -> element.toString())
                .collect(Collectors.joining(" - ")));
        writeln("joining - [ ] : ", list.stream());
    }

}
