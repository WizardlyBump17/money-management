package com.wizardlybump17.moneymanagement.transaction;

import org.jetbrains.annotations.Nullable;

public record TransactionResult(boolean success, @Nullable String error) {
}
