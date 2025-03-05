package util.functional;

public interface BinaryOperator<T> {

    T apply(T acc, T element);

}
