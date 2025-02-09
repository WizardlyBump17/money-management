package com.wizardlybump17.moneymanagement.client;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.UUID;

public class Client {

    private final @NotNull UUID id;
    private @NotNull String name;

    public Client(@NotNull UUID id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }

    public @NotNull UUID getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
