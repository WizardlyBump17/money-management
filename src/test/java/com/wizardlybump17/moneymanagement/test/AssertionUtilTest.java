package com.wizardlybump17.moneymanagement.test;

import com.wizardlybump17.moneymanagement.test.util.AssertionUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

class AssertionUtilTest {

    @Test
    void testEqualsBigDecimal() {
        Random random = new Random(0);
        for (int i = 0; i < 100; i++) {
            BigDecimal value = BigDecimal.valueOf(random.nextDouble() + random.nextDouble() + random.nextDouble());
            Assertions.assertDoesNotThrow(() -> AssertionUtil.assertEquals(value, value));
        }
    }

    @Test
    void testNotEqualsBigDecimal() {
        Random random = new Random(0);
        for (int i = 0; i < 100; i++) {
            BigDecimal expected = BigDecimal.valueOf(random.nextDouble() + random.nextDouble() + random.nextDouble());
            BigDecimal value = BigDecimal.valueOf(random.nextDouble());
            Assertions.assertThrows(AssertionFailedError.class, () -> AssertionUtil.assertEquals(expected, value));
        }
    }

    @Test
    void testEqualsBigInteger() {
        Random random = new Random(0);
        for (int i = 0; i < 100; i++) {
            BigInteger value = BigInteger.valueOf(random.nextLong() + random.nextLong() + random.nextLong());
            Assertions.assertDoesNotThrow(() -> AssertionUtil.assertEquals(value, value));
        }
    }

    @Test
    void testNotEqualsBigInteger() {
        Random random = new Random(0);
        for (int i = 0; i < 100; i++) {
            BigInteger expected = BigInteger.valueOf(random.nextLong() + random.nextLong() + random.nextLong());
            BigInteger value = BigInteger.valueOf(random.nextLong());
            Assertions.assertThrows(AssertionFailedError.class, () -> AssertionUtil.assertEquals(expected, value));
        }
    }
}
