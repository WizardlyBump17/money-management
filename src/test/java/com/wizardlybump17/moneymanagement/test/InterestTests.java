package com.wizardlybump17.moneymanagement.test;

import com.wizardlybump17.moneymanagement.Interest;
import com.wizardlybump17.moneymanagement.test.util.AssertionUtil;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.*;
import java.time.temporal.ChronoUnit;

class InterestTests {

    @Test
    void testApplyMillis() {
        BigDecimal rate = BigDecimal.valueOf(0.1);

        Interest one = getInterest(1, rate, ChronoUnit.MILLIS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(110.0), one.apply(one.start(), one.end(), BigDecimal.valueOf(100)));

        Interest two = getInterest(2, rate, ChronoUnit.MILLIS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(121.0), two.apply(two.start(), two.end(), BigDecimal.valueOf(100)));

        Interest three = getInterest(3, rate, ChronoUnit.MILLIS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(133.1), three.apply(three.start(), three.end(), BigDecimal.valueOf(100)));
    }

    @Test
    void testApplyMinutes() {
        BigDecimal rate = BigDecimal.valueOf(0.1);

        Interest one = getInterest(1, rate, ChronoUnit.MINUTES);
        AssertionUtil.assertEquals(BigDecimal.valueOf(110.0), one.apply(one.start(), one.end(), BigDecimal.valueOf(100)));

        Interest two = getInterest(2, rate, ChronoUnit.MINUTES);
        AssertionUtil.assertEquals(BigDecimal.valueOf(121.0), two.apply(two.start(), two.end(), BigDecimal.valueOf(100)));

        Interest three = getInterest(3, rate, ChronoUnit.MINUTES);
        AssertionUtil.assertEquals(BigDecimal.valueOf(133.1), three.apply(three.start(), three.end(), BigDecimal.valueOf(100)));
    }

    @Test
    void testApplyHours() {
        BigDecimal rate = BigDecimal.valueOf(0.1);

        Interest one = getInterest(1, rate, ChronoUnit.HOURS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(110.0), one.apply(one.start(), one.end(), BigDecimal.valueOf(100)));

        Interest two = getInterest(2, rate, ChronoUnit.HOURS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(121.0), two.apply(two.start(), two.end(), BigDecimal.valueOf(100)));

        Interest three = getInterest(3, rate, ChronoUnit.HOURS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(133.1), three.apply(three.start(), three.end(), BigDecimal.valueOf(100)));
    }

    @Test
    void testApplyDays() {
        BigDecimal rate = BigDecimal.valueOf(0.1);

        Interest one = getInterest(1, rate, ChronoUnit.DAYS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(110.0), one.apply(one.start(), one.end(), BigDecimal.valueOf(100)));

        Interest two = getInterest(2, rate, ChronoUnit.DAYS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(121.0), two.apply(two.start(), two.end(), BigDecimal.valueOf(100)));

        Interest three = getInterest(3, rate, ChronoUnit.DAYS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(133.1), three.apply(three.start(), three.end(), BigDecimal.valueOf(100)));
    }

    @Test
    void testApplyWeeks() {
        BigDecimal rate = BigDecimal.valueOf(0.1);

        Interest one = getInterest(1, rate, ChronoUnit.WEEKS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(110.0), one.apply(one.start(), one.end(), BigDecimal.valueOf(100)));

        Interest two = getInterest(2, rate, ChronoUnit.WEEKS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(121.0), two.apply(two.start(), two.end(), BigDecimal.valueOf(100)));

        Interest three = getInterest(3, rate, ChronoUnit.WEEKS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(133.1), three.apply(three.start(), three.end(), BigDecimal.valueOf(100)));
    }

    @Test
    void testApplyMonths() {
        BigDecimal rate = BigDecimal.valueOf(0.1);

        Interest one = getInterest(1, rate, ChronoUnit.MONTHS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(110.0), one.apply(one.start(), one.end(), BigDecimal.valueOf(100)));

        Interest two = getInterest(2, rate, ChronoUnit.MONTHS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(121.0), two.apply(two.start(), two.end(), BigDecimal.valueOf(100)));

        Interest three = getInterest(3, rate, ChronoUnit.MONTHS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(133.1), three.apply(three.start(), three.end(), BigDecimal.valueOf(100)));
    }

    @Test
    void testApplyYears() {
        BigDecimal rate = BigDecimal.valueOf(0.1);

        Interest one = getInterest(1, rate, ChronoUnit.YEARS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(110.0), one.apply(one.start(), one.end(), BigDecimal.valueOf(100)));

        Interest two = getInterest(2, rate, ChronoUnit.YEARS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(121.0), two.apply(two.start(), two.end(), BigDecimal.valueOf(100)));

        Interest three = getInterest(3, rate, ChronoUnit.YEARS);
        AssertionUtil.assertEquals(BigDecimal.valueOf(133.1), three.apply(three.start(), three.end(), BigDecimal.valueOf(100)));
    }

    static @NotNull Interest getInterest(long time, @NotNull BigDecimal rate, @NotNull ChronoUnit timeUnit) {
        Instant start = Instant.from(ZonedDateTime.of(LocalDate.of(2024, Month.JANUARY, 1).atStartOfDay(), ZoneOffset.UTC));
        Instant end = switch (timeUnit) {
            case WEEKS -> start.plus(time * 7, ChronoUnit.DAYS);
            case MONTHS -> start.plus(time * 30, ChronoUnit.DAYS);
            case YEARS -> start.plus(time * 365, ChronoUnit.DAYS);
            default -> start.plus(time, timeUnit);
        };
        return new Interest(start, end, rate, timeUnit);
    }
}
