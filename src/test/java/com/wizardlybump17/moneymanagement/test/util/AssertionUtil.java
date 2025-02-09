package com.wizardlybump17.moneymanagement.test.util;

import org.jetbrains.annotations.Nullable;
import org.junit.jupiter.api.AssertionFailureBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;

public final class AssertionUtil {

    private AssertionUtil() {
    }

    public static void assertEquals(@Nullable BigInteger expected, @Nullable BigInteger actual) {
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

    public static void assertEquals(@Nullable BigDecimal expected, @Nullable BigDecimal actual) {
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
}
