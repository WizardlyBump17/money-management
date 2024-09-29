package com.wizardlybump17.moneymanagement;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Data
public class Transaction {

    private final @NonNull UUID from;
    private final @NonNull UUID to;
    private final @NonNull BigDecimal amount;
    private final @NonNull Instant when;
}
