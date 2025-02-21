import utils.interval.Interval;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import utils.Console;

public class IntervalStreamsApp {

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
        writeln("Stream Interval [-1,1][-2,2][-3,3][-4,4]: ", Stream.of(new Interval(-1, 1), new Interval(-2, 2), new Interval(-3, 3), new Interval(-4, 4)));
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

    private static void terminalTest(List<Interval> list) {
        writeln("------------");
        writeln("elementos: ", list.stream());
        writeln("- terminalTest");
        toNumberTest(list);
        toBooleanTest(list);
        toCollectionTest(list);
        voidTest(list);
    }

    private static void toNumberTest(List<Interval> list) {
        writeln("-- toNumberTest");
        writeln("findFirst: " + list.stream().findFirst());
        writeln("findAny: " + list.stream().findAny());
        writeln("count: " + list.stream().count());
    }

    private static void toBooleanTest(List<Interval> list) {
        writeln("-- toBooleanTest");
        writeln("allMatch > 5: " + list.stream().allMatch(interval -> interval.length() > 2));
        writeln("anyMatch > 5: " + list.stream().anyMatch(interval -> interval.length() > 2));
        writeln("noneMatch > 5: " + list.stream().noneMatch(interval -> interval.length() > 2));
    }

    private static void toCollectionTest(List<Interval> list) {
        Console.instance().writeln("- toCollectionTest");
        Console.instance().writeln("collect toList: " + list.stream().collect(Collectors.toList()));
        Console.instance().writeln("collect toSet: " + list.stream().collect(Collectors.toSet()));
        // más de collectors desde Stream<T>!!!
    }

    private static void voidTest(List<Interval> list) {
        writeln("-- voidTest");
        list.stream().forEach(integer -> {
            Console.instance().writeln(integer);
        });
        list.stream().forEachOrdered(integer -> {
            Console.instance().writeln(integer);
        });
    }

    private static void intermediateTest(List<Interval> list) {
        writeln("- intermediateTest");
        substreamTest(list);
        converterTest(list);
    }

    private static void substreamTest(List<Interval> list) {
        writeln("-- substreamTest");
        writeln("filter %2==0: ", list.stream().filter(interval -> interval.length() > 2));
        writeln("takeWhile < 5: ", list.stream().takeWhile(interval -> interval.length() > 2));
        writeln("limit 5: ", list.stream().limit(5));
        writeln("dropWhile < 5: ", list.stream().dropWhile(interval -> interval.length() > 2));
        writeln("skip 5: ", list.stream().skip(5));
        writeln("distinct: ", list.stream().distinct());
        writeln("sorted: ", list.stream().sorted());
        writeln("unordered: ", list.stream().unordered());
    }

    private static void converterTest(List<Interval> list) {
        writeln("-- converterTest");

        writeln("map scale 2: ", list.stream().map(interval -> interval.scale(2)));
        writeln("map split 2: ", list.stream().flatMap(interval -> Arrays.stream(interval.split(2))));
        writeln("map scale, symetric, scale: ",
                list.stream()
                        .<Interval>mapMulti((interval, consumer) -> {
                            consumer.accept(interval.scale(0.5));
                            consumer.accept(interval.symetric());
                            consumer.accept(interval.scale(2));
                        }));
    }

    private static void toStringTest(List<Interval> list) {
        writeln("toString: " + list.stream().toString());
        writeln("joining - : " + list.stream()
                .map(element -> element.toString())
                .collect(Collectors.joining(" - ")));
        writeln("joining - [ ] : ", list.stream());
    }

}
