package com.wizardlybump17.moneymanagement.transaction;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @param id         the id of this transaction
 * @param requestId  the id of the {@link TransactionRequest} that created this transaction
 * @param fromChange the balance change from the account that sent the money
 * @param toChange   the balance change from the account that received the money
 * @param result     the result of this transaction
 */
public record Transaction(@NotNull UUID id, @NotNull UUID requestId, @NotNull BalanceChange fromChange,
                          @NotNull BalanceChange toChange, @NotNull TransactionResult result) {

    public record BalanceChange(@NotNull BigDecimal before, @NotNull BigDecimal after) {

        public @NotNull BigDecimal change() {
            return after.subtract(before);
        }
    }
}
