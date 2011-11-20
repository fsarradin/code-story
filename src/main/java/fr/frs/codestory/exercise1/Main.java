package fr.frs.codestory.exercise1;

import com.google.common.collect.Iterables;

import static com.google.common.collect.Iterables.limit;
import static com.google.common.collect.Iterables.transform;
import static fr.frs.codestory.exercise1.Iterables2.allIntegersFrom;

public class Main {

    public static void main(String[] args) {
        final Iterable<Integer> from1To100 = limit(allIntegersFrom(1), 100);

        for (String n : transform(from1To100, FooBarQix.TO_FOO_BAR_QIX)) {
            System.out.println(n);
        }
    }

}
