package com.wizardlybump17.moneymanagement;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public record Transaction(@NotNull UUID from, @NotNull UUID to, @NotNull BigDecimal amount, @NotNull Instant when) {
}
