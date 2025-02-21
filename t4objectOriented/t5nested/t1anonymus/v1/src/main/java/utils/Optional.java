package utils;

import java.util.NoSuchElementException;
import java.util.Objects;

public final class Optional<T> {

    private static final Optional<?> EMPTY = new Optional<>(null);
    private final T value;

    public static <T> Optional<T> empty() {
        @SuppressWarnings("unchecked")
        Optional<T> empty = (Optional<T>) EMPTY;
        return empty;
    }

    private Optional(T value) {
        this.value = value;
    }

    public static <T> Optional<T> of(T value) {
        return new Optional<>(Objects.requireNonNull(value));
    }

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> ofNullable(T value) {
        return value == null ? (Optional<T>) EMPTY
                : new Optional<>(value);
    }

    public T get() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }

    public boolean isPresent() {
        return !this.isEmpty();
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public void ifPresent(Consumer<? super T> consumer) {
        if (this.value != null) {
            consumer.accept(value);
        }
    }

    public void ifPresentOrElse(Consumer<? super T> consumer, Runnable runner) {
        if (value != null) {
            consumer.accept(value);
        } else {
            runner.run();
        }
    }

    public Optional<T> filter(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        if (isEmpty()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }

    public <U> Optional<U> map(Function<? super T, ? extends U> function) {
        Objects.requireNonNull(function);
        if (isEmpty()) {
            return empty();
        } else {
            return Optional.ofNullable(function.apply(value));
        }
    }

    public <U> Optional<U> flatMap(Function<? super T, ? extends Optional<? extends U>> function) {
        Objects.requireNonNull(function);
        if (isEmpty()) {
            return empty();
        } else {
            @SuppressWarnings("unchecked")
            Optional<U> r = (Optional<U>) function.apply(value);
            return Objects.requireNonNull(r);
        }
    }

    public Optional<T> or(Supplier<? extends Optional<? extends T>> supplier) {
        Objects.requireNonNull(supplier);
        if (isPresent()) {
            return this;
        } else {
            @SuppressWarnings("unchecked")
            Optional<T> r = (Optional<T>) supplier.get();
            return Objects.requireNonNull(r);
        }
    }

    public T orElse(T value) {
        return this.value != null ? this.value : value;
    }

    public T orElseGet(Supplier<? extends T> supplier) {
        return value != null ? this.value : supplier.get();
    }

    public T orElseThrow() {
        if (this.value == null) {
            throw new NoSuchElementException("No value present");
        }
        return this.value;
    }

    public <X extends Throwable> T orElseThrow(Supplier<? extends X> supplier) throws X {
        if (this.value != null) {
            return this.value;
        } else {
            throw supplier.get();
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        return object instanceof Optional<?> optional
                && Objects.equals(this.value, optional.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Override
    public String toString() {
        return this.value != null
                ? ("Optional[" + value + "]")
                : "Optional.empty";
    }

}
