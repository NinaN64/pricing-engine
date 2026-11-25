package pl.ninan.pricing.domain;

import java.util.Objects;
import java.util.UUID;

public record Customer(UUID id, CustomerType customerType) {

    public Customer {
        Objects.requireNonNull(id, "Id must not be null");
        Objects.requireNonNull(customerType, "CustomerType must not be null");
    }
}