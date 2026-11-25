package pl.ninan.pricing.domain;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public record Product(UUID id, String name, BigDecimal price) {

    public Product {
        Objects.requireNonNull(id, "Id must not be null");
        Objects.requireNonNull(name, "Name must not be null");
        Objects.requireNonNull(price, "Price must not be null");
        if (price.signum() < 0) {
            throw new IllegalArgumentException("Price must not be negative");
        }
    }
}