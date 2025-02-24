package util.streams;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import util.Console;
import util.values.interval.Interval;

public class IntStreamsApp {
    // Idem para LongStream y DoubleStream
    
    public static void main(String[] args) {
        creationTest();
        List<List<Integer>> integerListList = List.of(
                List.of(),
                List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
                List.of(0, 1, 2, 3),
                List.of(32, 65, 3, 77),
                List.of(1),
                List.of(1, 2, 3));
        integerListList.forEach(list -> {
            terminalTest(list);
            intermediateTest(list);
            toStringTest(list);
        });
    }

    private static void creationTest() {
        writeln("- creationTest");
        writeln("Arrays: ", Arrays.stream(new int[]{1, 2, 3}));
        writeln("IntStream List 1, 1, 1: ", List.of(1, 1, 1).stream().mapToInt(integer ->integer.intValue()));
        writeln("IntStream Set 1, 2, 3: ", Set.of(1, 2, 3).stream().mapToInt(integer -> integer.intValue()));
        writeln("IntStream 0, 1, 2, 3: ", IntStream.of(0, 1, 2, 3));
        writeln("IntStream empty: ", IntStream.empty());
        writeln("IntStream Random: ", IntStream.generate(() -> new Random().nextInt(10)).limit(10));
        writeln("IntStream range 0-10: ", IntStream.range(0, 10));
        writeln("IntStream rangeClosed 0-10: ", IntStream.rangeClosed(0, 10));
    }

    private static void writeln(String string) {
        Console.instance().writeln(string);
    }

    private static void writeln(String title, IntStream intStream) {
        writeln(title, intStream.boxed());
    }

    private static <T> void writeln(String title, Stream<T> stream) {
        writeln(title + stream
                .map(element -> element.toString())
                .collect(Collectors.joining(", ", "[", "]")));
    }

    private static void terminalTest(List<Integer> list) {
        writeln("------------");
        writeln("elementos: ", toIntStream(list));
        writeln("- terminalTest");
        toNumberTest(list);
        toBooleanTest(list);
        toCollectionTest(list);
        voidTest(list);
    }
    
    private static IntStream toIntStream(List<Integer> list) {
        return list.stream().mapToInt(integer -> integer.intValue());
    }

    private static void toNumberTest(List<Integer> list) {
        writeln("-- toNumberTest");
        writeln("findFirst: " + toIntStream(list).findFirst());
        writeln("findAny: " + toIntStream(list).findAny());
        writeln("count: " + toIntStream(list).count());

        writeln("min: " + toIntStream(list).min());
        writeln("max: " + toIntStream(list).max());
        writeln("sum: " + toIntStream(list).sum());
        writeln("average: " + toIntStream(list).average());
        writeln("summaryStatistics getCount: " + toIntStream(list).summaryStatistics().getCount());
        writeln("summaryStatistics getMin: " + toIntStream(list).summaryStatistics().getMin());
        writeln("summaryStatistics getMax: " + toIntStream(list).summaryStatistics().getMax());
        writeln("summaryStatistics getSum: " + toIntStream(list).summaryStatistics().getSum());
        writeln("summaryStatistics getAverage: " + toIntStream(list).summaryStatistics().getAverage());
    }

    private static void toBooleanTest(List<Integer> list) {
        writeln("-- toBooleanTest");
        writeln("allMatch > 5: " + toIntStream(list).allMatch(integer -> integer > 5));
        writeln("anyMatch > 5: " + toIntStream(list).anyMatch(integer -> integer > 5));
        writeln("noneMatch > 5: " + toIntStream(list).noneMatch(integer -> integer > 5));
    }

    private static void toCollectionTest(List<Integer> list) {
        Console.instance().writeln("- toCollectionTest");
        Console.instance().writeln("collect toList: " + toIntStream(list).boxed().collect(Collectors.toList()));
        Console.instance().writeln("collect toSet: " + toIntStream(list).boxed().collect(Collectors.toSet()));
        // más de collectors desde Stream<T>!!!
        String string = "array: [";
        for (Integer integer : toIntStream(list).toArray()) {
            string += integer + ", ";
        }
        writeln(string.substring(0, string.length() + (list.isEmpty() ? 0 : -2)) + "]");
    }

    private static void voidTest(List<Integer> list) {
        writeln("-- voidTest");
        toIntStream(list).forEach(integer -> {
            Console.instance().writeln(integer);
        });
        toIntStream(list).forEachOrdered(integer -> {
            Console.instance().writeln(integer);
        });
    }

    private static void intermediateTest(List<Integer> list) {
        writeln("- intermediateTest");
        substreamTest(list);
        converterTest(list);
    }

    private static void substreamTest(List<Integer> list) {
        writeln("-- substreamTest");
        writeln("filter %2==0: ", toIntStream(list).filter(integer -> integer % 2 == 0));
        writeln("takeWhile < 5: ", toIntStream(list).takeWhile(integer -> integer < 5));
        writeln("limit 5: ", toIntStream(list).limit(5));
        writeln("dropWhile < 5: ", toIntStream(list).dropWhile(integer -> integer < 5));
        writeln("skip 5: ", toIntStream(list).skip(5));
        writeln("distinct: ", toIntStream(list).distinct());
        writeln("sorted: ", toIntStream(list).sorted());
        writeln("unordered: ", toIntStream(list).unordered());
    }

    private static void converterTest(List<Integer> list) {
        writeln("-- converterTest");

        writeln("boxed: ", toIntStream(list).boxed());

        writeln("map + 1: ", toIntStream(list).map(integer -> integer + 1));
        Console.instance()
                .writeln("mapToDouble + 1, sum: " + toIntStream(list).mapToDouble(integer -> (double) integer).sum());
        Console.instance().writeln("asDoubleStream + 1, sum: " + toIntStream(list).asDoubleStream().sum());
        Console.instance()
                .writeln("mapToLong + 1, sum: " + toIntStream(list).mapToLong(integer -> (long) integer).sum());
        Console.instance().writeln("asLongStream + 1, sum: " + toIntStream(list).asLongStream().sum());
        Console.instance().writeln(
                "mapToObj Interval: "
                        + toIntStream(list).mapToObj(integer -> new Interval(-integer, integer)).toString());
        // Console.instance().writeln("map + 1: " + intStream.flatMap(integer -> integer
        // + 1));
        // Console.instance().writeln("map + 1: " + intStream.mapMulti(integer ->
        // integer + 1));
    }

    private static void toStringTest(List<Integer> list) {
        writeln("toString: " + toIntStream(list).toString());
        writeln("joining - : " + toIntStream(list)
                .boxed()
                .map(element -> element.toString())
                .collect(Collectors.joining(" - ")));
        writeln("joining - [ ] : ", toIntStream(list));
    }



}
