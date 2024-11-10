package com.wizardlybump17.moneymanagement;

import ch.obermuhlner.math.big.BigDecimalMath;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public record Interest(@NotNull Instant start, @NotNull Instant end, @NotNull BigDecimal rate, @NotNull ChronoUnit timeUnit) {

    public @NotNull BigDecimal apply(@NotNull Instant start, @NotNull Instant end, @NotNull BigDecimal amount) {
        if (start.isAfter(end))
            throw new IllegalArgumentException(start + " is after " + end);

        Instant realEnd = this.end.isAfter(end) ? end : this.end;
        Duration duration = Duration.between(start, realEnd);
        double difference = switch (timeUnit) {
            case MILLIS -> duration.toMillis();
            case SECONDS -> duration.toSeconds();
            case MINUTES -> duration.toMinutes();
            case HOURS -> duration.toHours();
            case DAYS -> duration.toDays();
            case WEEKS -> duration.toDays() / 7.0;
            case MONTHS -> duration.toDays() / 30.0;
            case YEARS -> duration.toDays() / 365.0;
            default -> throw new IllegalArgumentException();
        };

        return amount.multiply(BigDecimalMath.pow(rate.add(BigDecimal.ONE), BigDecimal.valueOf(difference), MathContext.DECIMAL128));
    }
}
