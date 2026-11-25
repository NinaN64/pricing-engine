package pl.ninan.pricing.domain;

import java.math.BigDecimal;
import java.util.Objects;

public record CartItem(Product product, int quantity) {

    public CartItem {
        Objects.requireNonNull(product, "Product must not be null");
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than 0");
        }
    }

    public BigDecimal lineTotal() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }
}