package utils.optional;

public final class IntegerOptional {

    private static final IntegerOptional EMPTY = new IntegerOptional(null);
    private final Integer value;

    public static IntegerOptional empty() {
        return EMPTY;
    }

    private IntegerOptional(Integer value) {
        this.value = value;
    }

    public static IntegerOptional of(Integer value) {
        assert value != null;

        return new IntegerOptional(value);
    }

    public static IntegerOptional ofNullable(Integer value) {
        return value == null ? EMPTY : new IntegerOptional(value);
    }

    public Integer get() {
        assert this.value != null;
        
        return this.value;
    }

    public boolean isPresent() {
        return !this.isEmpty();
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public void ifPresent(IntegerConsumer consumer) {
        if (this.value != null) {
            consumer.accept(value);
        }
    }

    public void ifPresentOrElse(IntegerConsumer consumer, Runnable runner) {
        if (value != null) {
            consumer.accept(value);
        } else {
            runner.run();
        }
    }

    public IntegerOptional filter(IntegerPredicate predicate) {
        assert this.value != null;

        if (isEmpty()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }

    public DoubleOptional mapToDouble(IntegerToDoubleFunction function) {
        assert this.value != null;

        if (isEmpty()) {
            return DoubleOptional.empty();
        } else {
            return DoubleOptional.ofNullable(function.apply(value));
        }
    }

    public DoubleOptional flatMapToDouble(IntegerToDoubleFunction function) {
        assert this.value != null;

        if (isEmpty()) {
            return DoubleOptional.empty();
        } else {
            DoubleOptional r = DoubleOptional.of(function.apply(value));
            assert r != null;

            return r;
        }
    }

    public IntegerOptional or(IntegerSupplier supplier) {
        assert this.value != null;

        if (isPresent()) {
            return this;
        } else {
            Integer r = supplier.get();
            assert r != null;

            return IntegerOptional.of(r);
        }
    }

    public Integer orElse(Integer value) {
        return this.value != null ? this.value : value;
    }

    public Integer orElseGet(IntegerSupplier supplier) {
        return value != null ? this.value : supplier.get();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        return object instanceof IntegerOptional optional
                && this.value.equals(optional.value);
    }

    @Override
    public String toString() {
        return this.value != null
                ? ("Optional[" + value + "]")
                : "Optional.empty";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

}
