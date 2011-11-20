package fr.frs.codestory.exercise1;

import com.google.common.base.Function;

public class Functions2 {

    public static <T, R> Function<Function<T, R>, R> apply(final T value) {
        return new Function<Function<T, R>, R>() {
            public R apply(Function<T, R> function) {
                return function.apply(value);
            }
        };
    }

}
