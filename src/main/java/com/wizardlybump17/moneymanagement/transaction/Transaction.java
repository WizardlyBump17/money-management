package com.wizardlybump17.moneymanagement.transaction;

import com.wizardlybump17.moneymanagement.account.Account;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @param from the {@link Account#id()} of the {@link Account} that is sending the money
 * @param to the {@link Account#id()} of the {@link Account} that is receiving the money
 * @param amount the amount of money of this transaction
 * @param when when this transaction happened
 */
public record Transaction(int from, int to, @NotNull BigDecimal amount, @NotNull Instant when) {
}
