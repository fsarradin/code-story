package fr.frs.codestory.foobarqix;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class FooBarQix {

    // NavigableMap keeps the order of appearance
    private static final NavigableMap<Integer, String> FILTERS = new TreeMap<Integer, String>() {{
        put(3, "Foo");
        put(5, "Bar");
        put(7, "Qix");
    }};

    public static String toFooBarQix(int n) {
        String result = getFoobarqixFromDivisions(n);

        final String stringOfN = String.valueOf(n);

        result += getFoobarqixFromDigits(stringOfN);

        if (result.isEmpty()) {
            result = stringOfN;
        }
        return result;
    }

    private static String getFoobarqixFromDigits(String stringOfN) {
        String result = "";

        for (char c : stringOfN.toCharArray()) {
            int digit = Character.digit(c, 10);
            if (FILTERS.containsKey(digit)) {
                result += FILTERS.get(digit);
            }
        }
        return result;
    }

    private static String getFoobarqixFromDivisions(int n) {
        String result = "";
        for (Map.Entry<Integer, String> filter : FILTERS.entrySet()) {
            if (n % filter.getKey() == 0) {
                result += filter.getValue();
            }
        }
        return result;
    }


    public static void main(String[] args) {
        for (int n = 1; n <= 100; n++) {
            System.out.println(toFooBarQix(n));
        }
    }
}
