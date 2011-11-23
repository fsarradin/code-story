package fr.frs.codestory.exercise1;

import com.google.common.base.Function;

public class Functions2 {

    /**
     * Return a function that waits for another function to apply the given value on.
     *
     * @param value value to apply
     * @param <T>
     * @param <R>
     * @return a function that waits for another function to apply the given value on
     */
    public static <T, R> Function<Function<T, R>, R> apply(final T value) {
        return new Function<Function<T, R>, R>() {
            public R apply(Function<T, R> function) {
                return function.apply(value);
            }
        };
    }

}
