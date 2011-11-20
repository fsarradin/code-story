package fr.frs.codestory.exercise1;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.AbstractIterator;

import java.util.Iterator;

public class Iterables2 {
    public static Iterable<Integer> allIntegersFrom(final int n) {
        return new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                return new AbstractIterator<Integer>() {
                    int value = n;

                    @Override
                    protected Integer computeNext() {
                        Integer current = value;
                        value++;
                        return current;
                    }
                };
            }
        };
    }

    public static <T> Optional<T> join(Iterable<Optional<T>> iterable, Function<Optional<T>, Function<Optional<T>, Optional<T>>> joiner) {
        Optional<T> result = Optional.absent();
        for (Optional<T> value : iterable) {
            result = joiner.apply(result).apply(value);
        }
        return result;
    }
}
