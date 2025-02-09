package com.wizardlybump17.moneymanagement.account;

import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public record Account(@NotNull UUID id, @NotNull UUID clientId) {
}
