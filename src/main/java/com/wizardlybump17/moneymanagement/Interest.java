package com.wizardlybump17.moneymanagement;

import lombok.NonNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public record Interest(@NonNull Instant start, @NonNull Instant end, @NonNull BigDecimal rate, @NonNull ChronoUnit timeUnit) {

    public @NonNull BigDecimal apply(@NonNull Instant start, @NonNull Instant end, @NonNull BigDecimal amount) {
        if (start.isAfter(end))
            throw new IllegalArgumentException();

        Instant realEnd = this.end.isAfter(end) ? end : this.end;
        Duration duration = Duration.between(start, realEnd);
        long difference = switch (timeUnit) {
            case MILLIS -> duration.toMillis();
            case SECONDS -> duration.toSeconds();
            case MINUTES -> duration.toMinutes();
            case HOURS -> duration.toHours();
            case DAYS -> duration.toDays();
            case WEEKS -> duration.toDays() / 7;
            case MONTHS -> duration.toDays() / 30;
            case YEARS -> duration.toDays() / 365;
            default -> throw new IllegalArgumentException();
        };

        return amount.multiply(rate.add(BigDecimal.ONE).pow((int) difference)).subtract(amount).round(MathContext.DECIMAL32);
    }
}
