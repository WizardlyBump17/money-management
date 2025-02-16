package com.wizardlybump17.moneymanagement.test.util;

import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.AssertionFailureBuilder;

public final class AssertionUtil {

    private AssertionUtil() {
    }

    public static <T extends Comparable<T>> void assertEquals(@Nullable T expected, @Nullable T actual) {
        if (expected == null) {
            if (actual != null) {
                AssertionFailureBuilder.assertionFailure()
                        .expected(null)
                        .actual(actual)
                        .buildAndThrow();
            }
            return;
        }

        if (actual == null) {
            AssertionFailureBuilder.assertionFailure()
                    .expected(expected)
                    .actual(null)
                    .buildAndThrow();
            return;
        }

        int comparison = expected.compareTo(actual);
        if (comparison != 0) {
            AssertionFailureBuilder.assertionFailure()
                    .expected(expected)
                    .actual(actual)
                    .buildAndThrow();
        }
    }

    public static <T extends Comparable<T>> void assertNotEquals(@Nullable T expected, @Nullable T actual) {
        if (expected == null) {
            if (actual == null) {
                AssertionFailureBuilder.assertionFailure()
                        .reason("expected: not equal but was: <null>")
                        .buildAndThrow();
            }
            return;
        }

        if (actual != null) {
            int comparison = expected.compareTo(actual);
            if (comparison == 0) {
                AssertionFailureBuilder.assertionFailure()
                        .reason("expected: not equal but was: <" + actual + ">")
                        .buildAndThrow();
            }
        }
    }
}
