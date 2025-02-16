package com.wizardlybump17.moneymanagement.transaction;

import com.wizardlybump17.moneymanagement.account.Account;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

/**
 * @param id the id of this request
 * @param from the {@link Account#id()} of the {@link Account} that is sending the money
 * @param to the {@link Account#id()} of the {@link Account} that is receiving the money
 * @param amount the amount of money of this request
 * @param when when this request happened
 */
public record TransactionRequest(@NotNull UUID id, @NotNull UUID from, @NotNull UUID to, @NotNull BigDecimal amount, @NotNull Instant when) {
}
