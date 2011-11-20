package fr.frs.codestory.exercise1;

import com.google.common.base.Function;
import com.google.common.base.Optional;

import java.util.NavigableMap;
import java.util.TreeMap;

import static com.google.common.collect.Iterables.concat;
import static com.google.common.collect.Iterables.transform;
import static com.google.common.collect.Lists.charactersOf;
import static fr.frs.codestory.exercise1.Iterables2.join;
import static fr.frs.codestory.exercise1.Maps2.getFrom;

/**
 * Solution to the FooBarQix problem.
 */
public class FooBarQix {

    // NavigableMap keeps the order of appearance
    private static final NavigableMap<Integer, String> FILTERS = new TreeMap<Integer, String>() {{
        put(3, "Foo");
        put(5, "Bar");
        put(7, "Qix");
    }};

    /**
     * Curryfied function that returns Foo, Bar, or Qix according to the divisibility of two numbers.
     *
     * @param divisor
     * @param value
     * @return a string if value is divisible by divisor or nothing
     *
     * @type Integer -> Integer -> Optional String
     */
    private static final Function<Integer, Function<Integer, Optional<String>>> FOOBARQIX_FROM_DIVISIBILITY = new Function<Integer, Function<Integer, Optional<String>>>() {
        public Function<Integer, Optional<String>> apply(final Integer divisor) {
            return new Function<Integer, Optional<String>>() {
                public Optional<String> apply(Integer value) {
                    if (value % divisor != 0) return Optional.absent();
                    else return Optional.of(FILTERS.get(divisor));
                }
            };
        }
    };

    /**
     * Iterable of FOOBARQIX_FROM_DIVISIBILITY functions initiated with the values 3, 5, and 7. Each function of this
     * iterable awaits for a number to return the string Foo, Bar, Qix, or nothing.
     *
     * @type Iterable (Integer -> Optional String)
     */
    private static final Iterable<Function<Integer, Optional<String>>> FOOBARQIX_FROM_DIVISIBILITIES = transform(FILTERS.navigableKeySet(), FOOBARQIX_FROM_DIVISIBILITY);

    /**
     *
     * @param value
     * @return
     * @type Integer -> (Integer -> Optional String) -> Optional String
     */
    private static Function<Function<Integer, Optional<String>>, Optional<String>> appliedTo(Integer value) {
        return Functions2.apply(value);
    }

    /**
     * Join strings that are not nothing.
     *
     * @type Optional String -> Optional String -> Optional String
     */
    public static final Function<Optional<String>, Function<Optional<String>, Optional<String>>> OPTIONAL_STRING_JOINER = new Function<Optional<String>, Function<Optional<String>, Optional<String>>>() {
        public Function<Optional<String>, Optional<String>> apply(final Optional<String> string1) {
            return new Function<Optional<String>, Optional<String>>() {
                public Optional<String> apply(Optional<String> string2) {
                    if (!string1.isPresent()) return string2;
                    else if (!string2.isPresent()) return string1;
                    else return Optional.of(string1.get() + string2.get());
                }
            };
        }
    };

    /**
     * Convert a digit into Foo, Bar, Qix, or nothing.
     *
     * @type Character -> Optional String
     */
    private static final Function<Character, Optional<String>> FOOBARQIX_FROM_DIGIT = new Function<Character, Optional<String>>() {
        public Optional<String> apply(Character digit) {
            final int key = Character.digit(digit, 10);
            return getFrom(FILTERS, key);
        }
    };

    /**
     * @type Integer -> String
     */
    public static final Function<Integer, String> TO_FOO_BAR_QIX = new Function<Integer, String>() {
        public String apply(Integer value) {
            final String stringOfValue = String.valueOf(value);
            Iterable<Optional<String>> rule1Results = transform(FOOBARQIX_FROM_DIVISIBILITIES, appliedTo(value));
            Iterable<Optional<String>> rule2Results = transform(charactersOf(stringOfValue), FOOBARQIX_FROM_DIGIT);
            Optional<String> result = join(concat(rule1Results, rule2Results), OPTIONAL_STRING_JOINER);
            return result.or(stringOfValue);
        }
    };

}
