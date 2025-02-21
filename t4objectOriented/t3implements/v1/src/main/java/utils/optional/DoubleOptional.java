package utils.optional;

public final class DoubleOptional {

    private static final DoubleOptional EMPTY = new DoubleOptional(null);
    private final Double value;

    public static DoubleOptional empty() {
        return EMPTY;
    }

    private DoubleOptional(Double value) {
        this.value = value;
    }

    public static DoubleOptional of(Double value) {
        assert value != null;

        return new DoubleOptional(value);
    }

    public static DoubleOptional ofNullable(Double value) {
        return value == null ? EMPTY : new DoubleOptional(value);
    }

    public Double get() {
        assert this.value != null;
        
        return this.value;
    }

    public boolean isPresent() {
        return !this.isEmpty();
    }

    public boolean isEmpty() {
        return this.value == null;
    }

    public void ifPresent(DoubleConsumer consumer) {
        if (this.value != null) {
            consumer.accept(value);
        }
    }

    public void ifPresentOrElse(DoubleConsumer consumer, Runnable runner) {
        if (value != null) {
            consumer.accept(value);
        } else {
            runner.run();
        }
    }

    public DoubleOptional filter(DoublePredicate predicate) {
        assert this.value != null;

        if (isEmpty()) {
            return this;
        } else {
            return predicate.test(value) ? this : empty();
        }
    }

    public IntegerOptional mapToDouble(DoubleToIntegerFunction function) {
        assert this.value != null;

        if (isEmpty()) {
            return IntegerOptional.empty();
        } else {
            return IntegerOptional.ofNullable(function.apply(value));
        }
    }

    public IntegerOptional flatMapToDouble(DoubleToIntegerFunction function) {
        assert this.value != null;

        if (isEmpty()) {
            return IntegerOptional.empty();
        } else {
            IntegerOptional r = IntegerOptional.of(function.apply(value));
            assert r != null;

            return r;
        }
    }

    public DoubleOptional or(DoubleSupplier supplier) {
        assert this.value != null;

        if (isPresent()) {
            return this;
        } else {
            Double r = supplier.get();
            assert r != null;

            return DoubleOptional.of(r);
        }
    }

    public Double orElse(Double value) {
        return this.value != null ? this.value : value;
    }

    public Double orElseGet(DoubleSupplier supplier) {
        return value != null ? this.value : supplier.get();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        return object instanceof DoubleOptional optional
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
