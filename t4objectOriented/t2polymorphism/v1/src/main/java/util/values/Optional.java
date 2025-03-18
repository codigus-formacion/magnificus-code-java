package util.values;

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
        assert value != null;

        return new Optional<>(value);
    }

    @SuppressWarnings("unchecked")
    public static <T> Optional<T> ofNullable(T value) {
        return value == null ? (Optional<T>) EMPTY
                : new Optional<>(value);
    }

    public T get() {
        assert this.value != null;

        return this.value;
    }

    public boolean isPresent() {
        return !this.isEmpty();
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public T orElse(T value) {
        return this.value != null ? this.value : value;
    }

    public T orElseThrow() {
        assert this.value != null;

        return this.value;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        Optional<?> optional = (Optional<?>) object;
        if (this.isEmpty() && optional.isEmpty()) {
            return true;
        }
        if (this.isEmpty() || optional.isEmpty()) {
            return false;
        }
        return this.value.equals(optional.value);
    }

    public int hashCode() {
        return this.value.hashCode();
    }

    public String toString() {
        return this.value != null
                ? ("Optional[" + value + "]")
                : "Optional.empty";
    }

}
