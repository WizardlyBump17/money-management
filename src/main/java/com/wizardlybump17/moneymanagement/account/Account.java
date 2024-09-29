package com.wizardlybump17.moneymanagement.account;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@RequiredArgsConstructor
public class Account {

    private final @NonNull UUID id;
    private @NonNull String name;
    private @NonNull BigDecimal balance;

    public Account(@NonNull UUID id, @NonNull String name) {
        this(id, name, BigDecimal.ZERO);
    }
}
