import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    
    public static void main(String[] args){
        Stream<Integer> s = Arrays.asList(1,2,3).stream();
        Stream<Integer> xx = Optional.of(3).stream();
        IntStream s2 = IntStream.range(0, 3);
    }
}
