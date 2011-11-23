package fr.frs.codestory.exercise1;

import static com.google.common.collect.Iterables.limit;
import static com.google.common.collect.Iterables.transform;
import static fr.frs.codestory.exercise1.Iterables2.allIntegersFrom;

public class Main {

    public static void main(String[] args) {
        // iterable of all ordered integers from 1 to 100
        final Iterable<Integer> from1To100 = limit(allIntegersFrom(1), 100);

        // go through the integers, mapping each of them with the FooBarQix function
        for (String n : transform(from1To100, FooBarQix.TO_FOO_BAR_QIX)) {
            System.out.println(n);
        }
    }

}
