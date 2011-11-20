package fr.frs.codestory.exercise1;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

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

    public static String toFooBarQix(int n) {
        String result = getFoobarqixFromDivisibilities(n);
        result += getFoobarqixFromDigits(n);

        if (result.isEmpty()) {
            result = String.valueOf(n);
        }
        return result;
    }

    private static String getFoobarqixFromDigits(int n) {
        String stringOfN = String.valueOf(n);
        StringBuilder result = new StringBuilder();

        for (char c : stringOfN.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (FILTERS.containsKey(digit)) {
                result.append(FILTERS.get(digit));
            }
        }
        return result.toString();
    }

    private static String getFoobarqixFromDivisibilities(int n) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> filter : FILTERS.entrySet()) {
            if (n % filter.getKey() == 0) {
                result.append(filter.getValue());
            }
        }
        return result.toString();
    }

}
